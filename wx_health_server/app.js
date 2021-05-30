// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
  },
  canSub:function(){
    console.log(this.globalData);
    if(this.globalData.umajor!=null &&this.globalData.uschool != null && this.globalData.uacademy != null && this.globalData.uclass != null &&this.globalData.utrueName !=null){
      return true;
    }
    else{
      return false;
    }
  }
  ,
  getTimeOfUid(uid){
    return this.globalData.ddt.uid;
  }
  ,
  setGender(tf){
    this.globalData.ugender = tf;
  }
  ,
  setDdt(uid,time){
    this.globalData.ddt["{uid}"] = time;
  }
  ,
  globalData: {
    "ddt" : {
    },
    "canSub" : false,
    "province":"青海省",
    "city":"西宁市",
    "county":"城东区",
    "detailLocation":"清真巷街道",
    "temperature":37,
    "healthcode":"绿码",
    "authorization" : "",
    "ucreatedTime":" ",
    "wxCode": null,
    "uid": "1",
    "utypeId" : 1,
    "ugender" : true,
    "uclass" : null,
    "ustuNum" : null,
    "ugrade" : 1,
    "umajor" :  null,
    "unickname" : "",
    "uschool" : "浙江工业大学",
    "uacademy" : null,
    "utrueName" : null
  }
  ,
  setPlace(place){
    this.globalData.province = place.province;
    this.globalData.city = place.city;
    this.globalData.county= place.county;
    this.globalData.detailLocation = place.detailLocation;
    console.log(this.globalData);
  }
  ,
  setTemperature:function(tem){
    this.globalData.temperature = tem;
  }
  ,
  setDdt(ddt){
    this.globalData.ddt = ddt;
  }
  ,
  submit(){
    wx.request({
      url: 'https://www.zjutleo.cn/health/addTimecard',
      method:"POST",
      data :{
        "u_id" : this.globalData.uid,
        "province" : this.globalData.province,
        "city" : this.globalData.city,
        "county" : this.globalData.county,
        "temperature" : parseFloat(this.globalData.temperature),
        "healthcode" : this.globalData.healthcode
      },
      header:{
        "authorization": this.globalData.authorization,
        "content-type":  'application/json'
      },
      success : function(res){
        console.log(res);
        wx.showToast({
          title: res.data.data,
          icon: "none",     //默认值是success,就算没有icon这个值，就算有其他值最终也显示success
          duration: 2000,      //停留时间
        })
      }
      ,
      fail:function(res){
        console.log(res);
      }
    })
  }
  ,
  getIfMana(){
    console.log(this.globalData.utypeId)
    return (this.globalData.utypeId == 0 || this.globalData.utypeId == "0");
  }
  ,
  setMa(ma){
    this.globalData.healthcode = ma;
  }
  ,
  getUid(){
    return this.globalData.uid;
  },
  getWxcode(){
    return this.globalData.wxCode;
  }
  ,
  getUstuNum(){
    return this.globalData.ustuNum;
  }
  ,
  setTruename(tn){
    this.globalData.utrueName = tn
  }
  ,
  setSno(sno){
    this.globalData.ustuNum = sno
  }
  ,
  setAca(aca){
    this.globalData.uacademy = aca
  }
  ,
  setMajoy(m){
    this.globalData.umajor = m;
  }
  ,
  setClass(c){
    this.globalData.uclass = c;
  }
  ,
  setGrade(g){
    this.globalData.ugrade = g;
  }
  ,
  setSchool(sch){
    this.globalData.uschool = sch;
  }
  ,
  update(obj){
      console.log(obj)
      this.globalData.authorization = obj.token;
      this.globalData.ucreatedTime = obj.ucreatedTime;
      this.globalData.uid = obj.uid;
      this.globalData.utypeId = 0;
      this.globalData.ugender = obj.ugender;
      this.globalData.ustuNum = obj.ustuNum;
      this.globalData.utrueName = obj.utrueName;
      this.globalData.uclass = obj.uclass;
      this.globalData.ugrade = obj.ugrade;
      this.globalData.umajor = obj.umajor;
      this.globalData.unickname = " ";
      this.globalData.uschool = obj.uschool;
      this.globalData.uacademy = obj.uacademy;
     console.log(this.globalData);
  }
  ,
  setInforAgain:function(){
    wx.request({
      url: 'https://www.zjutleo.cn/health/user/me',
      method:"PUT",
      data:{
      "uid": parseInt(this.globalData.uid),
      "utypeId": this.globalData.utypeId,
      "uavatarUrl": "  ",
      "ugender": this.globalData.ugender,
      "utrueName": this.globalData.utrueName,
      "uclass": this.globalData.uclass, 
      "ustuNum": this.globalData.ustuNum,
      "ugrade": this.globalData.ugrade,
      "umajor": this.globalData.umajor,
      "unickname": "  ",
      "uschool": this.globalData.uschool,
      "uacademy": this.globalData.uacademy
      },
      header:{
      "authorization": this.globalData.authorization,
      "content-type":  'application/json'
       },
       success : function(res){
         console.log(res.data);
       }
    })
  }
})

