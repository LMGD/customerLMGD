<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="/comm/head.jsp"%>
</head>

<body>
<div style="margin:20px 0;"></div>
    <table class="easyui-datagrid" title="处理服务" style="width:85%;height:50%"
           data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
        <div id="tb" style="padding:5px;height:auto">
         <thead>
          <tr>
             <th data-options="field:'attr4',width:200,align:'center'"></th>
             <th data-options="field:'attr2',width:300,align:'center'"></th>
             <th data-options="field:'attr3',width:200,align:'center'"></th>
             <th data-options="field:'a1',width:200,align:'center'"></th>
          </tr>
         <thead>
          <tbody>
           <tr>
              <td data-options="field:'attr4',width:100,align:'center'">
                  <span style="font-size: 16px;color: #0000FF;"> 编号：</span>
              </td>
              <td data-options="field:'attr2',width:100,align:'center'">${s.svrId}</td>
              <td data-options="field:'attr3',width:100,align:'center'">
                  <span style="font-size: 16px;color: #0000FF;"> 服务类型：</span>
              </td>
              <td data-options="field:'a1',width:100,align:'center'">${s.svrType}</td>
           </tr>
            <tr >
                <td data-options="field:'a2',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;">  概要：</span>

                </td>
                <td data-options="field:'a3',width:300,align:'center'" colspan="3">${s.svrTitle}</td>
            </tr>
            <tr>
                <td data-options="field:'a6',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;">客户名字：</span>
                </td>
                <td data-options="field:'a7',width:100,align:'center'">${s.svrCustName}</td>
                <td data-options="field:'a8',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;">服务状态：</span>
                </td>
                <td data-options="field:'a9',width:100,align:'center'">${s.svrStatus}</td>
            </tr>
            <tr>
                <td data-options="field:'a10',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;">服务请求：</span>
                </td>
                <td data-options="field:'a11',width:300,align:'center'" colspan="3">${s.svrRequest}</td>
            </tr>
            <tr>
                <td data-options="field:'a14',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;"> 创建人：</span>
                </td>
                <td data-options="field:'a15',width:100,align:'center'">${s.svrCreateBy}</td>
                <td data-options="field:'a16',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;"> 创建时间：</span>
                </td>
                <td data-options="field:'a17',width:100,align:'center'">${s.svrCreateDate}</td>
            </tr>
            <tr>
                <td data-options="field:'a18',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;">  处理人：</span>
                </td>
                <td data-options="field:'a19',width:100,align:'center'">${s.svrDealBy}</td>
                <td data-options="field:'a20',width:100,align:'center'">
                    <span style="font-size: 16px;color: #0000FF;"> 分配时间：</span>
                </td>
                <td data-options="field:'a21',width:100,align:'center'">${s.svrDueDate}</td>
            </tr>
        </div>
       <tbody>
    </table>
    <!--服务详细  end -->



    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="doDealService" method="post">
            <table cellpadding="5">
                <tr>
                    <td>服务处理 :</td>
                    <td>
                        <input class="easyui-textbox" type="text"  name="svrDeal"
                               data-options="multiline:true" style="height:60px" ></input>
                        <span style="color: red">*</span>

                        <input class="easyui-textbox" type="hidden" name="svrId" value="${s.svrId}" ></input>
                    </td>
                </tr>
                <tr>
                    <td>处理人:</td>
                    <td>
                        <input class="easyui-textbox" type="text" name="svrDealBy" value="${s.svrDealBy}" ></input>
                        <span style="color: red">*</span>
                    </td>
                </tr>

                <tr>
                    <td>
                        处理时间:
                    </td>
                    <td>
                        <span id="nowTime" type="text" name="svrDealDate" ></span>
                        <span style="color: red">*</span>
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


<!--jquery-->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script>
    function clearForm(){
        $('#ff').form('clear');
    }

    $(function(){
        setInterval(
            "document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
    });



</script>
</body>
</html>