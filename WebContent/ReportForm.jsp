<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="javax.servlet.*"
	import="javax.sql.*" import="java.util.*" import="jbean.Main_db"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:useBean id="GH" scope="application" class="jbean.Main_db" />
<jsp:setProperty property="*" name="GH" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>
<link rel="stylesheet" href="css/ReportForm.css">
<script type="text/javascript" src="Script/Script.js"></script>
</head>
<body>
	<form method="post" action="#" id="printJS-form" class="">
		<div id="print">
			<div id="ViewBody">
				<table class="curve header_tbl">
					<tr>
						<th class="curve-top" colspan="5" id="repoTitle">کارنامه دانش
							آموز</th>
						<th colspan="2"><img id="Ghadir_Logo_small" alt="GhadirLogo"
							src="img/Ghadir LOGO.jpg"></th>
					</tr>
					<tr>
						<td colspan="3">کد دانش آموز</td>
						<td></td>
						<td></td>
						<td><input id="fix" type="text" name="userid"
							value="${userid}" readonly /></td>
						<td colspan="2">سال تحصیلی</td>
						<td style="text-align: right;"><input type="text"
							class="fix2" id=fordate value="${ForDate}" readonly /></td>
						<td></td>
					</tr>
					<tr>
						<td id="fixlbl" colspan="3">نام و نام خانوادگی</td>
						<td></td>
						<td></td>
						<td><input id="fix" type="text" name="name"
							value="${stdNameFamily}" readonly /></td>
						<td>کلاس</td>
						<td style="text-align: left;"><input type="text" class="fix2"
							id=forclass value="${ForClass}" readonly /></td>
						<td></td>
					</tr>

				</table>
				<div id="between_tbl"></div>
				<table class="curve body_tbl">
					<tr>
						<th>نام درس</th>
						<th>نمره کل</th>
						<th>انضباط</th>
						<th>ملاحظات</th>
					</tr>
					<tr>
						<td>
							<table class="body_tbl2">
								<tr>
									<th rowspan="3" class="vertical"
										style="width: 5%; padding: 0%;">فارسی</th>
									<td class="lr Center">املاء</td>
									<td class="Center" style="width: 20%; padding: 3%;">${Dictation}</td>
								</tr>
								<tr>
									<td class="lr ub Center">انشاء و دستور</td>
									<td class="ub Center">${Grammar}</td>
								</tr>
								<tr>
									<td class="lr Center">روخوانی</td>
									<td class="Center" style="width: 20%; padding: 3%;">${Reading}</td>
								</tr>
							</table>
						</td>
						<td class="Center">${Farsi}</td>
						<td class="Center">${FarsiDis}</td>
						<td class="Center Comments">${FarsiDetails}</td>
					</tr>
					<tr>
						<th style="border-bottom: 1px solid #5500aa; padding: 3%;">دینی</th>
						<td class="Center">${Religion}</td>
						<td class="Center">${ReligionDis}</td>
						<td class="Center Comments">${ReligionDetails}</td>
					</tr>
					<tr>
						<th style="padding: 3%;">قرآن</th>
						<td class="Center">${Quran}</td>
						<td class="Center">${QuranDis}</td>
						<td class="Center Comments">${QuranDetails}</td>
					</tr>
					<tr>
						<th style="border-top: 1px solid #5500aa; padding: 3%;">نماز</th>
						<td class="Center">${Salat}</td>
						<td class="Center">${SalatDis}</td>
						<td class="Center Comments">${SalatDetails}</td>
					</tr>
					<tr>
						<th style="border-top: 1px solid #5500aa; padding: 3%;">انضباط
							کل</th>
						<td class="Center" colspan="2">${TotalDis}</td>
						<td>${Result_Note}</td>
					</tr>
				</table>

			</div>
			<!-- ===================================================================================
======================================================================================== -->
			<div id="ViewBody">
				<table class="curve header_tbl">
					<tr>
						<th class="curve-top" colspan="5" id="repoTitle">کارنامه دانش
							آموز</th>
						<th colspan="2"><img id="Ghadir_Logo_small" alt="GhadirLogo"
							src="img/Ghadir LOGO.jpg"></th>
					</tr>
					<tr>
						<td colspan="3">کد دانش آموز</td>
						<td></td>
						<td></td>
						<td><input id="fix" type="text" name="userid2"
							value="${userid2}" readonly /></td>
						<td colspan="2">سال تحصیلی</td>
						<td style="text-align: right;"><input type="text"
							class="fix2" id=fordate value="${ForDate}" readonly /></td>
						<td></td>
					</tr>
					<tr>
						<td id="fixlbl" colspan="3">نام و نام خانوادگی</td>
						<td></td>
						<td></td>
						<td><input id="fix" type="text" name="name"
							value="${stdNameFamily2}" readonly /></td>
						<td>کلاس</td>
						<td style="text-align: left;"><input type="text" class="fix2"
							id=forclass2 value="${ForClass2}" readonly /></td>
						<td></td>
					</tr>

				</table>
				<div id="between_tbl"></div>
				<table class="curve body_tbl">
					<tr>
						<th>نام درس</th>
						<th>نمره کل</th>
						<th>انضباط</th>
						<th>ملاحظات</th>
					</tr>
					<tr>
						<td>
							<table class="body_tbl2">
								<tr>
									<th rowspan="3" class="vertical"
										style="width: 5%; padding: 0%;">فارسی</th>
									<td class="lr">املاء</td>
									<td class="Center" style="width: 20%; padding: 3%;">${Dictation2}</td>
								</tr>
								<tr>
									<td class="lr ub">انشاء و دستور</td>
									<td class="ub Center" style="width: 20%; padding: 3%;">${Grammar2}</td>
								</tr>
								<tr>
									<td class="lr">روخوانی</td>
									<td class="Center" style="width: 20%; padding: 3%;">${Reading2}</td>
								</tr>
							</table>
						</td>
						<td class="Center">${Farsi2}</td>
						<td class="Center">${FarsiDis2}</td>
						<td class="Center">${FarsiDetails2}</td>
					</tr>
					<tr>
						<th style="border-bottom: 1px solid #5500aa; padding: 3%;">دینی</th>
						<td class="Center">${Religion2}</td>
						<td class="Center">${ReligionDis2}</td>
						<td class="Center">${ReligionDetails2}</td>
					</tr>
					<tr>
						<th style="padding: 3%;">قرآن</th>
						<td class="Center">${Quran2}</td>
						<td class="Center">${QuranDis2}</td>
						<td class="Center">${QuranDetails2}</td>
					</tr>
					<tr>
						<th style="border-top: 1px solid #5500aa; padding: 3%;">نماز</th>
						<td class="Center">${Salat2}</td>
						<td class="Center">${SalatDis2}</td>
						<td class="Center">${SalatDetails2}</td>
					</tr>
					<tr>
						<th style="border-top: 1px solid #5500aa; padding: 3%;">انضباط
							کل</th>
						<td class="Center" colspan="2">${TotalDis2}</td>
						<td>${Result_Note2}</td>
					</tr>
				</table>

			</div>
		</div>
		<div id="between_tbl"></div>
		<table class="curve footer_tbl">
			<tr>
				<th><button type="button" class="button" onclick="Print()">چاپ</button></th>
				<th><input type="reset" class="button" value="لغو" /></th>
			</tr>
		</table>
	</form>
</body>
</html>

<!-- 
onclick="printJS('printJS-form', 'html')"

			<textarea id="text_area" name="Details" ></textarea>
						
 -->