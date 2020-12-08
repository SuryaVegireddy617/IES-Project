<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Citizens Form</title>
<script type="text/javascript">
function deactivateConfirm() {
	return confirm("Are You Sure, You Want to deactivate the citizen?");

}
function activateConfirm() {
	return confirm("Are You Sure, You Want to activate the citizen?");

}
</script>
</head>
<body>
<div align="center">
		<h2>VIEW CITIZENS</h2>
		
		<a href="/citizenReg">   + Add New Citizen</a><br/>
		<font color="green">${succMsg}</font> <font color="red">${errorMsg}</font>
		<br><br/>
		<table border="1">
			<tr>				
				<th>Application No</th>
				<th>Firs tName</th>
				<th>Last Name</th>
				<th>Date Of Birth</th>
				<th>SSN</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${citizens}" var="citizen">
				<tr>
					<td>${citizen.arNo}</td>
					<td>${citizen.firstName}</td>
					<td>${citizen.lastName}</td>
					<td>${citizen.dob}</td>
					<td>${citizen.ssn}</td>
					<c:choose>
					<c:when test="${citizen.citizenStatus =='ACTIVE'}">
					<td><a href="/editCitizen?arNo=${citizen.arNo}">Edit</a> &nbsp;&nbsp; <a
						href="/deactivateCitizen?arNo=${citizen.arNo}"
						onclick="return deactivateConfirm()">Deactivate</a></td></c:when>
						<c:otherwise>
						
						<td><a href="/editCitizen?arNo=${citizen.arNo}">Edit</a>&nbsp;&nbsp;<a
						href="/activateCitizen?arNo=${citizen.arNo}"
						onclick="return activeConfirm()">Active</a></td>
						
						</c:otherwise>
						</c:choose>
				</tr>

			</c:forEach>
		</table><br><br>
		<a href="home" >back to Home</a>

	</div>

</body>
</html>