<script setup>
import {ref} from 'vue'
import {userPwdUpdateService} from "@/api/user";
import {ElMessage} from "element-plus";


const pwdData = ref({
  old_pwd: '',
  new_pwd: '',
  re_pwd: ''
})

const updatePwdData = async () => {
  await userPwdUpdateService(pwdData.value);
  ElMessage.success('修改成功')
  pwdData.value = {
    old_pwd: '',
    new_pwd: '',
    re_pwd: ''
  }
}
const checkRePassword = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请再次确认密码'))
  } else if (value !== pwdData.value.new_pwd) {
    callback(new Error('两次密码不一样'))
  } else {
    callback()
  }
}
const rules = {
  old_pwd: [
    {required: true, message: '请输入旧密码?', trigger: 'blur'},
    {min: 5, max: 16, message: '长度为5-16位', trigger: 'blur'},
  ],
  new_pwd: [
    {required: true, message: '请输入新密码', trigger: 'blur'},
    {min: 5, max: 16, message: '长度为5-16位', trigger: 'blur'},
  ],
  re_pwd: [
    {required: true, message: '请输入确认新密码', trigger: 'blur'},
    {validator: checkRePassword, trigger: 'blur'},
  ]
}
</script>

<template>
  <el-card class="page-container">
    <template #header>
      <div class="header">
        <span>重置密码</span>
      </div>
    </template>
    <el-row>
      <el-col :span="12">
        <el-form :model="pwdData" :rules="rules" label-width="100px" size="large">
          <el-form-item label="旧密码" prop="old_pwd">
            <el-input v-model="pwdData.old_pwd" type="password" placeholder="请输入旧密码"></el-input>
          </el-form-item>
          <el-form-item label="新密码" prop="new_pwd">
            <el-input v-model="pwdData.new_pwd" type="password" placeholder="请输入新密码"></el-input>
          </el-form-item>
          <el-form-item label="确认新密码" prop="re_pwd">
            <el-input v-model="pwdData.re_pwd" type="password" placeholder="请输入再次新密码"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updatePwdData">提交修改</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </el-card>
</template>
