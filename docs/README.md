# 接口文档

## 一、授权鉴权类请求

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

