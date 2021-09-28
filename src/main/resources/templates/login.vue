<template>
  <div class="login">
    <img class="logo" src="../assets/image/title.png" />
    <div class="loginbg">
      <div class="logindiv">
        <p class="loginp">登 录</p>
        <el-form class="logintop" ref="loginForm" :model="loginForm" :rules="loginRules">
          <el-form-item>
            <el-input
              v-model="loginForm.username" 
              placeholder="用户名"
              prefix-icon="el-icon-user"
              class="logininp"
            >
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-input
              v-model="loginForm.password"
              type="password"
              placeholder="密码"
              prefix-icon="el-icon-lock"
              class="logininp"
            >
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-checkbox
              class="remember-checkbox"
              v-model="loginForm.rememberMe">
              记住密码
            </el-checkbox>
          </el-form-item>
          <p class="tips"><span v-show="tipsShow">用户名或密码错误，请重试。</span></p>
          <el-form-item>
            <el-button
              :loading="loading"
              size="large"
              class="loginBtn"
            >
              <span v-if="!loading">登 录</span>
              <span v-else>登 录 中...</span>
            </el-button>
        </el-form-item>
        </el-form>

        
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "",
        password: "",
        rememberMe: false
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "请输入您的账号" }
        ],
        password: [
          { required: true, trigger: "blur", message: "请输入您的密码" }
        ],
        code: [{ required: true, trigger: "change", message: "请输入验证码" }]
      },
      loading: false,
      tipsShow: false
    }
  }
}
</script>

<style>
.login {
  height: 100%;
  background: linear-gradient(to right, #3270f3, #4bc9ff);
}
/* h3{font-family: ;color: #fff;font-size:36px;letter-spacing:8px;text-align: center;margin-top:50px} */
.logo {
  display: block;
  margin: 0 auto;
  padding-top: 8%;
}
.loginbg {
  width: 70%;
  height: 450px;
  background: url("../assets/image/login.png") no-repeat;
  background-size: 60% auto;
  position: absolute;
  top: 30%;
  left: 15%;
}
.logindiv {
  width: 400px;
  height: 400px;
  padding: 0px 70px;
  float: right;
  background: #c5e4fe;
  box-shadow: 0 0 10px #2a92f2;
  -moz-box-shadow: 0 0 10px #2a92f2;
  -webkit-box-shadow: 0 0 10px #2a92f2;
  box-shadow: 0 0 10px #2a92f2;
  border-radius: 8px;
}
.loginp {
  width: 100%;
  line-height: 70px;
  font-size: 24px;
  color: #40a5fa;
  font-weight: 400;
  font-family: "Microsoft YaHei";
  text-align: center;
}
.tips {
  text-align: center;
  color: red;
  height: 20px;
  margin: 5px;
  font-size: 14px;
}
.loginBtn,.loginBtn:active,.loginBtn:visited,.loginBtn:focus{
  width: 100%;
  background: linear-gradient(to top, #3270f3, #4bc9ff);
  border: none;
  color: #fff;
}
.loginBtn:hover{
  color: #c5e4fe;
}
.logintop{margin-top:30px}
</style>
