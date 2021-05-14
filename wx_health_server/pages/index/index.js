// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {

  },

  login(){
    wx.login({
      success (res) {
        if (res.code) {
          // console.log(res.code)
          let rst = res.code;
          //发起网络请求
          wx.request({
            // url: 'https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&grant_type=authorization_code&js_code=JSCODE',
            url: 'http://localhost:8089/login/wechat?code='+rst,
            method: 'POST',
            header: {
              'content-type': 'application/x-www-form-urlencoded'
            },
            data: {
              code: res.code
            },
            success(res){
              if(res.data.status == 200){
                // 保存登录状态
                // 保存到客户端 wx.setStorage
                wx.setStorage({
                  data: data,
                  key: 'key',
                })
              }else{
                wx.removeStorage({
                  key: 'key'
                })
              }
            }
          })
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
  },

  onLoad() {
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
