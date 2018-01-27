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


    <!-- 营销计划 start -->
    <br/> <br/>
    <span id="nowTime" ></span>
    <table  class="easyui-datagrid" title="营销计划" style="width:90%;height:80%"
           data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
        <!--新增营销计划 -->
        <a href="toAddPlanJsp?plaChcId=${ch.chcId}" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增营销计划</a>

        <div>
          状态:
          <select id="chcStatus"  panelHeight="auto" style="width:150px" class="easyui-combobox">
             <option value="">---请选择---</option>
             <option value="2" <c:if test="${ch.chcStatus==2}">selected="selected"</c:if>>已指派(或开发中)</option>
             <option value="3" <c:if test="${ch.chcStatus==3}">selected="selected"</c:if>>开发成功</option>
             <option value="4" <c:if test="${ch.chcStatus==4}">selected="selected"</c:if>>开发失败</option>
          </select>
            &nbsp;&nbsp;&nbsp;
            <a onclick="getChcStatus('${ch.chcId}','${ch.chcCustName}')" class="easyui-linkbutton"
               iconCls="icon-save" plain="true">保存</a>
        </div>
        <div id="tb" style="height:auto" >
            <thead>
            <tr>
               <%-- <th data-options="field:'itemid',width:30">Id</th>--%>
                <th data-options="field:'attr4',width:250,align:'center'">计划执行日期</th>
                <th data-options="field:'attr2',width:300,align:'center'">计划内容</th>
                <th data-options="field:'attr3',width:200,align:'center'">计划执行结果</th>
                <th data-options="field:'lmm',width:150,align:'center'">操作</th>
            </tr>
            </thead>

            <c:forEach items="${planList}" var="p" varStatus="m" >
                <tr>
                   <%-- <td data-options="field:'itemid',width:30">${p.plaId}</td>--%>
                    <td data-options="field:'attr4',width:250,align:'center'">${p.plaDate} </td>
                    <td data-options="field:'attr1',width:300,align:'center'">
                            ${p.plaTodo}
                    </td>
                    <td data-options="field:'attr3',width:200,align:'center'">
                        <input id="plaResult_${m.index}" type="text" name="plaResults" value="${p.plaResult}"
                                style="width:190px;height: 50px" ></input>
                    </td>
                    <td data-options="field:'lmm',width:150,align:'center'">
                        <div style="text-align:center;padding:5px;">
                            <a onclick="doEdit(${p.plaId},'plaResult_${m.index}',${ch.chcId})" class="easyui-linkbutton"
                               iconCls="icon-save" plain="true">保存</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
           <%-- <div id="planId"></div>--%>
        </div>
    </table>
    <!--营销计划 end -->
</div>


<!--jquery-->
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script>
    //修改
    function doEdit(plaId,plaResultId,chcId){
        var obj=document.getElementById(plaResultId);
        var plaResult=obj.value;
        //alert(plaId+"--sbsb:"+plaResultId+"mmm:"+plaResult+"..:"+chcId);
        location.href="doEditPlan?plaId="+plaId+"&plaResult="+plaResult+"&chcId="+chcId;
    }

    //获得状态、和库户名字
    function getChcStatus(chcId,chcCustName){
       var chcStatus= document.getElementById("chcStatus").value;
       //alert("sbsb:chcStatus"+chcStatus+"chcId,,,:"+chcId);
       location.href="doEditStatus?chcStatus="+chcStatus+"&chcId="+chcId+"&chcCustName="+chcCustName;
    }

    $(function(){
       // alert("sbsbs:"+new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay()),1000);
        //系统时间显示
        setInterval(
            "document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
    });
</script>
</body>
</html>