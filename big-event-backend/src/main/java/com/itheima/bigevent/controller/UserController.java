package com.itheima.bigevent.controller;

import com.itheima.bigevent.pojo.Result;
import com.itheima.bigevent.pojo.User;
import com.itheima.bigevent.service.UserService;
import com.itheima.bigevent.utils.JwtUtil;
import com.itheima.bigevent.utils.Md5Util;
import com.itheima.bigevent.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.Map;

import static com.itheima.bigevent.interceptor.LoginInterceptor.AUTHORIZATION_HEADER;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result<User> register(@Pattern(regexp = "^\\S{5,16}$") final String username, @Pattern(regexp = "^\\S{5,16}$") final String password) {
        final User existingUser = userService.findByUsername(username);
        if (existingUser == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") final String username, @Pattern(regexp = "^\\S{5,16}$") final String password) {
        final User existingUser = userService.findByUsername(username);
        if (existingUser == null) {
            return Result.error("用户不存在");
        }
        if (Md5Util.getMD5String(password).equals(existingUser.getPassword())) {
            final Map<String, Object> map = Map.of("id", existingUser.getId(),
                    "username", existingUser.getUsername());
            final String token = JwtUtil.genToken(map);
            // Save token to redis
            final ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            // If key is token, and when we validate, and the token doesn't exist, then it has expired.
            operations.set(token, token, Duration.ofHours(12));
            // Return JWT token
            return Result.success(token);
        } else {
            return Result.error("密码错误");
        }
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo() {

        final Map<String, Object> map = ThreadLocalUtil.get();
        final String username = (String) map.get("username");
        final User user = userService.findByUsername(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result<String> update(@RequestBody @Validated final User user) {
        final Map<String, Object> map = ThreadLocalUtil.get();
        final Integer id = (Integer) map.get("id");
        if (user.getId().equals(id)) {
            userService.update(user);
            return Result.success();
        } else {
            return Result.error("非本人id");
        }
    }

    @PatchMapping("/updateAvatar")
    public Result<String> updateAvatar(@RequestParam @URL final String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result<String> updatePwd(@RequestBody Map<String, String> params, @RequestHeader(AUTHORIZATION_HEADER) final String token) {
        final String oldPwd = params.get("old_pwd");
        final String newPwd = params.get("new_pwd");
        final String rePwd = params.get("re_pwd");
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少必要的参数");
        }

        final Map<String, Object> map = ThreadLocalUtil.get();
        final String username = (String) map.get("username");
        final User user = userService.findByUsername(username);
        if (!rePwd.equals(newPwd)) {
            return Result.error("两次结果不一样");
        }
        if (!user.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("密码填写不正确");
        }

        userService.updatePwd(newPwd);
        // Delete token in redis.
        final ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);

        return Result.success();
    }
}
