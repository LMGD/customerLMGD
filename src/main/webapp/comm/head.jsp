<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="f"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>--%>

<!--通用的分页 -->
<%@ taglib prefix="page" uri="/veryedu" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5.2/themes/icon.css">
<script type="text/javascript" src="js/jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<!-- 把英文转成中文 -->
<script type="text/javascript" src="js/jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>

<!--
  不能把 jquery-1.7.1.min.js，放公共的这里，不然菜单都没有啦，
   可能和上面的重复啦、有冲突。
-->
<%--<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>--%>







