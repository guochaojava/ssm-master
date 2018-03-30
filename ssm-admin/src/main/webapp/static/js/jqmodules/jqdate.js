/*
 * @Author: Paco
 * @Date:   2017-02-13
 * +----------------------------------------------------------------------
 * | jqadmin [ jq酷打造的一款懒人后台模板 ]
 * | Copyright (c) 2017 http://jqadmin.jqcool.net All rights reserved.
 * | Licensed ( http://jqadmin.jqcool.net/licenses/ )
 * | Author: Paco <admin@jqcool.net>
 * +----------------------------------------------------------------------
 */

layui.define(['jquery', 'laydate'], function(exports) {
    var $ = layui.jquery,
        laydate = layui.laydate,
        normal = {
            min: '1900-01-01 00:00:00', //最小日期
            max: '2099-12-31 23:59:59', //最大日期
            choose: function(datas) {
                end.min = datas;
                end.start = datas
            }
        },

        start = {
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istoday: false,
            choose: function(datas) {
                end.min = datas;
                end.start = datas
            }
        },

        end = {
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istoday: false,
            choose: function(datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };

    $('.start-date').click(function() {
        start.elem = this;
        laydate(start);
    })

    $('.normal-date').click(function() {
        normal.elem = this;
        laydate(normal);
    })

    $('.end-date').click(function() {
        end.elem = this;
        laydate(end);
    })

    exports('jqdate', {});
});