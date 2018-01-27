<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>


<body>
<div style="margin:20px 0;"></div>
<table class="easyui-datagrid" title="客户信息" style="width:100%;height:100%"
       data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
    <div id="tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
        </div>
        <!-- 模糊查询 -->
        <form action="" method="post">
            <div>
                状态:
                <select name="chcStatus" panelHeight="auto" style="width:100px">
                    <option value="">---请选择---</option>
                    <option value="1">未指派</option>
                    <option value="2">已指派(或开发中)</option>
                    <option value="3">开发成功</option>
                    <option value="4">开发失败</option>
                </select>

                处理人(指派给):<!--不知道为什么？加了 class="easyui-combobox",就赋值赋不上,add.jsp 也有这个状况 -->
                <select name="chcDueId" panelHeight="auto" style="width:100px">
                    <option value="">---请选择---</option>
                    <option value="3"> 小客 </option>
                    <option value="5">小小客 </option>
                    <option value="6" > 邓林妹</option>
                </select>

                <input type="submit" value="查询" name="ok" class="easyui-linkbutton"
                       style="padding:6px;"/>
                <%--<a href="#" class="easyui-linkbutton" iconCls="icon-search"></a>--%>
            </div>
        </form>

    </div>

    <thead>
    <tr>
        <%--<th data-options="field:'itemid',width:20">Id</th>--%>
        <th data-options="field:'productid',width:150,align:'center'">编号 </th>
        <th data-options="field:'listprice',width:250,align:'center'">客户名称</th>
        <th data-options="field:'attr2',width:100,align:'center'">地区</th>
        <th data-options="field:'attr1',width:60,align:'center'">经理ID</th>
        <th data-options="field:'status',width:150,align:'center'">客户经理名字</th>
        <th data-options="field:'lmm',width:150,align:'center'">操作</th>
    </tr>
    </thead>

    <tbody>

      <c:forEach items="${customerList}" var="c">
          <tr>
              <td data-options="field:'productid',width:150,align:'center'">
                      ${c.custNo}
              </td>
              <td data-options="field:'listprice',width:250,align:'center'">
                  <a href="#"
                     class="easyui-linkbutton" data-options="plain:true">
                          ${c.custName}
                  </a>
              </td>
              <td data-options="field:'unitcost',width:100,align:'center'">${c.custRegion}</td>
              <td data-options="field:'attr2',width:60,align:'center'">${c.custManagerId}</td>
              <td data-options="field:'attr1',width:150,align:'center'">${c.custManagerName}</td>

              <td data-options="field:'lmm',width:150,align:'center'">
                  <a href=""class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
                  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
              </td>
          </tr>
      </c:forEach>
    </tbody>
</table>

</body>
</html>
