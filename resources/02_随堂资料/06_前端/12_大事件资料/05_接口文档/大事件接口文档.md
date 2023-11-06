# 大事件接口文档-V1.0

## 1. 用户相关接口

### 1.1 注册

#### 1.1.1 基本信息

> 请求路径：/user/register
>
> 请求方式：POST
>
> 接口描述：该接口用于注册新用户



#### 1.1.2 请求参数

请求参数格式：x-www-form-urlencoded

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注           |
| -------- | ------ | ------ | -------- | -------------- |
| username | 用户名 | string | 是       | 5~16位非空字符 |
| password | 密码   | string | 是       | 5~16位非空字符 |

请求数据样例：

```shell
username=zhangsan&password=123456
```



#### 1.1.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 1.2 登录

#### 1.2.1 基本信息

> 请求路径：/user/login
>
> 请求方式：POST
>
> 接口描述：该接口用于登录

#### 1.2.2 请求参数

请求参数格式：x-www-form-urlencoded

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注           |
| -------- | ------ | ------ | -------- | -------------- |
| username | 用户名 | string | 是       | 5~16位非空字符 |
| password | 密码   | string | 是       | 5~16位非空字符 |

请求数据样例：

```shell
username=zhangsan&password=123456
```



#### 1.2.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | string | 必须     |        | 返回的数据,jwt令牌    |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiaWQiOjUsInVzZXJuYW1lIjoid2FuZ2JhIn0sImV4cCI6MTY5MzcxNTk3OH0.pE_RATcoF7Nm9KEp9eC3CzcBbKWAFOL0IsuMNjnZ95M"
}
```



#### 1.2.4 备注说明

> 用户登录成功后，系统会自动下发JWT令牌，然后在后续的每次请求中，浏览器都需要在请求头header中携带到服务端，请求头的名称为 Authorization，值为 登录时下发的JWT令牌。
>
> 如果检测到用户未登录，则http响应状态码为401



### 1.3 获取用户详细信息

#### 1.3.1 基本信息

> 请求路径：/user/userInfo
>
> 请求方式：GET
>
> 接口描述：该接口用于获取当前已登录用户的详细信息

#### 1.3.2 请求参数

无

#### 1.3.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称          | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------------- | ------ | -------- | ------ | --------------------- | -------- |
| code          | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message       | string | 非必须   |        | 提示信息              |          |
| data          | object | 必须     |        | 返回的数据            |          |
| \|-id         | number | 非必须   |        | 主键ID                |          |
| \|-username   | srting | 非必须   |        | 用户名                |          |
| \|-nickname   | string | 非必须   |        | 昵称                  |          |
| \|-email      | string | 非必须   |        | 邮箱                  |          |
| \|-userPic    | string | 非必须   |        | 头像地址              |          |
| \|-createTime | string | 非必须   |        | 创建时间              |          |
| \|-updateTime | string | 非必须   |        | 更新时间              |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "id": 5,
        "username": "wangba",
        "nickname": "",
        "email": "",
        "userPic": "",
        "createTime": "2023-09-02 22:21:31",
        "updateTime": "2023-09-02 22:21:31"
    }
}
```



### 1.4 更新用户基本信息

#### 1.4.1 基本信息

> 请求路径：/user/update
>
> 请求方式：PUT
>
> 接口描述：该接口用于更新已登录用户的基本信息(除头像和密码)

#### 1.4.2 请求参数

请求参数格式：application/json

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注           |
| -------- | ------ | ------ | -------- | -------------- |
| id       | 主键ID | number | 是       |                |
| username | 用户名 | string | 否       | 5~16位非空字符 |
| nickname | 昵称   | string | 是       | 1~10位非空字符 |
| email    | 邮箱   | string | 是       | 满足邮箱的格式 |

请求数据样例：

```shell
{
    "id":5,
    "username":"wangba",
    "nickname":"wb",
    "email":"wb@itcast.cn"
}
```

#### 1.4.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 1.5 更新用户头像

#### 1.5.1 基本信息

> 请求路径：/user/updateAvatar
>
> 请求方式：PATCH
>
> 接口描述：该接口用于更新已登录用户的头像

#### 1.5.2 请求参数

请求参数格式：queryString

请求参数说明：

| 参数名称  | 说明     | 类型   | 是否必须 | 备注    |
| --------- | -------- | ------ | -------- | ------- |
| avatarUrl | 头像地址 | string | 是       | url地址 |

