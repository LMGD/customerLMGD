<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>


<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="用户登录" style="width:80%;height: 60%">

    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="load" method="post">
            <table cellpadding="5">
                <tr>
                    <td>用户名 :</td>
                    <td>
                        <input class="easyui-textbox" type="text"  name="usrName" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="usrPassword" value="" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <div style="text-align:left;padding:5px;padding-left: 50px;">
                            <input type="submit" value="确定" name="ok" class="easyui-linkbutton" style="padding:6px;"/>                                         <input type="button" value="重置" name="clear" class="easyui-linkbutton" style="padding:6px;"/>
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