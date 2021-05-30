// pages/showResult/showResult.js
const app = getApp();
var startX, endX;
var moveFlag = true;
Page({
  data: {
    tableHeader: ["打卡时间", "打卡地点", "体温","健康码"],  // 表格标题
    tableStrata: [
    ],
  },
  getTime(){
    var that = this;
    wx.request({
      url: 'https://www.zjutleo.cn/health/query/timecardsSomeDaysAgoById ',
      method:"POST",
      data:{
        "u_id" : app.globalData.uid,
        "days" : 7
      },
      header:{
        "authorization": app.globalData.authorization,
        "content-type":  'application/json'
      },
      success:function(res){
        console.log(res);
        var arr = [];
        var array = res.data.data;
        var i = 0;
        for( i = 0;i < array.length;i++){
          arr.push([
            array[i].datetime,
            array[i].province+array[i].city+array[i].county,
            array[i].temperature,
            array[i].healthcode
          ])
        }
        that.setData({
          tableStrata : arr
        })
      }
    })
  }
,
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getTime();
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