请求数据样例：

```shell
avatarUrl=
https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png
```

#### 1.5.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 1.6 更新用户密码

#### 1.6.1 基本信息

> 请求路径：/user/updatePwd
>
> 请求方式：PATCH
>
> 接口描述：该接口用于更新已登录用户的密码

#### 1.6.2 请求参数

请求参数格式：application/json

请求参数说明：

| 参数名称 | 说明       | 类型   | 是否必须 | 备注 |
| -------- | ---------- | ------ | -------- | ---- |
| old_pwd  | 原密码     | string | 是       |      |
| new_pwd  | 新密码     | string | 是       |      |
| re_pwd   | 确认新密码 | string | 是       |      |

请求数据样例：

```json
{
    "old_pwd":"123456",
    "new_pwd":"234567",
    "re_pwd":"234567"
}
```

#### 1.6.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



## 2. 文章分类相关接口

### 2.1 新增文章分类

#### 2.1.1 基本信息

> 请求路径：/category
>
> 请求方式：POST
>
> 接口描述：该接口用于新增文章分类

#### 2.1.2 请求参数

请求参数格式：application/json

请求参数说明：

| 参数名称      | 说明     | 类型   | 是否必须 | 备注 |
| ------------- | -------- | ------ | -------- | ---- |
| categoryName  | 分类名称 | string | 是       |      |
| categoryAlias | 分类别名 | string | 是       |      |

请求数据样例：

```json
{
    "categoryName":"人文",
    "categoryAlias":"rw"
}
```

#### 2.1.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 2.2 文章分类列表

#### 2.2.1 基本信息

> 请求路径：/category
>
> 请求方式：GET
>
> 接口描述：该接口用于获取当前已登录用户创建的所有文章分类

#### 2.2.2 请求参数

无

#### 2.2.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称             | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ---------------- | ------ | -------- | ------ | --------------------- | -------- |
| code             | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message          | string | 非必须   |        | 提示信息              |          |
| data             | array  | 必须     |        | 返回的数据            |          |
| \|-id            | number | 非必须   |        | 主键ID                |          |
| \|-categoryName  | string | 非必须   |        | 分类名称              |          |
| \|-categoryAlias | string | 非必须   |        | 分类别名              |          |
| \|-createTime    | string | 非必须   |        | 创建时间              |          |
| \|-updateTime    | string | 非必须   |        | 修改时间              |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": [
        {
            "id": 3,
            "categoryName": "美食",
            "categoryAlias": "my",
            "createTime": "2023-09-02 12:06:59",
            "updateTime": "2023-09-02 12:06:59"
        },
        {
            "id": 4,
            "categoryName": "娱乐",
            "categoryAlias": "yl",
            "createTime": "2023-09-02 12:08:16",
            "updateTime": "2023-09-02 12:08:16"
        },
        {
            "id": 5,
            "categoryName": "军事",
            "categoryAlias": "js",
            "createTime": "2023-09-02 12:08:33",
            "updateTime": "2023-09-02 12:08:33"
        }
    ]
}
```



### 2.3 获取文章分类详情

#### 2.3.1 基本信息

> 请求路径：/category/detail
>
> 请求方式：GET
>
> 接口描述：该接口用于根据ID获取文章分类详情

#### 2.3.2 请求参数

请求参数格式：queryString

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注 |
| -------- | ------ | ------ | -------- | ---- |
| id       | 主键ID | number | 是       |      |

请求数据样例：

```shell
id=6
```

#### 2.3.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称             | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ---------------- | ------ | -------- | ------ | --------------------- | -------- |
| code             | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message          | string | 非必须   |        | 提示信息              |          |
| data             | object | 必须     |        | 返回的数据            |          |
| \|-id            | number | 非必须   |        | 主键ID                |          |
| \|-categoryName  | string | 非必须   |        | 分类名称              |          |
| \|-categoryAlias | string | 非必须   |        | 分类别名              |          |
| \|-createTime    | string | 非必须   |        | 创建时间              |          |
| \|-updateTime    | string | 非必须   |        | 修改时间              |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "id": 6,
        "categoryName": "风土人情",
        "categoryAlias": "ftrq",
        "createTime": "2023-09-03 11:07:13",
        "updateTime": "2023-09-03 11:13:39"
    }
}
```



### 2.4 更新文章分类

#### 2.4.1 基本信息

> 请求路径：/category
>
> 请求方式：PUT
>
> 接口描述：该接口用于更新文章分类

