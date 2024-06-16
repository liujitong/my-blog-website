import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {  
    UserInfo: sessionStorage.getItem('UserInfo') ? JSON.parse(sessionStorage.getItem('UserInfo')) : {  
      uid:'',  
      username:'',  
      pwd:'',  
      mail:'',  
      url:'',  
      group:'',  
      screenName:'',  
    },  
  },
  getters: {
    getUserInfo: state => {
      return state.UserInfo
    }
  },
  mutations: {
    SET_USERINFO(state,UserInfo){
      state.UserInfo = UserInfo
      sessionStorage.setItem("UserInfo", JSON.stringify(UserInfo));
    },
    REMOVE_USERINFO(state){  
      state.UserInfo = {  
        uid:'',  
        username:'',  
        pwd:'',  
        mail:'',  
        url:'',  
        group:'',  
        screenName:'',  
      };  
      sessionStorage.removeItem("UserInfo"); // 删除项，而不是设置空字符串  
    }
  },
  actions: {
  },
  modules: {
  }
})
