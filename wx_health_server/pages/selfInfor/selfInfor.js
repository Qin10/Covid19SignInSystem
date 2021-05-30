// pages/selfInfor/selfInfor.js
var app = getApp();
Page({
  /**
   * 页面的初始数据
   */
  data: {
    range:false,
    show:false,//控制下拉列表的显示隐藏，false隐藏、true显示
    selectData:['浙江工业大学','杭州电子科技大学','浙江理工大学','杭州电子科技大学','浙江大学','浙江传媒大学'],//下拉列表的数据
    index:0,//选择的下拉列表下标
    tureName : "1",
    school : "1",
    aca : "1",
    grade : "1",
    sno : "1",
    marjor : "1",
    class : "1",
    manDe: true,
    woManDe : false
  },
  selectTap(){
    this.setData({
     show: !this.data.show,
     range :! this.data.range
    });
    },
    // 点击下拉列表
    optionTap(e){
    let Index=e.currentTarget.dataset.index;//获取点击的下拉列表的下标
    this.setData({
     index:Index,
     show:!this.data.show,
     range :! this.data.range
    });
    app.setSchool(this.data.selectData[Index]);
    },
  updateSub(){
    this.setData({
      tureName : app.globalData.utrueName,
     school : app.globalData.school,
     aca : app.globalData.uacademy,
     grade : app.globalData.ugrade,
     sno : app.globalData.ustuNum,
     marjor : app.globalData.umajor,
     class : app.globalData.uclass,
    })
  }
  ,
  checkedO : function(){
    this.setData({
      manDe : true,
      woManDe : false
    })
    app.setGender(true);
    console.log(app.globalData.ugender)
  },
  checkedT: function(){
    this.setData({
      manDe : false,
      woManDe :true
    })
    app.setGender(false);
    console.log(app.globalData.ugender)
  },
  setTrueName:function(e){
    app.setTruename(e.detail.value);
  }
  ,
  setSchool : function(e){
    app.setSchool(e.detail.value);
  }
  ,
  setAca:function(e){
    app.setAca(e.detail.value);
  },
  setGrade : function(e){
    app.setGrade(parseInt(e.detail.value));
  }
  ,
  setSno : function(e){
    app.setSno(e.detail.value);
  }
  ,
  setMajor : function(e){
    app.setMajoy(e.detail.value);
  }
  ,
  setClass : function(e){
    app.setClass(e.detail.value);

  }
  ,
  setAgain(){
    app.setInforAgain();
    wx.navigateBack({
      delta: 0,
    });
  }
  ,
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    app.setGender(true);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.updateSub();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})