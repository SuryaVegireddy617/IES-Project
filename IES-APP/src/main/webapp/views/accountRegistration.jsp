<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script> 
<script>
$(function() {
  $("#datepicker").datepicker({
  changeMonth:true,
  changeYear:true,
  yearRange: '1900:+0'
  });
});

</script>

<script type="text/javascript">
$(document).ready(function() {
	$("#email").blur(function() {
		$("#errorMsg").text("")
		$.ajax({
			type : "GET",
			url : "uniqueMailCheck?email="+$("#email").val(),
			success : function(data) {
				if(data=="DUPLICATE"){
					$("#errorMsg").text("Duplicate Email");
					$("#submitBtn").prop("disabled", true);
				}else{
					$("#submitBtn").prop("disabled", false);
				}
			}
		});
	});

});

</script>

</head>
<body>
      
     
	<div align="center">
	 <h2>Account Registration</h2>
	 <a href="accounts?role=CASEWORKER" >View Accounts</a><br/><br/>
	 
	 <font color="green">${succMsg}</font> <font color="red">${failMsg}</font><br/><br/>
	<form:form action="/saveAccount" method="post" modelAttribute="accountObj">
		<table>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
				<form:hidden path="accountId" />
				
				
			</tr>

			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td>Email :</td>
				<td><form:input path="email" id="email" /> <font color="red"><span
						id="errorMsg"></span></font></td>
			</tr>
			
			<tr>
					<td>Password :</td>
					<td><form:password   path="pwd" /></td>
			</tr>
			
			<tr>
					<td>DOB:</td>
					<td><form:input   path="dob" id="datepicker"/></td>
					
			</tr>
			
			<tr>
					<td>Gender :</td>
					<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
							path="gender" value="FM" />Fe-Male</td>
			</tr>
			
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			
			<tr>
				<td>SSN NO :</td>
				<td><form:input path="ssn" /></td>
			</tr>
			
			<tr>
					<td>Role :</td>
					<td><form:select path="role" >
							<form:option value="">-select-</form:option>
							<form:option value="ADMIN">Admin</form:option>
							<form:option value="CASEWORKER">Caseworker</form:option>
							
						</form:select></td>
			</tr>
			
			<tr>
					<td><input type="reset" value="Reset"></td>
					<c:choose>
					   <c:when test="${accountObj.accountId==null}">
					      <td><input type="submit" value="Register Account" ></td>
					    </c:when>
					    <c:otherwise>
					    
					    <td><input type="submit" value="Update Account" ></td>
					    
					    </c:otherwise> 
					
					</c:choose>
					
				</tr>
			
			


		</table>



	</form:form>
	
	
	</div>
</body>
</html>