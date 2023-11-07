# BigEvent
 黑马程序员大事件Springboot3+vue3项目
 
- 前端：big-event-frontend
- 后端：big-event-backend


## 点评
- 学到了很多技巧，这些技巧如果不听人介绍过一遍，且自己敲过一遍，工作中遇到了还是不会。例如：
    - 后端中的Validated校验，如果没有项目带着我们自己做，很难搞懂具体实战中怎么校验，什么时候在类名上加@Validated，什么时候在参数上加@Validated，以及自定义注解进行校验。
    - 学到了登录认证的全套流程，包括怎么写比较优雅。包括在WebConfig中添加拦截器，在登录时用JWT生成token，用redis来存储登陆状态以避免修改密码后原token还能使用，修改密码时清除redis中的token，使用ThreadLocal在一次请求处理过程中，先在登录的拦截器里拿到token，再在其他的Controller，Service层按需取用token，这种写法十分优雅且方便
    - 全局的异常处理，这里我对黑马的代码做了优化。
    - 学到了Mybatis的xml文件怎么写，我之前听黑马的课的时候，黑马用的是MybatisPlus，我一直担心，如果一个pojo从controller进来传到mapper层的时候，如果有人恶意篡改了不该篡改的数据，那么是没有每个属性的校验的，很有问题。那我觉得Mybatis应该是符合大公司的要求，因为写SQL语句的时候是一个一个属性去写的。
    - P23 实战篇12 需要验证传进来的id和自己的id是不是同一个。详见public Result<String> update(@RequestBody @Validated final User user) 黑马一些地方都漏了这种类似的校验，在大公司肯定是要校验的。
    - P34 实战篇22 分页查询里 @RequestParam讲解错了，这里加不加都无所谓，因为不加的时候SpringMVC时当作没有匹配到去处理的，因此也是null。@RequestParam的作用是标记参数必须添加的，本身可以省略，效果和@RequestParam(required=false)一样。
    - 阿里云OSS的地方，黑马可以做的更好，就是教我们怎么设环境变量，因为肯定有很多同学写完传到github上，然后自己的access key就被盗用了。这里我自己实验的时候，要关掉idea重新开才会生效，de了很久bug。
    - 进入前端部分。黑马没有用jetbrains的webstorm或者idea是一个很大的遗憾，一直在手写import，组织代码，而且vscode快捷键也不一样，因此强推Webstorm。
    - 黑马的路由，axios的request和response拦截器的改写，未登录的跳转，前端请求统一携带token，response统一的异常处理，文件存放，pinia以及持久化讲的特别清晰，而且语法都是最新的vue3的，这很难得。
    - 上传图片的处理很实用，结合el-upload进行讲解。这个会特别实用