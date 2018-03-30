<#include "common/header.ftl">

<body>
<div class="container-fluid larry-wrapper">
    <!--顶部统计数据预览 -->
    <div class="row">
        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel">
                <div class="symbol bgcolor-blue"> <i class="iconfont">&#xe672;</i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="用户总量"><i class="iconfont " data-icon='&#xe672;'></i>
                        <h1>${view.total}</h1>
                    </a>

                    <a href="javascript:;" data-url="#" data-parent="true" data-title="用户总量"> <i class="iconfont " data-icon='&#xe672;'></i><span>用户总量</span></a>

                </div>
            </section>
        </div>
        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel">
                <div class="symbol bgcolor-commred"> <i class="iconfont">&#xe674;</i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="今日注册"> <i class="iconfont " data-icon='&#xe674;'></i>
                        <h1>${view.today}</h1>
                    </a>

                    <a href="javascript:;" data-url="#" data-parent="true" data-title="今日注册"> <i class="iconfont " data-icon='&#xe674;'></i><span>今日注册</span></a>

                </div>
            </section>
        </div>

        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel">
                <div class="symbol bgcolor-dark-green"> <i class="iconfont">&#xe6bc;</i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="订单总数"> <i class="iconfont " data-icon='&#xe6bc;'></i>
                        <h1>${view.orderTotal}</h1>
                    </a>
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="订单总数"> <i class="iconfont " data-icon='&#xe6bc;'></i><span>订单总数</span></a>
                </div>
            </section>
        </div>

        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel">
                <div class="symbol bgcolor-yellow-green"> <i class="iconfont">&#xe649;</i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="今日新增"> <i class="iconfont " data-icon='&#xe649;'></i>
                        <h1>${view.orderToday}</h1>
                    </a>
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="今日新增"> <i class="iconfont " data-icon='&#xe649;'></i><span>今日新增</span></a>
                </div>
            </section>
        </div>

        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel">
                <div class="symbol bgcolor-orange"> <i class="iconfont">&#xe638;</i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="评论总数"> <i class="iconfont " data-icon='&#xe638;'></i>
                        <h1>0</h1>
                    </a>
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="评论总数"> <i class="iconfont " data-icon='&#xe638;'></i><span>评论总数</span></a>
                </div>
            </section>
        </div>

        <div class="col-xs-6 col-sm-4 col-md-2">
            <section class="panel">
                <div class="symbol bgcolor-yellow"> <i class="iconfont">&#xe669;</i>
                </div>
                <div class="value tab-menu">
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="今日评论"> <i class="iconfont " data-icon='&#xe669;'></i>
                        <h1>0</h1>
                    </a>
                    <a href="javascript:;" data-url="#" data-parent="true" data-title="今日评论"> <i class="iconfont " data-icon='&#xe669;'></i><span>今日评论</span></a>
                </div>
            </section>
        </div>

    </div>
    <div class="row">
        <div class="col-xs-12">

            <blockquote class="layui-elem-quote">当前时间：${time}</blockquote>

        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <section class="panel">
                <div class="panel-heading">
                    数据统计
                    <a href="javascript:;" class="pull-right panel-toggle"><i class="iconfont">&#xe604;</i></a>
                </div>
                <div class="panel-body">
                    <div class="echarts" id="echarts"></div>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-md-6">
            <section class="panel">
                <div class="panel-heading">
                    网站信息
                    <a href="javascript:;" class="pull-right panel-toggle"><i class="iconfont">&#xe604;</i></a>
                </div>
                <div class="panel-body">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <td>
                                <strong>软件名称</strong>：

                            </td>
                            <td>
                                <a href="http://www.djfy365.com">大集方圆小程序后台</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>软件版本</strong>：

                            </td>
                            <td>
                                V1.0.0
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <strong>开发作者</strong>：
                            </td>
                            <td>djfy</td>
                        </tr>
                        <tr>
                            <td>
                                <strong>公司官网</strong>：
                            </td>
                            <td>
                                <a href="http://www.djfy365.com" target="_blank">山西大集方圆科技有限公司</a>
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <strong>服务器环境</strong>：
                            </td>
                            <td>windows/linux</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
        <div class="col-xs-12 col-md-6">
            <section class="panel log">
                <div class="panel-heading">
                    更新日志
                    <a href="javascript:;" class="pull-right panel-toggle"><i class="iconfont">&#xe604;</i></a>
                </div>
                <div class="panel-body">
                    <h2>小程序后台v1.0.0 2017-9-20</h2>
                    <ul>
                        <li> 项目搭建</li>
                        <li> 使用swagger2建立接口文档</li>
                        <li> 更新redis使用方式</li>
                        <li> 后台基础功能开发</li>
                        <li> 其他一些功能不列举了</li>
                    </ul>

                </div>
            </section>
        </div>
    </div>

</div>

<div class="testcatch" style="display: none;">
    <p>这是一个捕获弹窗</p>
</div>
</body>
<script type="text/javascript" src="${base}/static/js/layui/layui.js"></script>
<#include "common/version.ftl">
<script>
    layui.use(['main', 'echart']);
</script>

</html>