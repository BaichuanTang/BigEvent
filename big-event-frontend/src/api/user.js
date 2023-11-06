import request from "@/utils/request";

export const userRegisterService = (registerData) => {
  const params = new URLSearchParams();
  for (const key in registerData) {
    params.append(key, registerData[key])
  }
  return request.post('/user/register', params)
}

export const userLoginService = (loginData) => {
  const params = new URLSearchParams();
  for (const key in loginData) {
    params.append(key, loginData[key])
  }
  return request.post('/user/login', params)
}

export const userInfoService = () => {
  return request.get('/user/userInfo')
}

export const userInfoUpdateService = (userInfoData) => {
  return request.put('/user/update', userInfoData)
}

export const userAvatarUpdateService = (avatarUrl) => {
  const urlSearchParams = new URLSearchParams();
  urlSearchParams.append('avatarUrl', avatarUrl)
  return request.patch('/user/updateAvatar', urlSearchParams)
}