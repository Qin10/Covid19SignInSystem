// pages/CheckPose/CheckPage.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ddt :{}
    ,
    title:"未打卡信息",
    MaskView : false,
    tableHeader: ["姓名", "学校", "学院","学号","打卡时间","班级"],  // 表格标题
    tableStrata: [
    ],
    tableHeaderT: ["姓名", "学校", "学院","学号","班级"],  // 表格标题
    tableStrataT: [
    ]
  },
  getUidOf(uid){
    return this.data.ddt[uid];
  }
  ,
  requireAll:function(){
    var that = this;
    var arr = [];
    wx.request({
      url: 'https://www.zjutleo.cn/health/query/timecardsBySchoolInfoOnToday',
      header:{
        "authorization": app.globalData.authorization,
        "content-type":  'application/json'
      },
      method:"POST",
      data:{
        "school" : app.globalData.uschool
      },
      success:function(res){
        that.setData({
          tableStrata :[]
        });
        var date  = res.data.data;
        var i = 0;
        for(i = 0;i<date.length;i++){
          var uid = date[i].uid;
          that.setData({
            ['ddt.'+uid] : date[i].datetime
          })
        }
        for(i= 0;i<date.length;i++){
          var uid = date[i].uid;
          wx.request({
            url: 'https://www.zjutleo.cn/health/user/'+uid,
            header:{
              "authorization": app.globalData.authorization,
              "content-type":  'application/json'
            }
            ,
            method:"GET"
            ,
            success:function(result){
              var dataU = result.data.data;
              var uid = dataU.uid;
              console.log(uid)
              arr.push([
                dataU.utrueName,dataU.uschool,dataU.uacademy,dataU.ustuNum,that.getUidOf(uid),dataU.uclass
              ]);
              that.setData({
                tableStrata : arr
              })
            }
          });
        }
      }
    })
  }
  ,
  requireAllDont : function(){
    var that = this;
    var arr = [];
    wx.request({
      url: 'https://www.zjutleo.cn/health/query/usersNotSignInOnToday',
      header:{
        "authorization": app.globalData.authorization,
        "content-type":  'application/json'
      }
      ,
      method : "POST"
      ,
      data:{
        "school": app.globalData.uschool
      }
      ,
      success:function(res){
        that.setData({
          tableStrataT :[]
        });
        console.log(res.data.data);
        var date  = res.data.data;
        var i = 0;
        for(i= 0;i<date.length;i++){
          var uid = date[i].uid;
          wx.request({
            url: 'https://www.zjutleo.cn/health/user/'+uid,
            header:{
              "authorization": app.globalData.authorization,
              "content-type":  'application/json'
            }
            ,
            method:"GET"
            ,
            success:function(result){
              var dataU = result.data.data;
              arr.push([
                dataU.utrueName,dataU.uschool,dataU.uacademy,dataU.ustuNum,dataU.uclass
              ]);
              that.setData({
                tableStrataT : arr
              })
            }
          });
        }
      }
    })
  }
  ,
  left:function(){
    this.setData({
      MaskView : false,
      title : "未打卡信息"
    })
  }
  ,
  right:function(){
    this.setData({
      MaskView : true,
      title : "已打卡信息"
    })
  }
  ,
  onLoad: function (options) {
    this.requireAll();
    this.requireAllDont();
  }
  ,
  onReady: function () {

  },

  onShow: function () {

  },

  onHide: function () {

  },

  onUnload: function () {

  },

  onPullDownRefresh: function () {

  },

  onReachBottom: function () {

  },
  onShareAppMessage: function () {

  }
})