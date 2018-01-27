<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
    <%@include file="/comm/skipPage.jsp"%>
</head>


<body>
<div style="margin:20px 0;"></div>
<table class="easyui-datagrid" title="服务反馈" style="width:100%;height:80%"
       data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
    <div id="tb" style="padding:5px;height:auto">
        <!-- 模糊查询,还没写。 -->
        <form action="doDealList" method="post">
            <div>
                服务类型:
                <select id="svrType"  name="svrType" panelHeight="auto" style="width:100px" >
                    <option value="">----请选择---</option>
                    <c:forEach  items="${serviceTypeList}" var="st" >
                        <option value="${st.text}"  <c:if test="${svrType==st.text}">selected="selected"</c:if> >
                                ${st.text}
                        </option>
                    </c:forEach>
                </select>
                <input type="submit" value="查询" name="ok" class="easyui-linkbutton"
                       style="padding:6px;"/>
            </div>
        </form>

    </div>

    <thead>
    <tr>
        <th data-options="field:'productid',width:20,align:'center'">ID </th>
        <th data-options="field:'listprice',width:60,align:'center'">服务类型</th>
        <th data-options="field:'attr1',width:250,align:'center'">概要</th>
        <th data-options="field:'attr2',width:250,align:'center'">客户名字</th>
        <th data-options="field:'attr3',width:100,align:'center'">服务状态</th>
        <th data-options="field:'attr4',width:100,align:'center'">创建人</th>
        <th data-options="field:'attr5',width:200,align:'center'">创建时间</th>
        <th data-options="field:'lmm',width:90,align:'center'">操作</th>
    </tr>
    </thead>

    <tbody>

      <c:forEach items="${serviceList}" var="s" varStatus="m">
          <tr>
              <td data-options="field:'productid',width:20,align:'center'">
                  ${s.svrId}
              </td>
              <td data-options="field:'listprice',width:60,align:'center'">
                  ${s.svrType}
              </td>
              <td data-options="field:'attr1',width:250,align:'center'">${s.svrTitle}</td>
              <td data-options="field:'attr2',width:250,align:'center'">${s.svrCustName}</td>
              <td data-options="field:'attr3',width:100,align:'center'">
                      <span style="color: #00ee00;">${s.svrStatus}</span>
              </td>
              <td data-options="field:'attr4',width:100,align:'center'">${s.svrCreateBy}</td>
              <td data-options="field:'attr5',width:200,align:'center''">${s.svrCreateDate}</td>
              <td data-options="field:'lmm',width:90,align:'center'">
                  <a href="toReturnSerJsp?svrId=${s.svrId}"
                     class="easyui-linkbutton" iconCls="icon-back" plain="true">
                      反馈
                  </a>
              </td>
          </tr>
      </c:forEach>
    </tbody>
</table>

<page:page pageBean="${pageBean}"></page:page>


<script type="text/javascript">
</script>
</body>
</html>
