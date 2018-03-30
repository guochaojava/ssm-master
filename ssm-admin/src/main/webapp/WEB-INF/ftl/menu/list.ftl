<#include "common/header.ftl">

<body>
<div class="container-fluid larry-wrapper">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <!--头部搜索-->
            <section class="panel panel-padding">
                <form class="layui-form" data-params='{"dataName":"articleCat","action":"list"}' action="${base}/sys/auth/menu/list">
                    <div class="layui-form">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input class="layui-input" name="name" placeholder="关键字">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button lay-submit class="layui-btn" lay-filter="search">查找</button>
                        </div>
                    </div>
                </form>
            </section>

            <!--列表-->
            <section class="panel panel-padding">
                <div class="group-button">
                    <button class="layui-btn layui-btn-small layui-btn-danger ajax-all" data-params='{"url": "${base}/sys/auth/menu/delete","confirm":"true","dataName":"articleCat","key":"id","action":"del"}'>
                        <i class="iconfont">&#xe626;</i> 删除
                    </button>

                    <button class="layui-btn layui-btn-small layui-btn-normal ajax-all" data-params='{"url": "${base}/sys/auth/menu/status","data":"switch=1","dataName":"articleCat","key":"id"}'>
                        <i class="layui-icon">&#x1005;</i> 状态
                    </button>
                    <button class="layui-btn layui-btn-small modal" data-params='{"content":".add-subcat","data":"level=0","area":"600px,430px","title":"添加分类","action":"add"}'>
                        <i class="iconfont">&#xe649;</i> 添加
                    </button>
                </div>
                <div class="layui-form">
                    <table id="example" class="layui-table jq-even" data-params='{"dataName":"articleCat","key":"id"}'>
                        <thead>
                        <tr>
                            <th width="30"><input type="checkbox" id="checkall" data-name="id" lay-filter="check" lay-skin="primary"></th>
                            <th width="70"><span class="order" data-params='{"field":"id","sort":"asc"}'> 序号</span></th>
                            <th><span class="order" data-params='{"field":"title","sort":"asc"}'>名称</span></th>
                            <th width="70" class="txt-center">排序</th>
                            <th width="80" class="txt-center">状态</th>
                            <th width="220" class="txt-center">操作</th>
                        </tr>
                        </thead>
                        <tbody id="list"></tbody>
                    </table>
                </div>
            </section>
        </div>
    </div>
</div>
<div class="add-subcat">
    <form id="form1" class="layui-form" data-params='{"dataName":"articleCat","key":"id","bind":true,"action":"add","pid":"pid"}' action="${base}/sys/auth/menu/add" method="POST">
        <div class="layui-form-item">
            <label class="layui-form-label">父级分类</label>
            <div class="layui-input-inline">
                <select name="pid" id="pid-select" jq-verify="required" jq-error="请输入分类" lay-filter="pid-select">
                    <option value="0">顶级分类</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">分类名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" required jq-verify="required" jq-error="请输入分类名称" placeholder="请输入分类名称" autocomplete="off" class="layui-input ">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">路径</label>
            <div class="layui-input-block">
                <input type="text" name="url" required jq-verify="required" jq-error="请输入路径" placeholder="请输入路径" autocomplete="off" class="layui-input ">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">排序</label>
            <div class="layui-input-inline">
                <input type="text" name="sort" required jq-verify="number" value="100" jq-error="排序必须为数字" placeholder="分类排序" autocomplete="off" class="layui-input ">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-inline">
                <input type="radio" name="status" title="启用" value="1" checked />
                <input type="radio" name="status" title="禁用" value="0" />
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" jq-submit jq-filter="submit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <input type="hidden" name="level" value="0" />
    </form>
</div>
</body>

<script id="list-tpl" type="text/html" data-params='{"url":"${base}/sys/auth/menu/list","dataName":"articleCat","select":"#select-tpl","selectid":"#pid-select"}'>
    {{# layui.each(d.list, function(index, item){ }}
    <tr>
        <td><input type="checkbox" name="id" value="{{ item.id}}" lay-skin="primary"></td>
        <td class="txt-center">{{ item.id}}</td>
        <td>{{ strRepeat('&nbsp;&nbsp;',item.level)}} {{# if(item.level>0){ }} ├&nbsp; {{# } }}<span class="edit" data-params='{"url":"${base}/sys/menu/add","field":"name","data":"id={{ item.id}}"}'> {{ item.name}}</span></td>
        <td><input type="text" class="layui-input sort ajax-blur" name="sort" value="{{ item.sort}}" data-params='{"url":"${base}/sys/menu/sort","data":"id={{ item.id}}"}'> </td>
        <td><input type="checkbox" name="status" lay-skin="switch" lay-text="ON|OFF" {{#if (item.status == 1){ }}checked="checked" {{# } }} lay-filter="ajax" value="1" data-params='{"url":"${base}/sys/menu/status","data":"id={{ item.id}}"}'> </td>
        <td>
            <div class="layui-btn-group">
                <button class="layui-btn layui-btn-mini layui-btn-normal modal" data-params='{"content":".add-subcat","area":"600px,430px","title":"添加{{ item.name}}的子分类","data":"pid={{ item.id }}&level={{ item.level+1 }}","action":"add","url":"${base}/sys/menu/add"}'>
                    <i class="iconfont">&#xe649;</i>添加子分类
                </button>
                <button class="layui-btn layui-btn-mini modal" data-params='{"url": "${base}/sys/auth/menu/add","content": ".add-subcat","area":"600px,1000px","title":"编辑{{ item.name}}分类","type":"1","data":"id={{ item.id }}","form":"#form1","bind":"true","fillAll":true,"action":"edit"}'>
                    <i class="iconfont">&#xe653;</i>编辑
                </button>
                <button class="layui-btn layui-btn-mini layui-btn-danger ajax" data-params='{"url": "${base}/sys/auth/menu/delete","confirm":"true","action":"del","data":"id={{ item.id}}"}'>
                    <i class="iconfont">&#xe626;</i>删除
                </button>
            </div>
        </td>
    </tr>
    {{# }); }}

</script>

<script id="select-tpl" type="text/html" data-params='{"dataName":"articleCat"}'>
    <option value="0" data-level="0">顶级分类</option>
    {{# layui.each(d.list, function(index, item){ }}
    <option value="{{ item.id}}" data-level="{{ item.level}}"> {{ strRepeat('&nbsp;&nbsp;',item.level)}} {{# if(item.level>0){ }} ├&nbsp; {{# } }} {{ item.name}}</option>
    {{# }); }}
</script>

<script src="${base}/static/js/layui/layui.js"></script>
<script src="${base}/static/js/common.js"></script>
<#include "common/version.ftl">
<script>
    layui.use('list');
</script>

</html>