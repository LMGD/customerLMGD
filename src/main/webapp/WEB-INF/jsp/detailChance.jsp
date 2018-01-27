<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>

<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="详细营销机会" style="width:100%;height: 100%">
    <div style="padding:10px 60px 20px 60px">
            <table cellpadding="5">
                <tr>
                    <td>机会来源:</td>
                    <td>
                        <input type="text" name="chcSource"  value="${ch.chcSource}"></input>
                    </td>
                </tr>
                <tr>
                    <td>客户名称:</td>
                    <td>
                        <input type="text" name="chcCustName" value="${ch.chcCustName}"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>概要:</td>
                    <td>
                        <input type="text" name="chcTitle" value="${ch.chcTitle}"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>成功机率:</td>
                    <td>
                        <input type="text" name="chcRate" value="${ch.chcRate}"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>

                <tr>
                    <td>联系人:</td>
                    <td>
                        <input  type="text" name="chcLinkman" value="${ch.chcLinkman}" ></input>
                    </td>
                </tr>
                <tr>
                    <td>联系人电话:</td>
                    <td>
                        <input type="text" name="chcTel" value="${ch.chcTel}"></input>
                    </td>
                </tr>
                <tr>
                    <td>机会描述:</td>
                    <td>
                        <input  value="${ch.chcDesc}" name="chcDesc" data-options="multiline:true" style="height:60px"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>创建人名字:</td>
                    <td>
                        <input type="text" name="chcCreateBy" value="${ch.chcCreateBy}" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>创建日期时间:</td>
                    <td>
                        <input type="text" name="chcCreateDate" value="${ch.chcCreateDate}" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>状态:</td>
                    <td>
                        <c:if test="${ch.chcStatus==1}">
                            <input  type="text" name="chcStatus" value="未指派" ></input>
                        </c:if>
                        <c:if test="${ch.chcStatus==2}">
                            <input  type="text" name="chcStatus" value="已指派" ></input>
                        </c:if>
                        <c:if test="${ch.chcStatus==3}">
                            <input  type="text" name="chcStatus" value="开发成功" ></input>
                        </c:if>
                        <c:if test="${ch.chcStatus==4}">
                            <input  type="text" name="chcStatus" value="开发失败" ></input>
                        </c:if>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <c:if test="${ch.chcStatus!=1}">
                    <tr>
                        <td>指派给:</td>
                        <td>
                            <input value="${ch.chcDueTo}" type="text" name="chcDueTo"  ></input>
                        </td>
                    </tr>
                    <tr>
                        <td>指派日期时间:</td>
                        <td>
                            <input value="${ch.chcDueDate}" type="text" name="chcDueDate" ></input>
                        </td>
                    </tr>
                </c:if>
            </table>
    </div>

</div>



<script>

</script>
</body>
</html>