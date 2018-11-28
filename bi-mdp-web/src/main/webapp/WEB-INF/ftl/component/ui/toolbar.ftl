<#-- 
id:
title:
iconCls:
action:
type: 1-新增 2-修改 3-删除 4-审单 5-导出       0代表不验证权限的按钮

验证： checkPower("${thisPowerV?number}",4)==true
-->
<#macro toolbar  id listData  >

<#assign thisPowerV="${thisPower!0}" >

<script type="text/javascript">
      
</script>

 <div id="${id!''}" style="margin-bottom:0px;background:#F4F4F4;height:26px;padding:5px;">
	  <#list listData as item>
	      <#assign flag=1>
	      <#if (item.type)?? >
	          <#if (item.type==1) || (item.type==2) ||(item.type==3)||(item.type==4)||(item.type==5) >
	                <#if  checkPower("${thisPower}",item.type)==false>
	                     <#assign flag=0>
	                     
	                </#if>
	          </#if>
	           <#if flag==1>
	                 <a href="javascript:void(0)" id="${item.id}" class="easyui-linkbutton" iconCls="${item.iconCls}" plain="true" onclick="${item.action}" >${item.title}</a>
	              <#else>
	                
	                <a href="javascript:void(0)" id="${item.id}" class="easyui-linkbutton" iconCls="${item.iconCls}-dis" plain="true" disabled="true">${item.title}</a>
	           </#if>
	            
	      </#if> 
	  </#list>
	  
 </div>
</#macro>
