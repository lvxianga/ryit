<template>
    <div class="a">
        <div class="b"></div>
        <div class="c">
            <div class="d">
                <form method="post" action="http://localhost:8080/web_war_exploded/userlogin?type=User">
                    <h1>登录</h1>
                    <input type="text" class="e" name="username" placeholder="用户名">
                    <input type="text" class="e" name="password" placeholder="密码">
                    <a href="#" class="f">忘记密码?</a>
                    <input type="submit" class="g" value="登录"/>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "user_login"
    }
</script>

<style scoped>
    body{
        /* 设置背景渐变 */
        background-image: linear-gradient(to left,
        #9c88ff,#3cadeb);
        display: flex;
        justify-content: center;
    }
    .a{
        position:relative;
        top: 100px;
        left: 200px;
        width: 1100px;
        height: 550px;
        box-shadow: 0 5px 15px rgba(0,0,0,.8);
        display: flex;
    }
    .b{
        width: 800px;
        height: 550px;
        background-image: url("../../src/img/user_backgourd.jpg");
        /* 让图片适应大小 */
        background-size: cover;
    }
    .c{
        width: 300px;
        height: 550px;
        background-color: white;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .d{
        width: 250px;
        height: 500px;
    }
    .d h1{
        font: 900 30px '';
    }
    .e{
        width: 230px;
        margin: 20px 0;
        outline: none;
        border: 0;
        padding: 10px;
        border-bottom: 3px solid rgb(80,80,170);
        font: 900 16px '';
    }
    .f{
        float: right;
        margin: 10px 0;
    }
    .g{
        position: absolute;
        margin: 20px;
        bottom: 40px;
        display: block;
        width: 200px;
        height: 60px;
        font: 900 30px '';
        text-decoration: none;
        line-height: 50px;
        border-radius: 30px;
        background-image: linear-gradient(to left,
        #9c88ff,#3cadeb);
        text-align: center;
    }
</style>