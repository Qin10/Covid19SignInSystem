# 接口文档

## 一、授权鉴权类请求

### 1.微信授权登录

*作者：Qin Zhenghan*

**请求URL**

/login/wechat `POST`

**请求体**

```json
{
  "nickname": "String //昵称（必须）",
  "code": "String //微信code（必须）",
  "avatarUrl": "String //头像URL"
}
```

**返回结果**

```json
{
    "code": "int //响应状态码",
    "msg": "String //响应消息",
    "data": {
        "token": "String //token令牌",
        "userVo": {
            "ucreatedTime": "Date //用户创建时间",
            "uid": "int //用户id",
            "utypeId": "int //用户类别（1为普通用户，0为管理员）",
            "uavatarUrl": "String //用户头像文件保存路径",
            "ugender": "boolean //用户性别",
            "utrueName": "String //用户真实姓名",
            "uclass": "String //用户所在班级",
            "ustuNum": "String //用户学号",
            "ugrade": "int //用户年级",
            "umajor": "String //用户专业",
            "unickname": "String //用户昵称",
            "uschool": "String //用户学校",
            "uacademy": "String //用户学院"
        }
    },
    "time": "String //响应时间"
}
```

## 二、用户相关请求

### 1.修改用户公有信息

*作者：Qin Zhenghan*

**请求URL**

/user/me `PUT`

**请求体**

```json
{
	"ucreatedTime": "Date //用户创建时间",
    "uid": "int //用户id",
    "utypeId": "int //用户类别（1为普通用户，0为管理员）",
    "uavatarUrl": "String //用户头像文件保存路径",
    "ugender": "boolean //用户性别",
    "utrueName": "String //用户真实姓名",
    "uclass": "String //用户所在班级",
    "ustuNum": "String //用户学号",
    "ugrade": "int //用户年级",
    "umajor": "String //用户专业",
    "unickname": "String //用户昵称",
    "uschool": "String //用户学校",
    "uacademy": "String //用户学院"
}
```

**返回结果**

```json
{
  "code": "int //响应状态码",
  "msg": "string //响应消息",
  "data": "object //响应数据",
  "time": "string //响应时间"
}
```

### 2.获取当前用户信息

*作者：Qin Zhenghan*

**请求URL**

/user/me `GET`

**返回结果**

```json
{
    "code": "int //响应状态码",
    "msg": "string //响应消息",
    "data": {
        "ucreatedTime": "Date //用户创建时间",
        "uid": "int //用户id",
        "utypeId": "int //用户类别（1为普通用户，0为管理员）",
        "uavatarUrl": "String //用户头像文件保存路径",
        "ugender": "boolean //用户性别",
        "utrueName": "String //用户真实姓名",
        "uclass": "String //用户所在班级",
        "ustuNum": "String //用户学号",
        "ugrade": "int //用户年级",
        "umajor": "String //用户专业",
        "unickname": "String //用户昵称",
        "uschool": "String //用户学校",
        "uacademy": "String //用户学院"
    },
    "time": "string //响应时间"
}
```

### 3.根据id获取当前用户信息

*作者：Qin Zhenghan*

**请求URL**

/user/{userId} `GET`

**返回结果**

```json
{
    "code": "int //响应状态码",
    "msg": "string //响应消息",
    "data": {
        "ucreatedTime": "Date //用户创建时间",
        "uid": "int //用户id",
        "utypeId": "int //用户类别（1为普通用户，0为管理员）",
        "uavatarUrl": "String //用户头像文件保存路径",
        "ugender": "boolean //用户性别",
        "utrueName": "String //用户真实姓名",
        "uclass": "String //用户所在班级",
        "ustuNum": "String //用户学号",
        "ugrade": "int //用户年级",
        "umajor": "String //用户专业",
        "unickname": "String //用户昵称",
        "uschool": "String //用户学校",
        "uacademy": "String //用户学院"
    },
    "time": "string //响应时间"
}
```

