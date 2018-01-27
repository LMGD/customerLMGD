<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>


<body>
<div style="margin:20px 0;"></div>
<span style="color: red;size: 16px;">${message}</span>
<table class="easyui-datagrid" title="服务分配" style="width:100%;height:80%"
       data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
    <div id="tb" style="padding:5px;height:auto">
        <!-- 模糊查询,还没写。 -->
        <form action="doListService" method="post">
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
        <th data-options="field:'attr5',width:100,align:'center'">创建时间</th>
        <th data-options="field:'attr6',width:110,align:'center'">分配给</th>
        <th data-options="field:'lmm',width:80,align:'center'">操作</th>
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
                  <c:if test="${s.svrStatus=='已分配'}">
                      <span style="color: #00ee00;">${s.svrStatus}</span>
                  </c:if>
                  <c:if test="${s.svrStatus!='已分配'}">
                      ${s.svrStatus}
                  </c:if>
              </td>
              <td data-options="field:'attr4',width:100,align:'center'">${s.svrCreateBy}</td>
              <td data-options="field:'attr5',width:100,align:'center''">${s.svrCreateDate}</td>
              <td data-options="field:'attr6',width:110,align:'center''"  >
                        <div>
                                <select id="svrDealId_${m.index}"  >
                                    <option value="0">---请选择---</option>
                                    <option  value="3" <c:if test="${s.svrDealId==3}">selected="selected"</c:if> >小客</option>
                                    <option value="5" <c:if test="${s.svrDealId==5}">selected="selected"</c:if> >小小客</option>
                                    <option value="6" <c:if test="${s.svrDealId==6}">selected="selected"</c:if> >邓林妹</option>
                                </select>
                        </div>
              </td>
              <td data-options="field:'lmm',width:80,align:'center'">
                  <a onclick="doShare(${s.svrId},'svrDealId_${m.index}')"
                     class="easyui-linkbutton" iconCls="icon-save" plain="true">
                      分配
                  </a>
              </td>
          </tr>
      </c:forEach>
    </tbody>
</table>

    <page:page pageBean="${pageBean}"></page:page>



<script type="text/javascript">
    //分配
    function doShare(svrId,selectId){
        var selectObj=document.getElementById(selectId);
        var svrDealId=selectObj.value;//选中的值
        if(svrDealId==0){
           alert("请选择要分配的对象");
           return;
        }
        var svrDealBy=selectObj.options[selectObj.options.selectedIndex].text;//选中的文本
        //alert("服务id:"+svrId+",处理人id:"+svrDealId+",svrDealBy:"+svrDealBy);
        //svr_deal_id、svr_deal_by、svr_id
        location.href="doShare?svrId="+svrId+"&svrDealId="+svrDealId+"&svrDealBy="+svrDealBy;
    }

    //给来跳页码的
    function skipPage(){
        var curPage= document.getElementById('skipPage').value;
        location.href='doPage?curPage='+curPage;
    }
</script>
</body>
</html>
