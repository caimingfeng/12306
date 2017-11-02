<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>修改线路信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>

<body class="write_bg">
	<form action="../LineManagement" method="post">
		<input type="hidden" name="management" value="update">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td height="30"></td>
			</tr>
		</table>
		<table width="835" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="20" colspan="2"></td>
			</tr>
			<tr>
				<td width="64" height="30"></td>
				<td width="771" height="30" valign="top" class="text_blod_title">修改线路信息</td>
			</tr>
			<tr>
				<td height="15" colspan="2"><img src="../images/line1.jpg"
					width="835" height="6"></td>
			</tr>
			<tr>
				<td colspan="2"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="64"></td>
						</tr>
						<tr>
							<td></td>
							<td height="15"></td>
						</tr>
					</table>
					<table width="700" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="15" colspan="3" align="left" class="text_title">线路信息</td>
						</tr>
						<tr>
							<td height="10" colspan="3"></td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">线路编号：</td>
							<td class="text_cray" ><input style="background-color: #BEBEBE;" type="text" name="circuitId"
								id="textfield2" readonly="readonly" value="${line.circuitId }" /></td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">车次代码：</td>
							<td class="text_cray"><input type="text" name="trainId"
								id="textfield2" value="${line.trainId }" />
								由字母或数字组成，长度不少于4位，不多于30位</td>
						</tr>
					</table>

					<table width="700" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="20" colspan="6"></td>
						</tr>
						<tr>
							<td height="15" colspan="6" align="left" class="text_title">详细信息</td>
						</tr>
						<tr>
							<td height="10" colspan="6"></td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">车站名：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="stationId"
								type="text" class="text_cray" id="textfield2"
								value="${line.stationId }" /></td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">发车时间：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="startTime"
								type="text" class="text_cray" id="textfield2"
								value="<fmt:formatDate value='${line.startTime }' pattern='yyyy-MM-dd HH:mm'/>" /></td>
						</tr>
						<tr>
							<td align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">历时：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="takeTime"
								type="text" class="text_cray" id="textfield2"
								value="<fmt:formatDate value='${line.takeTime }' pattern='yyyy-MM-dd HH:mm'/>" /></td>
						</tr>
						<tr>
							<td align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">车站序号：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="stationNo"
								type="text" class="text_cray" id="textfield2"
								value="${line.stationNo }" /></td>
						</tr>
						<tr>
							<td align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">里程：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="mileage"
								type="text" class="text_cray" id="textfield2"
								value="${line.mileage }" /></td>
						</tr>
						<tr>
							<td align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">到站时间：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="endTime"
								type="text" class="text_cray" id="textfield2"
								value="<fmt:formatDate value='${line.endTime }' pattern='yyyy-MM-dd HH:mm'/>" /></td>
						</tr>
						<tr>
							<td align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">停留时间：</td>
							<td width="14"></td>
							<td colspan="3" align="left"><input name="stayTime"
								type="text" class="text_cray" id="textfield2"
								value="<fmt:formatDate value='${line.stayTime }' pattern='yyyy-MM-dd HH:mm'/>" /></td>
						</tr>
					</table>
		</table>
		<br>
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td></td>
			</tr>
		</table>
		<table width="700" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="164"></td>
				<td width="80" height="30" align="center"><input name="button"
					type="submit" class="buttj" id="button" value=""></td>
				<td width="98"></td>
				<td width="80" align="center"><input name="button2"
					type="reset" class="butcz" id="button2" value=""></td>
				<td width="92"></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0">
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
	<script type="text/JavaScript" src="../js/common.js"></script>
</body>
</html>