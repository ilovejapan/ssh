<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript">
	
		alert("user.jsp");
		
		$(document).ready(function(){
		
			$.ajax({
				type : "post",
				url   :"ContinentsAJAX",
				dataType : "json",
				success  : function(data){
					
					var datas = $.parseJSON(data.string);
					
					var continents = document.getElementById("continents");
					
					//continents.style.width = "120px";
					
					for(var i=0;i<datas.length;i++){
						var option = document.createElement("<option>");
						
						option.value = datas[i].cid;
						option.innerHTML = datas[i].cname;
						
						continents.appendChild(option);						
					}
					
					//var continents = document.getElementById("continents");// Doesn't work
					
					continents.style.width = "120px";
					
					//States();
										
				},
				error : function(){
					alert("continents error , keep trying");
				}
			});
			
		});
		
		
		function ajaxStates(continents){
			var value = continents.value;
			
			$("#states").children().remove();// Exactly work
			//$("#areas").children().remove();
			
			$.ajax({
				type : "post",
				url  : "StatesAJAX",
				dataType : "json",
				data : {
					cid : value
				},
				success : function(data){
					$("#states").prepend("<option value='0'>==select==</option>");// necessary
					//$("#states").append("<option value='0'>Te_states</option>");// one of
					
					//$("#states").children().remove();// Removed so second work , still have its sense , not here
					
					$("#areas").children().remove();
					$("#areas").prepend("<option value='0'>==select==</option>");// necessary when operating first
					//$("#areas").append("<option value='0'>Text</option>");
					
					var datas = $.parseJSON(data.string);
					
					var states = document.getElementById("states");
					
					for(var i=0;i<datas.length;i++){
						var option = document.createElement("<option>");
						
						option.value = datas[i].sid;
						option.innerHTML = datas[i].sname;
						
						states.appendChild(option);
					}
					
					states.style.width = "120px";
					
				},
				error : function(){
					alert("states error , keep trying");
				}
			});
		}
		
		
		function ajaxAreas(states){	
			var value = states.value;
			
			//$("#areas").children().remove();
			
			$.ajax({
				type : "post",
				url  : "AreasAJAX",
				dataType : "json",
				data : {
					sid : value
				},
				success : function(data){
					$("#areas").children().remove();// Exactly
					//$("#areas").prepend("<option value='0'>==sel_areas==</option>");// same
					$("#areas").append("<option value='0'>==select==</option>");// same
					
					//$("#states").children().remove();// It's weird
					//$("#states").prepend("<option value='0'>==sel_areas==</option>");// It's weird
					
					var datas = $.parseJSON(data.string);
					
					var areas = document.getElementById("areas");
					
					for(var i=0;i<datas.length;i++){
						var option = document.createElement("<option>");
						
						option.value = datas[i].aid;
						option.innerHTML = datas[i].aname;
						
						areas.appendChild(option);
					}
					
					areas.style.width = "120px";
				},
				error : function(){
					alert("areas error , keep trying");
				}
			});
		}
		
	</script>

  </head>
  
  <body>
    This is User JSP page. <br>
    <%System.out.println("Connected with user.jsp"); %>
    ${message }
    <br/>
    <select id="continents" onchange="ajaxStates(this)"></select>
    <label>&nbsp</label>
    <select id="states" onchange="ajaxAreas(this)"><option>==select==</option></select>
    <label>&nbsp</label>
    <select id="areas"><option>==select==</option></select>
  </body>
</html>
