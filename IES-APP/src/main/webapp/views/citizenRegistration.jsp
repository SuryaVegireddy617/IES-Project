<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizen Registration Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script type="text/javascript">
$(document).ready(function() {
	$("#ssn").blur(function() {
		$("#errorMsg").text("")
		$.ajax({
			type : "GET",
			url : "ssnCheck?ssn="+$("#ssn").val(),
			success : function(data) {
				if(data=="INVALID"){
					$("#errorMsg").text("Invalid SSN Please provide valid SSN");
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
	 <h2>Application Registration</h2>
	 <br>
	 <a href="citizens">View Citizens</a><br><br>
	 <font color="green">${succMsg}</font> <font color="red">${failMsg}</font>
	 <br> <br>
	<form:form action="/saveCitizen" method="post" modelAttribute="citizenObj">
		<table>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
				<form:hidden path="arNo" />
			</tr>

			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" /> </td>
						
			</tr>
			
			<tr>
					<td>Gender :</td>
					<td><form:radiobutton path="gender" value="M" />Male <form:radiobutton
							path="gender" value="FM" />Fe-Male</td>
			</tr>
			<tr>
				<td>SSN NO :</td>
				<td><form:input path="ssn" id="ssn" /> <font color="red"><span
						id="errorMsg"></span></font></td>

						
						
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" id="email" /> 
			</tr>
			
			
			
			<tr>
					<td><input type="reset" value="Reset"></td>
					<td><input type="submit" value="Register" id="submitBtn" ></td>
				</tr>
			
			


		</table>



	</form:form>
	
	
	</div>

</body>
</html>