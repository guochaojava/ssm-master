<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>后台</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- ico -->
    <link rel="icon" href="${base}/static/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="${base}/static/favicon.ico" type="image/x-icon">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${base}/static/css/font/iconfont.css?v=1.0.0" media="all">
    <link rel="stylesheet" type="text/css" href="${base}/static/css/layui.css?v=1.0.9" media="all">
    <link rel="stylesheet" type="text/css" href="${base}/static/css/jqadmin.css?v=2.0.0" media="all">
</head>

<body>
<ul class='right-click-menu' style="display: none">
    <li><a href='javascript:;' data-event='fresh'>刷新</a></li>
    <li><a href='javascript:;' data-event='close'>关闭</a></li>
    <li><a href='javascript:;' data-event='other'>关闭其它</a></li>
    <li><a href='javascript:;' data-event='all'>全部关闭</a></li>
</ul>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <!-- logo区域 -->
        <div class="jqadmin-logo-box">
            <a class="logo" href="http://www.djfy365.com" target="_blank" title="大集方圆">
                <h1>大集方圆</h1>
            </a>
            <div class="menu-type"><i class="iconfont">&#xe61a;</i></div>
        </div>

        <!-- 主菜单区域 -->
        <div class="jqadmin-main-menu">
            <ul class="layui-nav clearfix" id="menu" lay-filter="main-menu">

            </ul>

        </div>

        <!-- 头部右侧导航 -->
        <div class="header-right">
            <ul class="layui-nav jqadmin-header-item right-menu">
                <li class="layui-nav-item first">
                    <a href="javascript:;">
                        <cite>${user.loginName}</cite>
                        <span class="layui-nav-more"></span>
                    </a>

                    <dl class="layui-nav-child">
                        <dd class="tab-menu">
                            <a href="javascript:;" data-url="${base}/sys/userInfo" data-title="个人信息"> <i class="iconfont " data-icon='&#xe672;'>&#xe672; </i><span>个人信息</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" onclick="logout();" data-title="退出"><i class="iconfont ">&#xe64b; </i>退出</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item tab-menu"><a class="msg" href="javascript:;" data-url="" data-title="站内信息"><i class="iconfont" data-icon='&#xe63c;'>&#xe63c; </i><span class="msg-num">0</span></a></li>
            </ul>
            <button title="刷新" class="layui-btn layui-btn-normal fresh-btn"><i class="iconfont">&#xe62e; </i> </button>
        </div>
    </div>

    <!-- 左侧导航-->
    <div class="layui-side layui-bg-black jqamdin-left-bar">
        <div class="layui-side-scroll">
            <!--子菜单项-->

            <div id="submenu"></div>
        </div>
    </div>

    <!-- 左侧侧边导航结束 -->
    <!-- 右侧主体内容 -->
    <div class="layui-body jqadmin-body">

        <div class="layui-tab layui-tab-card jqadmin-tab-box" id="jqadmin-tab" lay-filter="tabmenu" lay-notAuto="true">
            <ul class="layui-tab-title">
                <li class="layui-this" id="admin-home" lay-id="0" fresh=1><i class="iconfont">&#xe622;</i><em>后台首页</em></li>

            </ul>
            <div class="menu-btn" title="显示左则菜单">
                <i class="iconfont">&#xe616;</i>
            </div>
            <div class="tab-move-btn">
                <span>更多<i class="iconfont">&#xe604;</i></span>

                <!--<span class="move-left-btn"><i class="iconfont">&#xe616;</i></span>
                <span class="move-right-btn"><i class="iconfont ">&#xe618;</i></span>-->
            </div>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe class="jqadmin-iframe" data-id='0' src="${base}/sys/welcome"></iframe>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部区域 -->
    <div class="layui-footer jqadmin-foot">
        <div class="layui-mian">
            <p class="jqadmin-copyright">
                <span class="layui">—— Copyright © 2013</span> <a href="http://www.djfy365.com" target="_blank">大集方圆</a>(中国). <span class="layui">All rights reserved.|Privacy Policy</span>
            </p>
        </div>
    </div>
</div>
<div class="my-tip">
    <img src="" alt="" />
</div>
<ul class="menu-list" id="menu-list"></ul>
</body>

<script id="menu-tpl" type="text/html" data-params='{"url":"${base}/sys/menuList","listid":"menu"}'>
    {{# layui.each(d.list, function(index, item){ }}
    <li class="layui-nav-item {{# if(index==0){ }}layui-this{{# } }}">
        <a href="javascript:;" data-title="{{item.name}}"><i class="iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}">{{item.iconfont}}</i><span>{{item.name}}</span></a>
    </li>
    {{# }); }}
</script>

<script id="submenu-tpl" type="text/html">
    {{# layui.each(d.list, function(index, menu){ }}
    <div class="sub-menu">
        <ul class="layui-nav layui-nav-tree">
            {{# layui.each(menu.sub, function(index, submenu){ }} {{# if(submenu.sub && submenu.sub.length>0){ }}
            <li class="layui-nav-item" data-bind="0">
                <a href="javascript:;" data-title="{{submenu.name}}">
                    <i class="iconfont {{# if(!d.showIcon){ }} hide-icon  {{# } }}">{{submenu.iconfont}}</i>
                    <span>{{submenu.name}}</span>
                    <em class="layui-nav-more"></em>
                </a>
                <dl class="layui-nav-child">
                    {{# layui.each(submenu.sub, function(index, secMenu){ }}
                    <dd>
                        <a href="javascript:;" data-url="{{secMenu.url}}" data-title="{{secMenu.name}}">
                            <i class="iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}" data-icon='{{secMenu.iconfont}}'>{{secMenu.iconfont}}</i>
                            <span>{{secMenu.name}}</span>
                        </a>
                    </dd>
                    {{# }); }}
                </dl>
            </li>
            {{# }else{ }}
            <li class="layui-nav-item">
                <a href="javascript:;" data-url="{{submenu.url}}" data-title="{{submenu.name}}">
                    <i class="iconfont  {{# if(!d.showIcon){ }} hide-icon  {{# } }}" data-icon='{{submenu.iconfont}}'>{{submenu.iconfont}}</i>
                    <span>{{submenu.name}}</span>
                </a>
            </li>
            {{# } }} {{# }); }}
        </ul>
    </div>
    {{# }); }}
</script>

<script id="menu-list-tpl" type="text/html">

    {{# layui.each(d.list, function(index, item){ }}
    <li>
        <a href="javascript:;" data-url="{{item.href}}" data-title="{{item.title}}">
            <i class="iconfont " data-icon='{{item.icon}}'>{{item.icon}}</i>
            <span>{{item.title}}</span>
        </a>
    </li>
    {{# }); }}

</script>

<script type="text/javascript" src="${base}/static/js/layui/layui.js"></script>
<#include "common/version.ftl">
<script>
    var global = {};
    layui.use('index');
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?9e99ae60a18de5e3860d7bfffc86a85d";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();

    function logout() {
        layer.confirm('您确定要离开我嘛？', {
            title:"提示",
            btn: ['这事不能勉强','好嘛再陪你一会'] //按钮
        }, function(){
            window.location = "${base}/sys/logout"
        });
    }
</script>

</html>