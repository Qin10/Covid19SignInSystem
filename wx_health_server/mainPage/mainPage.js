// pages/mainPage.js

 
var QQMapWx = require("../../tabbar/qqmap-wx-jssdk.min.js");
var qqmapsdk;
Page({
  /**
   * 页面的初始数据
   */
  data: {
    // 从用户ID
    UserIdWeChat:201906150105,
    nameSlice:"",
    yearNow:2021,
    yearBefore:2020,
    monthNow:5,
    dayNow:17,
    userName:"戈梓闻",
    dept:"计算机学院",
    ifAttend:false,
    attendHour: 7,
    attendMin: 10,
    longitude:1.0,
    latitude:2.0,
    nation:'中国',
    province:'',
    city:'',
    district:'',
    street:'',
    street_number:'',
    rough:'',
    //到此都需要动态给定
    hourNow:12,
    minNow:12,
    secNow:12,
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName'), // 如需尝试获取用户信息可改为false
    MaskView:false,
    InforView:true,
    "list": [
      {
        "pagePath": "pages/CheckPose/CheckPage",
        "text": "考勤打卡",
        "iconPath": "/tabbar/CheckPoint1_2.png",
        "selectedIconPath": "/tabbar/CheckPoint1_1.png",
        "dot":true
      },
      {
        "pagePath": "pages/selfInfor/selfInfor",
        "text": "我的",
        "iconPath": "/tabbar/mine2_2.png",
        "selectedIconPath": "/tabbar/mine2_1.png",
        "dot":true
      }
    ]
},
tabChange(e) {
  // console.log(e);
  // var query = wx.createSelectorQuery();
  // var tabbar = e.currentTarget;
  // var seletedItems = tabbar.list;
  // if()
  var index = e.detail.index;
  if(index == 1){
    // tabbar.list[1]["dot"] == true;
    if(this.data.list[1].dot == true){
      this.setData({
        ["list[1].dot"]:false
      })
    }
    if(this.data.InforView == true){
      this.changeSlice();
      this.changeHeader();
    }
  }
  else if(index == 0){
    if(this.data.list[0].dot == true){
      this.setData({
        ["list[0].dot"] : false
      })
    }
    if(this.data.MaskView == true){
      this.changeSlice();
      this.changeHeader();
    }
  }
}
,
changeSlice(){
  var InforView = this.data.InforView;
  var MaskView = this.data.MaskView;
  // console.log(InforView);
  this.setData(
    {
      InforView:!InforView,
      MaskView :!MaskView
    }
  )
}
,
changeHeader(){
  var MaskView = this.data.MaskView;
  if(MaskView == false){
    wx.setNavigationBarTitle({
      title: '考勤打卡',
    })
  }else{
    wx.setNavigationBarTitle({
      title: "个人信息",
    })
  }
}
,
getNameSlice(){
  this.setData({
    nameSlice:this.data.userName.slice(0,2)
  })
}
,
getDate(){
  var date = new Date();
  var year = date.getFullYear();
  var month = date.getMonth();
  var day = date.getDay();
  this.setData(
    {
      dayNow : day,
      monthNow : month,
      yearNow : (month > 6)? year+1:year,
      yearBefore : (month > 6)? year : year -1
    }
  );
}
,
checkRecord(){
  //查看过去记录的接口
  console.log("过去记录接口");
}
,
setPersonalInfor(){
  //修改个人信息接口
  console.log("修改个人信息接口")
}
,
setTime(){
  var data = new Date();
  var hour = data.getHours();
  var min = data.getMinutes();
  var sec = data.getSeconds();
  this.setData({
    hourNow : hour,
    minNow:min,
    secNow : sec
  })
}
,
circleSetTime(){
  var time = this.setTime;
  setInterval(time,1000);
}
,
attend(){
  //打卡接口
  console.log("打卡")
}
,
aboutUs(){
  //关于我们接口
  console.log("个人接口");
}
,
getPlace(){
  // const _locationChangeFn = function(res){
  //   console.log("location change:",res);
  // }
  // wx.onLocationChange(_locationChangeFn);
  // wx.offLocationChange(_locationChangeFn);
  var that = this;
  wx.getLocation({
    type: 'wgs84',
    success(res) {
      // this.setData({
      //   longitude:res.longitude,
      //   latitude:res.latitude
      // });
      console.log(res);
      that.setData({
        longitude:res.longitude,
        latitude:res.latitude
      })
      console.log(that.data.longitude)
      qqmapsdk.reverseGeocoder({
      location:{
        latitude:that.data.latitude,
        longitude:that.data.longitude
      },
      success:function(res){
        console.log(res);
        that.setData({
          nation: res.result.address_component.nation,
          province :res.result.address_component.province,
          city:res.result.address_component.city,
          district:res.result.address_component.district,
          street:res.result.address_component.street,
          street_number:res.result.address_component.street_number,
          rough:(res.result.formatted_addresses.rough==null)? "":res.result.formatted_addresses.rough
        })
      },
      fail:function(error){
        console.log(error);
      }
    })
    },
    fail:function(error){
      console.log("erro");
    }
   });
}
,
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.changeHeader();
    this.getDate();
    this.getNameSlice();
    this.circleSetTime();
    // this.getSpecPlace();
    qqmapsdk = new QQMapWx({
      key:'MDFBZ-IHSR5-PMWIL-QLGUG-5UX35-2KBPU'
    })
    this.getPlace();
  }
})