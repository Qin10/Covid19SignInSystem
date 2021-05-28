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
    "uid": 10001,
    "utypeId": "0",
    "uavatarUrl": "/root",
    "ugender": 1,
    "utrueName": "秦政瀚",
    "uclass": "软外1903班",
    "ustuNum": "201906150312",
    "ugrade": 2019,
    "umajor": "软件工程（中外合作）",
    "unickname": "Patricy",
    "uschool": "浙江工业大学",
    "uacademy": "计算机科学与技术学院、软件学院"
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

## 三、用户管理相关

### 1.获取所有用户列表

*作者：Qin Zhenghan*

**请求URL**

/admin/user `GET`

**URL参数**

```json
http://localhost:8089/admin/user/?pageNum=1&pageSize=2
（其中pageNum为页码，pageSize为分页大小）
```

**返回结果**

```json
{
    "code": 200,
    "msg": "succ",
    "data": {
        "pageNum": 1,
        "pageSize": 1,
        "pageData": [
            {
                "ucreatedTime": "2021-05-23T18:55:00.000+0800",
                "uid": 10001,
                "utypeId": 1,
                "unickname": "Patricy",
                "uavatarUrl": "/usr",
                "umajor": "软件工程（中外合作）",
                "uclass": "软外1903",
                "ugender": true,
                "ugrade": 2019,
                "ustuNum": "201906150312",
                "uschool": "浙江工业大学",
                "uacademy": "计算机学院",
                "utrueName": "秦政瀚"
            },
            {
                "ucreatedTime": "2021-05-23T18:55:00.000+0800",
                "uid": 10001,
                "utypeId": 1,
                "unickname": "Patricy",
                "uavatarUrl": "/usr",
                "umajor": "软件工程（中外合作）",
                "uclass": "软外1903",
                "ugender": true,
                "ugrade": 2019,
                "ustuNum": "201906150312",
                "uschool": "浙江工业大学",
                "uacademy": "计算机学院",
                "utrueName": "秦政瀚"
            }
        ]
    },
    "time": "2021-05-23 21:53:37"
}
```

### 2.根据用户id删除用户

*作者：Qin Zhenghan*

**请求URL**

/admin/user/{userId} `GET`

**URL参数**

```json
http://localhost:8089/admin/user/10002
```

**返回结果**

```json
{
    "code": 200,
    "msg": "succ",
    "data": null,
    "time": "2021-05-23 22:08:46"
}
```

## 四、打卡信息相关

### 1.获取某个用户今日打卡信息

**请求URL**

/query/timecardByIdOnToday `POST`

**请求体**

```json
POST http://localhost:8089/query/timecardByIdOnToday HTTP/1.1
Content-Type: application/json

{
    "u_id": 10001
}
```

**返回结果**

```json
{
    "code": 200,
    "msg": "succ",
    "data": {
        "datetime": "2021-05-23 20:33:42",
        "province": "浙江省",
        "city": "杭州市",
        "county": "西湖区",
        "detailLocation": null,
        "temperature": 36.5,
        "healthcode": "绿码",
        "uid": 10001
    },
    "time": "2021-05-23 20:41:22"
}
```

### 2.获取前几天用户打卡信息

**请求URL**

/query/timecardsSomeDaysAgoById `POST`

**请求体**

```json
POST http://localhost:8089/query/timecardsSomeDaysAgoById HTTP/1.1
Content-Type: application/json

{
    "u_id":10001,
    "days":10
}
```

**返回结果**

```json
{
    "code": 200,
    "msg": "succ",
    "data": [
        {
            "datetime": "2021-05-23 20:33:43",
            "province": "浙江省",
            "city": "杭州市",
            "county": "西湖区",
            "detailLocation": null,
            "temperature": 36.5,
            "healthcode": "绿码",
            "uid": 10001
        },
        {
            "datetime": "2021-05-18 19:50:46",
            "province": "浙江省",
            "city": "温州市",
            "county": "鹿城区",
            "detailLocation": null,
            "temperature": 37.5,
            "healthcode": "绿码",
            "uid": 10001
        }
    ],
    "time": "2021-05-23 20:45:20"
}
```

### 3.获取今日未打卡的用户信息（管理员）

**请求URL**

/query/usersNotSignInOnToday `POST`

**请求体**

```json
POST http://localhost:8089/query/usersNotSignInOnToday HTTP/1.1
Content-Type: application/json

{
    "school":"浙江工业大学",
    "academy":"计算机",
    "major":"软件工程（中外合作）",
    "grade":2019,
    "classe":"软外1902班"
}
```

**返回结果**

```json
{
    "code": 200,
    "msg": "succ",
    "data": [
        {
            "utypeId": 0,
            "ucreatedTime": "2021-05-17T08:06:38.000+0800",
            "uid": 15684,
            "unickname": "Judy",
            "umajor": "软件工程（中外合作）",
            "ugrade": 2019,
            "uclass": "软外1902班",
            "ugender": false,
            "uschool": "浙江工业大学",
            "uacademy": "计算机",
            "ustuNum": "201930615588",
            "utrueName": "小强",
            "uavatarUrl": null
      }
    ],
    "time": "2021-05-23 20:49:36"
}
```

### 4.获取今日的打卡信息（管理员）

**请求URL**

/query/timecardsBySchoolInfoOnToday `POST`

**请求体**

```
POST http://localhost:8089/query/usersNotSignInOnToday HTTP/1.1
Content-Type: application/json

{
    "school":"浙江工业大学",
    "academy":"计算机学院",
    "major":"软件工程（中外合作）",
    "grade":2019,
    "classe":"软外1903"
}
```

请求体中必须要有school项，其他可无。

**返回结果**

```
{
    "code": 200,
    "msg": "succ",
    "data": [
        {
            "datetime": "2021-05-27 19:31:17",
            "province": "浙江省",
            "city": "杭州市",
            "county": "西湖区",
            "detailLocation": null,
            "temperature": 36.5,
            "healthcode": "绿码",
            "uid": 10001
        }
    ],
    "time": "2021-05-27 19:48:44"
}
```

### 5.添加打卡信息

**请求URL**

/addTimecard `POST`

**请求体**

```
POST http://localhost:8089/addTimecard HTTP/1.1
Content-Type: application/json

{
    "u_id":15684,
    "province":"山东省",
    "city":"青岛市",
    "county":"崂山区",
    "detailLocaiton":"沙子口街道",
    "temperature":37.5,
    "healthcode":"绿码"
}
```

**返回结果**

每天的首次打卡

```
{
    "code": 200,
    "msg": "succ",
    "data": "打卡成功",
    "time": "2021-05-23 20:36:20"
}
```

每天的重复打卡

```
{
    "code": 200,
    "msg": "succ",
    "data": "您已打卡成功，请勿重复打卡",
    "time": "2021-05-23 20:36:20"
}
```

