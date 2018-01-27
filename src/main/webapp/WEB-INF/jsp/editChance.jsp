<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>

<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="修改营销机会" style="width:100%;height: 100%">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="editChance" method="post">
            <table cellpadding="5">
                <tr>
                    <td>机会来源:</td>
                    <td>
                        <input class="easyui-textbox" type="hidden" name="chcId" value="${ch.chcId}" ></input>
                        <input class="easyui-textbox" type="text" name="chcSource" value="${ch.chcSource}" ></input>
                    </td>
                </tr>
                <tr>
                    <td>客户名称:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="chcCustName" value="${ch.chcCustName}"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>概要:</td>
                    <td>
                        <input class="easyui-textbox" type="text" value="${ch.chcTitle}" name="chcTitle"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>成功机率:</td>
                    <td>
                        <input class="easyui-textbox" type="text" value="${ch.chcRate}" name="chcRate"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>

                <tr>
                    <td>联系人:</td>
                    <td>
                        <input class="easyui-textbox" type="text" value="${ch.chcLinkman}" name="chcLinkman" ></input>
                    </td>
                </tr>
                <tr>
                    <td>联系人电话:</td>
                    <td>
                        <input class="easyui-textbox" type="text" value="${ch.chcTel}" name="chcTel"></input>
                    </td>
                </tr>
                <tr>
                    <td>机会描述:</td>
                    <td>
                        <input class="easyui-textbox" name="chcDesc" value="${ch.chcDesc}"
                               data-options="multiline:true" style="height:60px"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>创建人名字:</td>
                    <td>
                        <input name="chcCreateBy" type="text" value="${ch.chcCreateBy}"
                               class="easyui-textbox" readonly></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>创建日期时间:</td>
                    <td>
                        <input  type="text" value="${ch.chcCreateDate}" name="chcCreateDate"
                                class="easyui-textbox" readonly></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td>
                        <c:if test="${ch.chcStatus==1}">
                            未指派
                            <input  type="hidden" name="chcStatus" value="1" class="easyui-textbox" ></input>
                        </c:if>
                        <c:if test="${ch.chcStatus==2}">
                            已指派
                            <input  type="hidden" name="chcStatus" value="2" class="easyui-textbox"></input>
                        </c:if>
                        <c:if test="${ch.chcStatus==3}">
                            开发成功
                            <input  type="hidden" name="chcStatus" value="3"class="easyui-textbox" ></input>
                        </c:if>
                        <c:if test="${ch.chcStatus==4}">
                            开发失败
                            <input  type="hidden" name="chcStatus" value="4" class="easyui-textbox" ></input>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <div style="text-align:left;padding:5px;padding-left: 50px;">
                            <input type="submit" value="确定" name="ok" class="easyui-linkbutton" style="padding:6px;"/>                                        <input type="button" value="重置" name="clear" class="easyui-linkbutton" style="padding:6px;"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form>
      <%--  <div style="text-align:left;padding:5px;padding-left: 150px;">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
        </div>--%>
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