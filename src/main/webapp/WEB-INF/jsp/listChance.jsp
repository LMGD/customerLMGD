<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>


<body>
<div style="margin:20px 0;"></div>
<span style="color: red;size: 16px;">${message}</span>
<table class="easyui-datagrid" title="营销机会" style="width:100%;height:100%"
       data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
    <div id="tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="comm/addChance" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
        </div>
        <!-- 模糊查询 -->
        <form action="listChance" method="post">
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
        <th data-options="field:'productid',width:200,align:'center'">客户名称 </th>
        <th data-options="field:'listprice',width:80,align:'center'">成功机率</th>
        <th data-options="field:'unitcost',width:250,align:'center'">概要</th>
        <th data-options="field:'attr2',width:100,align:'center'">创建人名字</th>
        <th data-options="field:'attr1',width:100,align:'center'">创建日期时间</th>
        <th data-options="field:'status',width:100,align:'center'">状态</th>
        <th data-options="field:'sb',width:120,align:'center'">指派给</th>
        <th data-options="field:'lmm',width:120,align:'center'">操作</th>
    </tr>
    </thead>

    <tbody>

      <c:forEach items="${chanceList}" var="c" varStatus="m">
          <tr>
              <%--<td data-options="field:'itemid',width:20">${c.chcId}</td>--%>
              <td data-options="field:'productid',width:200,align:'center'">
                      <a href="load/detailChance?chcId=${c.chcId}&chcStatus=${c.chcStatus}"
                           class="easyui-linkbutton" data-options="plain:true">
                              ${c.chcCustName}
                      </a>
                 <%-- <div class="easyui-panel" style="padding:5px;">--%>
              </td>
              <td data-options="field:'listprice',width:80,align:'center'">${c.chcRate}%</td>
              <td data-options="field:'unitcost',width:250,align:'center'">${c.chcTitle}</td>
              <td data-options="field:'attr2',width:100,align:'center'">${c.chcCreateBy}</td>
              <td data-options="field:'attr1',width:100,align:'center'">${c.chcCreateDate}</td>
              <td data-options="field:'status',width:100,align:'center'">
                  <c:if test="${c.chcStatus == 1}">未指派</c:if>
                  <c:if test="${c.chcStatus == 2}">已指派</c:if>
                  <c:if test="${c.chcStatus == 3}">开发成功</c:if>
                  <c:if test="${c.chcStatus == 4}">开发失败</c:if>
              </td>
               <td>
                      <div>
                          <select id="chcDueId_${m.count}" name="chcDueId" style="width: 100px">
                              <option value="0">-----请选择----</option>
                              <option value="3" <c:if test="${ch.chcDueId==3}">selected="selected"</c:if>>
                                  小客
                              </option>
                              <option value="5" <c:if test="${ch.chcDueId==5}">selected="selected"</c:if>>
                                  小小客
                              </option>
                              <option value="6" <c:if test="${ch.chcDueId==6}">selected="selected"</c:if>>
                                  邓林妹
                              </option>
                          </select>
                      </div>
                </td>
              <td data-options="field:'lmm',width:120,align:'center'">
                  <a href="load/editChance?chcId=${c.chcId}&chcStatus=${c.chcStatus}"
                     class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>

                  <a onclick="doPoint(${c.chcId},'chcDueId_${m.count}')"
                     class="easyui-linkbutton" iconCls="icon-save" plain="true">指派</a>

                  <!--删除 -->
                  <c:if test="${c.chcStatus == 1}">
                      <a href="delChance?chcId=${c.chcId}" class="easyui-linkbutton" iconCls="
                      icon-remove" plain="true">删除</a>
                  </c:if>
                  <c:if test="${c.chcStatus != 1}">
                      <a href="javascript:alert('已指派不可删除!!')" class="easyui-linkbutton" iconCls="
                      icon-remove" plain="true">删除</a>
                  </c:if>
              </td>
          </tr>
      </c:forEach>

    </tbody>
</table>


<script type="text/javascript">
    function doPoint(chcId,chcDueId_m){
      //chc_id、chc_due_id、chc_due_to
       var chcDueObj= document.getElementById(chcDueId_m);
       var chcDueId=chcDueObj.value;
       if(chcDueId==0){
           alert("请先选择要分配的对象");
           return;
       }
       var chcDueTo=chcDueObj.options[chcDueObj.options.selectedIndex].text;
      // alert('sb:'+chcId+",,,:"+chcDueId+",,,chcDueTo："+chcDueTo);
        location.href="doPoint?chcId="+chcId+"&chcDueId="+chcDueId+"&chcDueTo="+chcDueTo;
    }
</script>
</body>
</html>
