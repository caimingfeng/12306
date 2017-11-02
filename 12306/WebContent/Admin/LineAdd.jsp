<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>新增线路信息</title>
<link href="../css/css.css" rel="stylesheet" type="text/css">
</head>

<body class="write_bg">
	<form action="../LineManagement?pageSize=10" method="post" onsubmit="return checkForm()">
		<input type="hidden" name="management" value="add" /><!-- 标识 -->
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
				<td width="771" height="30" valign="top" class="text_blod_title">新增线路信息</td>
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
							<td width="771" height="25" align="left" class="text_cray">注：标有<span
								class="text_red"> *</span> 处，均为必填项
							</td>
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
							<td width="20" align="center" class="text_red">*</td>
							<td width="100" height="40" align="left" class="text_cray1">车次代码：</td>
							<td class="text_cray"><input type="text" name="trainId"
								id="textfield2" /> 由字母或数字组成，长度不少于4位，不多于30位</td>
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
							<td width="20" align="center" class="text_red">*</td>
							<td width="100" height="40" align="left" class="text_cray1">车站名：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="stationId"
								id="textfield2" /> 数字</td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red">*</td>
							<td width="100" height="40" align="left" class="text_cray1">发车时间：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="startTime"
								id="textfield2" /> 统一时间格式：yyyy-MM-dd hh-mm</td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red">*</td>
							<td width="100" height="40" align="left" class="text_cray1">历时：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="takeTime"
								id="textfield2" /> 时间格式</td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red">*</td>
							<td width="100" height="40" align="left" class="text_cray1">车站序号：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="stationNo"
								id="textfield2" /> 数字</td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">里程：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="mileage"
								id="textfield2" /></td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">到站时间：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="endTime"
								id="textfield2" /> 时间格式</td>
						</tr>
						<tr>
							<td width="20" align="center" class="text_red"></td>
							<td width="100" height="40" align="left" class="text_cray1">停留时间：</td>
							<td width="14"></td>
							<td class="text_cray"><input type="text" name="stayTime"
								id="textfield2" /> 时间格式</td>
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

