<#include "common/header.ftl">

<body>
<div class="container-fluid larry-wrapper">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <section class="panel panel-padding">
                <form id="form1" class="layui-form" data-params='{"dataName":"admin","action":"nodo"}' action="${base}/sys/user/add" method="post">
                    <input type="hidden" name="id" value="${user.id}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">帐号</label>
                        <div class="layui-input-block">
                            <input type="text" readonly required jq-verify="required" value="${user.loginName}" jq-error="请输入帐号" placeholder="请输入帐号" autocomplete="off" class="layui-input ">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="pwd" placeholder="密码"  autocomplete="off" class="layui-input ">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码确认</label>
                        <div class="layui-input-block">
                            <input type="password" name="pwd2" placeholder="密码确认" autocomplete="off" class="layui-input ">
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" placeholder="姓名" value="${user.userName}" autocomplete="off" class="layui-input ">
                        </div>
                    </div>
                    <div class="layui-form-item" pane>
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-inline">
                            <input type="radio" name="sex" title="男" value="1" <#if user.sex == 1> checked </#if> />
                            <input type="radio" name="sex" title="女" value="0" <#if user.sex == 0> checked </#if>/>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">手机</label>
                        <div class="layui-input-block">
                            <input type="text" name="telephone" placeholder="手机号码" value="${user.telephone}" autocomplete="off" class="layui-input ">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input type="text" name="email" placeholder="邮箱" value="${user.email}" autocomplete="off" class="layui-input ">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" jq-submit jq-filter="submit">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" src="${base}/static/js/layui/layui.js"></script>
<#include "common/version.ftl">
<script>
    layui.use('simpleform');
</script>

</html>