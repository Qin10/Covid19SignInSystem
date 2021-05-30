// index.js
// 获取应用实例
const app = getApp()
Page({
  data: {
    tipsMessage:'1.若无绑定信息，则以上登录信息视为注册.\n 2.若已经绑定，将直接登录',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
  },
  onLoad() {
    if (wx.getUserProfile()) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
    wx.login(
      {
        success: function (res) {
          var code = res.code;
          app.globalData.wxCode = code
          if (code) {
            app.globalData.wxCode = code;
            // --------- 发送凭证 ------------------
            wx.request({
              url: 'https://www.zjutleo.cn/health/login/wechat',
              method:"POST",
              data:{
               "nickname" : " ",
               "code" : code,
               "avatarUrl" : ""
              },
              header:{
               "content-type":  'application/json'
              },
              success: function(res){
                console.log(res);
                var infor = {
                  token : res.data.data.token,
                  ucreatedTime : res.data.data.userVo.ucreatedTime,
                  uid : res.data.data.userVo.uid,
                  utypeid : res.data.data.userVo.utypeId,
                  ugender : res.data.data.userVo.ugender,
                  utrueName : res.data.data.userVo.utrueName,
                  ustuNum : res.data.data.userVo.ustuNum,
                  uclass : res.data.data.userVo.uclass,
                  ugrade : res.data.data.userVo.ugrade,
                  umajor : res.data.data.userVo.umajor,
                  unickname : res.data.data.userVo.unickname,
                  uschool : res.data.data.userVo.uschool,
                  uacademy : res.data.data.userVo.uacademy,
                }
                app.update(infor)
              }
            })
          }
        }   
      }
    );
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: function(res) {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        });
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
  },

  clickme:function(){
    var that = this;
    console.log(app.getWxcode()==null)
    console.log(app.globalData.uid)
    if(app.globalData.ustuNum == null || app.globalData.utrueName == null){
      wx.navigateTo({
        url: '/pages/selfInfor/selfInfor',
      })
    }
    else{
      wx.navigateTo({
        url: '/pages/mainPage/mainPage'
      })
    }

  }
})