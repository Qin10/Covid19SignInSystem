// pages/submit/submit.js\
const app = getApp();
Page({
  data: {
    green:true,
    red:false
  },
  setTemperature:function(e){
    app.setTemperature(e.detail.value);
    console.log(app.globalData.temperature);
  } 
  ,
  submit:function(){
    if(this.data.green){
      app.setMa("绿码");
    }
    else{
      app.setMa("红码");
    }
    console.log(app.globalData.healthcode);
    if(app.canSub()){
      app.submit();
      wx.navigateBack({
        delta: 0
      })
    }else{
      wx.showToast({
        title: '请完善信息后再打卡',
        icon: "none",     //默认值是success,就算没有icon这个值，就算有其他值最终也显示success
        duration: 2000,      //停留时间
      })
    }
  }
  ,
  setGreen:function(e){
    this.setData({
      green : true,
      red : false
    });
  }
  ,
  setRed:function(e){
    this.setData({
      green : false,
      red : true
    })
  }
  ,
  onLoad: function (options) {
  },
  onReady: function () {
  },
  onShow: function () {
    if(this.green){
      app.setMa("绿码");
    }
    else{
      app.setMa("红码");
    }
  }
})