#### 2.4.2 请求参数

请求参数格式：application/json

请求参数说明：

| 参数名称      | 说明     | 类型   | 是否必须 | 备注 |
| ------------- | -------- | ------ | -------- | ---- |
| id            | 主键ID   | number | 是       |      |
| categoryName  | 分类名称 | string | 是       |      |
| categoryAlias | 分类别名 | string | 是       |      |

请求数据样例：

```json
{
    "id":6,
    "categoryName":"风土人情",
    "categoryAlias":"ftrq"
}
```

#### 2.4.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 2.5 删除文章分类

#### 2.5.1 基本信息

> 请求路径：/category
>
> 请求方式：DELETE
>
> 接口描述：该接口用于根据ID删除文章分类

#### 2.5.2 请求参数

请求参数格式：queryString

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注 |
| -------- | ------ | ------ | -------- | ---- |
| id       | 主键ID | number | 是       |      |

请求数据样例：

```shell
id=6
```

#### 2.5.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



## 3. 文章管理相关接口

### 3.1 新增文章

#### 3.1.1 基本信息

> 请求路径：/article
>
> 请求方式：POST
>
> 接口描述：该接口用于新增文章(发布文章)

#### 3.1.2 请求参数

请求参数格式：application/json

请求参数说明：

| 参数名称   | 说明         | 类型   | 是否必须 | 备注           |      |
| ---------- | ------------ | ------ | -------- | -------------- | ---- |
| title      | 文章标题     | string | 是       | 1~10个非空字符 |      |
| content    | 文章正文     | string | 是       |                |      |
| coverImg   | 封面图像地址 | string | 是       | 必须是url地址  |      |
| state      | 发布状态     | string | 是       | 已发布 \| 草稿 |      |
| categoryId | 文章分类ID   | number | 是       |                |      |

请求数据样例：

```json
{
  "title": "陕西旅游攻略",
  "content": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
  "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
  "state": "草稿",
  "categoryId": 2
}
```

#### 3.1.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 3.2 文章列表(条件分页)

#### 3.2.1 基本信息

> 请求路径：/article
>
> 请求方式：GET
>
> 接口描述：该接口用于根据条件查询文章,带分页

#### 3.2.2 请求参数

请求参数格式：queryString

请求参数说明：

| 参数名称   | 说明       | 类型   | 是否必须 | 备注           |      |
| ---------- | ---------- | ------ | -------- | -------------- | ---- |
| pageNum    | 当前页码   | number | 是       |                |      |
| pageSize   | 每页条数   | number | 是       |                |      |
| categoryId | 文章分类ID | number | 否       |                |      |
| state      | 发布状态   | string | 否       | 已发布 \| 草稿 |      |

请求数据样例：

```shell
pageNum=1&pageSize=3&categoryId=2&state=草稿
```

#### 3.2.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称          | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息     |
| ------------- | ------ | -------- | ------ | --------------------- | ------------ |
| code          | number | 必须     |        | 响应码, 0-成功,1-失败 |              |
| message       | string | 非必须   |        | 提示信息              |              |
| data          | object | 必须     |        | 返回的数据            |              |
| \|-total      | number | 必须     |        | 总记录数              |              |
| \|-items      | array  | 必须     |        | 数据列表              |              |
| \|-id         | number | 非必须   |        | 主键ID                |              |
| \|-title      | string | 非必须   |        | 文章标题              |              |
| \|-content    | string | 非必须   |        | 文章正文              |              |
| \|-coverImg   | string | 非必须   |        | 文章封面图像地址      |              |
| \|-state      | string | 非必须   |        | 发布状态              | 已发布\|草稿 |
| \|-categoryId | number | 非必须   |        | 文章分类ID            |              |
| \|-createTime | string | 非必须   |        | 创建时间              |              |
| \|-updateTime | string | 非必须   |        | 更新时间              |              |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "total": 1,
        "items": [
            {
                "id": 5,
                "title": "陕西旅游攻略",
                "content": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
                "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
                "state": "草稿",
                "categoryId": 2,
                "createTime": "2023-09-03 11:55:30",
                "updateTime": "2023-09-03 11:55:30"
            }
        ]
    }
}
```







### 3.3 获取文章详情

#### 3.3.1 基本信息

> 请求路径：/article/detail
>
> 请求方式：GET
>
> 接口描述：该接口用于根据ID获取文章详细信息

#### 3.3.2 请求参数

请求参数格式：queryString

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注 |      |
| -------- | ------ | ------ | -------- | ---- | ---- |
| id       | 主键ID | number | 是       |      |      |

请求数据样例：

```shell
id=4
```

#### 3.3.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称          | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息     |
| ------------- | ------ | -------- | ------ | --------------------- | ------------ |
| code          | number | 必须     |        | 响应码, 0-成功,1-失败 |              |
| message       | string | 非必须   |        | 提示信息              |              |
| data          | object | 必须     |        | 返回的数据            |              |
| \|-id         | number | 非必须   |        | 主键ID                |              |
| \|-title      | string | 非必须   |        | 文章标题              |              |
| \|-content    | string | 非必须   |        | 文章正文              |              |
| \|-coverImg   | string | 非必须   |        | 文章封面图像地址      |              |
| \|-state      | string | 非必须   |        | 发布状态              | 已发布\|草稿 |
| \|-categoryId | number | 非必须   |        | 文章分类ID            |              |
| \|-createTime | string | 非必须   |        | 创建时间              |              |
| \|-updateTime | string | 非必须   |        | 更新时间              |              |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "id": 4,
        "title": "北京旅游攻略",
        "content": "天安门,颐和园,鸟巢,长城...爱去哪去哪...",
        "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
        "state": "已发布",
        "categoryId": 2,
        "createTime": "2023-09-03 11:35:04",
        "updateTime": "2023-09-03 11:40:31"
    }
}
```



