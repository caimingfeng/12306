<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>线路管理</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
</script>
<script src="../js/jquery-1.11.1.js" type="text/javascript">
</script>
<script type="text/javascript">
function selectAllNullorReserve(obj,type){
   if(obj!=null&&obj!=""){
    if(document.getElementsByName(obj)!=undefined&&document.getElementsByName(obj).length>0){	//getElementsByName函数的作用按名字查找对象，返回一个数组。
     var userids = document.getElementsByName(obj);
     if(type=="全选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == false){
        userids[i].checked = true;
       }
      }
     }else if(type=="全不选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == true){
        userids[i].checked = false;
       }
      }
     }else if(type=="反选"){
      for(var i=0;i<userids.length;i++){
       if(userids[i].checked == true){
        userids[i].checked = false;
       }else{
        userids[i].checked = true;
       }
      }
     }
    }
   }
}

function grandChange(){
	var pageSize = $('#select2 option:selected').val(); // 选中值
	//alert(value);
	var url = "../LineManagement?management=query&flag=findByPage&pageSize="+pageSize;
	$.ajax({url:url,success:showResult});
}
function showResult(data){
		if (data.result == "true") {
			window.location.reload();
		}
	}
function submitDo(e) {
	var value = e.name;
	if (value == "Submit") {
		document.form1.action ="../LineManagement?management=query&flag=else";
		form1.submit();
	} else if (value == "Submit2") {
		document.form1.action ="../LineManagement?management=delete&pageSize="+$('#select2 option:selected').val();
		form1.submit();
	} else {
		//alert(value);
	}
}
</script>
</head>
<body class="write_bg">
	<form name="form1" method="post" action="" >

		<table width="1107" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30"></td>
			</tr>
		</table>
		<table width="850" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="20" colspan="2"></td>
			</tr>
			<tr>
				<td width="13" height="30" align="left" valign="top"></td>
				<td width="822" align="left" valign="top" class="text_blod_title">线路管理</td>
			</tr>
			<tr>
				<td height="15" colspan="2" align="center"><img
					src="../images/line.jpg" width="850" height="6"></td>
			</tr>
			<tr>
				<td height="15" colspan="2"></td>
			</tr>
		</table>
		<table width="" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="800" background="../images/wb_01 (3).jpg"><table
						width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5"></td>
							<td width="5%" height="25" align="center" class="text_cray1">车次</td>
							<td width="20%" align="left" class="text_cray1"><label>
									<input name="trainId" type="text" class="text_cray" value="${trainId }"
									style="width: 80px">
							</label></td>


							<td width="8%" align="center" class="text_cray1">车站名</td>
							<td width="20%" align="left" class="text_cray1"><label>
									<input name="stationId" type="text" class="text_cray" value="${sId }"
									style="width: 100px">
							</label></td>

							<td width="10%" valign="middle" class="text_craybold"><label>
									<!-- <input name="Submit" type="button" class="butcx" value="" /> -->
									<button name="Submit" class="butcx" value="" onclick="submitDo(this)"/></button>
									
							</label></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td height="20" colspan="11" align="center">&nbsp;</td>
						</tr>
					</table>
					<table width="800" border="1" align="center" cellpadding="0"
						cellspacing="1" bordercolor="#dadada" bgcolor="#FFFFFF">
						<tr align="center">
							<td width="44" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">选择</td>
							<td width="98" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">车次</td>
							<td width="80" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">车站名</td>
							<td width="100" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">发车时间</td>
							<td width="100" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">停留时间</td>
							<td width="100" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">到站时间</td>
							<td width="50" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">里程</td>
							<td width="50" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">车站序号</td>
							<td width="50" height="25" valign="middle" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1">操作</td>
						</tr>
						<tr align="center">
							<td height="15" colspan="9" bordercolor="#FFFFFF"
								bgcolor="#FFFFFF" class="text_cray1"><img
								src="../images/line1.jpg" width="700" height="6"></td>
						</tr>

						<c:forEach items="${listLine }" var="line">
							<tr align="center" bgcolor="#FFFFFF">
								<td bordercolor="#FFFFFF" class="text_cray1"><input
									type="checkbox" name="checkbox" value="${line.circuitId}"></td>
								<td width="98" bordercolor="#FFFFFF" class="text_cray1">${line.trainId }</td>
								<td width="80" bordercolor="#FFFFFF" class="text_cray1">${line.stationId }</td>
								<td width="132" bordercolor="#FFFFFF" class="text_cray1"><fmt:formatDate
										value='${line.startTime }' pattern='MM月dd号 HH:mm' /></td>
								<td width="132" bordercolor="#FFFFFF" class="text_cray1"><fmt:formatDate
										value='${line.stayTime }' pattern='MM月dd号 HH:mm' /></td>
								<td width="132" bordercolor="#FFFFFF" class="text_cray1"><fmt:formatDate
										value='${line.endTime }' pattern='MM月dd号 HH:mm' /></td>
								<td width="50" bordercolor="#FFFFFF" class="text_cray1">${line.mileage }
								</td>
								<td width="10" bordercolor="#FFFFFF" class="text_cray1">${line.stationNo }</td>
								<td width="10" bordercolor="#FFFFFF" class="text_cray1"><a
									href="../LineManagement?management=query&flag=update&circuitid=${line.circuitId }">编辑</a></td>
							</tr>
						</c:forEach>
						<!--  <tr align="center">
            <td bordercolor="#FFFFFF" bgcolor="#F5F5F5"   class="text_cray1"><input type="checkbox" name="checkbox" value="4"></td>
   			<td width="98" bordercolor="#FFFFFF"  class="text_cray1">D538</td>
            <td width="80" bordercolor="#FFFFFF"  class="text_cray1">2</td>
            <td width="132" bordercolor="#FFFFFF"  class="text_cray1">2017-10-10 8:10</td>
            <td width="132" bordercolor="#FFFFFF"  class="text_cray1">2017-10-10 15:10</td>
            <td width="132" bordercolor="#FFFFFF"  class="text_cray1">2017-10-10 15:10</td>
            <td width="50" bordercolor="#FFFFFF"  class="text_cray1">250km</td>
            <td width="10" bordercolor="#FFFFFF"  class="text_cray1">1</td>
            <td width="10" bordercolor="#FFFFFF"  class="text_cray1"><a href="LineUpdate.jsp">编辑</a></td>
          </tr>-->
					</table> <br>
					<table width="773" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center">
							<td width="102" align="left" class="text_cray1"><a href="#">
									<label></label> <label></label> <label> <input
										type="checkbox" name="checkbox2" value="11"
										onclick="selectAllNullorReserve('checkbox','反选');"><span
										class="text_blue">全选</span></label>
							</a></td>
							<td width="525" align="right" class="text_cray1"><a href="#">
									<!--<input type="button" name="Submit23" value="新增" onClick="UserAdd()"> -->
							</a></td>
							<td width="55" align="right" class="text_cray1"><a href="../LineManagement?management=delete">
									<!-- <input name="Submit2" type="button" class="butsc" value="" > -->
									<button name="Submit2" class="butsc" value="" onclick="submitDo(this)"/></button>
							</a></td>
							<td width="91" align="right" class="text_cray1"><label>
									<!-- <input name="Submit3" type="submit" class="butdc" value="" onclick="submitDo(this)"> -->
									<button name="Submit3" class="butdc" value="" onclick="submitDo(this)"/></button>
							</label></td>
						</tr>
					</table> <br>
					<table width="773" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr align="center" style="width: 60%">
							<td width="335" align="center" class="text_cray">&nbsp;</td>
							<td width="284" align="center" class="text_cray">>> 1 2 3 4
								5 6 7 8 &lt;&lt;</td>
							<td width="154" align="right" class="text_cray1"
								style="width: 20%"><label class="text_cray"> 每页显示 <select
									name="select2" onchange="grandChange()" id="select2">
										<option value="5">5</option>
										<option value="10">10</option>
										<option value="20">20</option>
								</select> 条信息 <script type="text/javascript">
                					var pageSize='<%=session.getAttribute("pageSize")%>';
									//alert(pageSize);
									if (pageSize == "null") {
										pageSize = 10;
									}
									$('#select2').val(pageSize);
								</script>
								<%
								session.removeAttribute("pageSize");
								System.out.println("后台传过来的车站名："+session.getAttribute("sId"));
								session.removeAttribute("sId");
								session.removeAttribute("trainId");
								%>
							</label></td>
						</tr>

					</table> <br></td>
			</tr>

			<tr>
				<td height="20"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td height="2" background="../images/bottom_point.gif"></td>
			</tr>
			<tr>
				<td height="25" align="center"
					background="../images/bottom_ny_bg.gif" class="text_cray">copyright@12306
					购票网</td>
			</tr>
		</table>
	</form>
</body>
</html>
