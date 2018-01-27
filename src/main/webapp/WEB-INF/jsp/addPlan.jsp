<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script>
    /**
     * 为table指定行添加一行
     *
     * tab 表id
     * row 行数，如：0->第一行 1->第二行 -2->倒数第二行 -1->最后一行
     * trHtml 添加行的html代码
     *
     */
    function addTr(tab, row, trHtml){
        //获取table最后一行 $("#tab tr:last")
        //获取table第一行 $("#tab tr").eq(0)
        //获取table倒数第二行 $("#tab tr").eq(-2)
        var $tr=$("#"+tab+" tr").eq(row);
        if($tr.size()==0){
            alert("指定的table id或行数不存在！");
            return;
        }
        $tr.after(trHtml);
    }

    ////////添加一行、删除一行测试方法///////
    function addTr2(tab, row){
        var trHtml="<tr>\n" +
            "                    <td data-options=\"width:200,align:'center'\">\n" +
            "                        <input  type=\"text\" name=\"plaTodos\" ></input>\n" +
            "                        <span style=\"color: red\">*</span>\n" +
            "                    </td>\n" +
            "                    <td data-options=\"width:200,align:'center'\">\n" +
            "                        <input type=\"text\" name=\"plaResults\" ></input>\n" +
            "                    </td>\n" +
            "                </tr>";
        addTr(tab, row, trHtml);
    }

    //每次移除倒数第二行
    function doDel(tab){
        $("#ff tr").eq(-2).remove();
    }

</script>

<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="新增营销计划" style="width:80%;height: 60%">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="doAddPlan" method="post">
            <table cellpadding="5">
              <tr>
                <td data-options="width:200,align:'center'">计划内容</td>
                <td data-options="width:200,align:'center'">计划执行结果</td>
              </tr>
                <tr>
                    <td data-options="width:200,align:'center'">
                        <input  type="hidden" name="plaChcId" value="${plaChcId}" ></input>
                        <input class="easyui-textbox" type="text" name="plaTodos" ></input>
                        <span style="color: red">*</span>
                    </td>
                    <td data-options="width:200,align:'center'">
                        <input class="easyui-textbox" type="text" name="plaResults" ></input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="text-align:left;padding:5px;padding-left: 50px;">
                            <input type="submit" value="确定" name="ok" class="easyui-linkbutton" style="padding:6px;"/>
                            <input type="button" onclick="addTr2('ff', -2)" value="添加" name="ok"
                                   class="easyui-linkbutton" style="padding:6px;"/>

                            <input type="button" onclick="doDel('ff')" value="移除" name="clear"
                                   class="easyui-linkbutton" style="padding:6px;"/>
                        </div>
                    </td>
                </tr>
            </table>

        </form>

    </div>
</div>
<script>

//    function submitForm(){
//        $('#ff').form('submit');
//    }
//    function clearForm(){
//        $('#ff').form('clear');
//    }
</script>
</body>
</html>