### 3.4 更新文章

#### 3.4.1 基本信息

> 请求路径：/article
>
> 请求方式：PUT
>
> 接口描述：该接口用于更新文章信息

#### 3.4.2 请求参数

请求参数格式：application/json

请求参数说明：

| 参数名称   | 说明         | 类型   | 是否必须 | 备注           |      |
| ---------- | ------------ | ------ | -------- | -------------- | ---- |
| id         | 主键ID       | number | 是       |                |      |
| title      | 文章标题     | string | 是       |                |      |
| content    | 文章正文     | string | 是       |                |      |
| coverImg   | 封面图像地址 | string | 是       |                |      |
| state      | 发布状态     | string | 是       | 已发布 \| 草稿 |      |
| categoryId | 文章分类ID   | number | 是       |                |      |

请求数据样例：

```json
{
    "id":4,
    "title": "北京旅游攻略",
    "content": "天安门,颐和园,鸟巢,长城...爱去哪去哪...",
    "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
    "state": "已发布",
    "categoryId": 2
}
```

#### 3.4.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```





### 3.5 删除文章

#### 3.5.1 基本信息

> 请求路径：/article
>
> 请求方式：DELETE
>
> 接口描述：该接口用于根据ID删除文章

#### 3.5.2 请求参数

请求参数格式：queryString

请求参数说明：

| 参数名称 | 说明   | 类型   | 是否必须 | 备注 |      |
| -------- | ------ | ------ | -------- | ---- | ---- |
| id       | 主键ID | number | 是       |      |      |

请求数据样例：

```shell
id=4
```

#### 3.5.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                  | 其他信息 |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败 |          |
| message | string | 非必须   |        | 提示信息              |          |
| data    | object | 非必须   |        | 返回的数据            |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```





## 4. 其他接口

### 4.1 文件上传

#### 4.1.1 基本信息

> 请求路径：/upload
>
> 请求方式：POST
>
> 接口描述：该接口用于上传文件(单文件)

#### 4.1.2 请求参数

请求参数格式：multipart/form-data

请求参数说明：

| 参数名称 | 说明                     | 类型 | 是否必须 | 备注 |      |
| -------- | ------------------------ | ---- | -------- | ---- | ---- |
| file     | 表单中文件请求参数的名字 | file | 是       |      |      |

请求数据样例：

无

#### 4.1.3 响应数据

响应数据类型：application/json

响应参数说明：

| 名称    | 类型   | 是否必须 | 默认值 | 备注                     | 其他信息 |
| ------- | ------ | -------- | ------ | ------------------------ | -------- |
| code    | number | 必须     |        | 响应码, 0-成功,1-失败    |          |
| message | string | 非必须   |        | 提示信息                 |          |
| data    | string | 必须     |        | 图像在阿里云上的存储地址 |          |

响应数据样例：

```json
{
    "code": 0,
    "message": "操作成功",
    "data": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/b5811871-acc8-4583-8399-cf0dc73591ab.png"
}
```

