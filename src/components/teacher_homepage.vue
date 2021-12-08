<template>
    <ul class="shell">
        <li class="button">
            <span>作业模块</span>
            <ul>
                <li>布置作业</li>
                <li>作业批改</li>
                <li>发布分析报告</li>
                <li>在线答疑</li>
            </ul>
        </li>
        <li class="button">
            <span>班级模块</span>
            <ul>
                <li>通告发布</li>
                <li>小组管理</li>
                <li>查看班级</li>
                <li>联系家长</li>
            </ul>
        </li>
    </ul>
</template>

<script>
    export default {
        name: "teacher_homepage"
    }
</script>

<style scoped>
    * {
        margin: 0;
        padding: 0;
        list-style: none;
        font-size: 20px;
        color: #f4f1de;
    }

    body {
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        background-image:linear-gradient(to right, #a18cd1, #fbc2eb);
    }
    .shell{
        display: flex;
        justify-content: center;
    }
    .button,.portrait{
        background-color: #50536e;
        width: 170px;
        height: 65px;
        text-align: center;
        line-height: 65px;
        transition: .3s;
        cursor: pointer;
    }
    .portrait::before{
        content: '';
        display: block;
        width: 100px;
        height: 100px;
        border-radius: 50%;
        transform: translate(30px,-30px);
        background: darkturquoise;
        background-size: cover;
        border: 10px solid #fff;
    }
    .information{
        width: 220px;
        background-color: #e07a5f;
        transform: translate(-20px,-200px);
        border-radius: 10px;
        padding: 20px 0;
        line-height: 0;
        height: 0;
        transition: .3s;
        opacity: 0;

    }
    .button:hover{
        background-color: #d15a39;
    }
    .button li:hover{
        background-color: #ffb29d;
    }
    .button ul li{
        height: 0;
        transition: .2s;
        opacity: 0;
        transform: translateY(-65px);
        background-color: #e07a5f;
    }
    .button:hover li{
        height: 65px;
        opacity: 1;
        transform: translateY(0);
    }
    .portrait:hover .information{
        opacity: 1;
        line-height: 65px;
        transform: translate(-20px,-10px);
        height: auto;
    }
</style>