<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>

<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="新增营销机会" style="width:100%;height: 100%">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="doAddChance" method="post">
            <table cellpadding="5">
                <tr>
                    <td>机会来源:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcSource" ></input>
                    </td>
                </tr>
                <tr>
                    <td>客户名称:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcCustName" data-options="required:true"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>概要:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcTitle" data-options="required:true"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>成功机率:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcRate" data-options="required:true"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>

                <tr>
                    <td>
                        联系人:
                    </td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcLinkman" ></input>
                    </td>
                </tr>
                <tr>
                    <td>联系人电话:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcTel"></input>
                    </td>
                </tr>
                <tr>
                    <td>机会描述:</td>
                    <td>
                        <input class="easyui-textbox" name="chcDesc"  data-options="multiline:true" style="height:60px"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <div style="text-align:left;padding:5px;padding-left: 50px;">
                           <%-- <a  class="easyui-linkbutton" onclick="submitForm()">新增</a>
                            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
                           --%>
                            <input type="submit" value="确定" name="ok" class="easyui-linkbutton" style="padding:6px;"/>                                        <input type="button" value="重置" name="clear" class="easyui-linkbutton" style="padding:6px;"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>

    </div>
</div>
<script>

    function submitForm(){
        $('#ff').form('submit');
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>