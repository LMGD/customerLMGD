<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>


<script>
</script>

<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="新增服务" style="width:80%;height: 60%">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="doAddService" method="post">
            <table cellpadding="5">
                <tr>
                    <td>服务类型:</td>
                    <td>
                        <select id="svrType"  name="svrType" panelHeight="auto" style="width:175px" class="easyui-combobox">
                            <option value="">----------请选择----------</option>
                            <c:forEach  items="${serviceTypeList}" var="st" >
                                <option value="${st.text}">${st.text}</option>
                            </c:forEach>
                        </select>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>概要:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="svrTitle" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>客户编号:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="svrCustNo" ></input>
                    </td>
                </tr>
                <tr>
                    <td>客户名字:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="svrCustName" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>服务请求:</td>
                    <td>
                        <input class="easyui-textbox" name="svrRequest"></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>
                <tr>
                    <td>创建人名字:</td>
                    <td>
                        <input class="easyui-textbox" name="svrCreateBy"  value="${svrCreateBy}"  ></input>
                        <span style="color: red">*</span>
                        <input class="easyui-textbox" type="hidden" name="svrCreateId" value="${svrCreateId}" ></input>
                        <!-- 创建人ID -->
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

    </div>
</div>

<script>
</script>
</body>
</html>