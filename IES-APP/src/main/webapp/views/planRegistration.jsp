<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan Registration Form</title>
</head>
<body>
<div align="center">
	 <h2>Plan Registration</h2>
	 <br>
	 <a href="plans">View Plans</a><br><br>
	 <font color="green">${succMsg}</font> <font color="red">${failMsg}</font>
	 <br> <br>
	<form:form action="/savePlan" method="post" modelAttribute="planObj">
		<table>
			<tr>
				<td>Plan Name :</td>
				<td><form:input path="planName" /></td>
				<form:hidden path="planId" />
			</tr>

			<tr>
				<td>Plan Description :</td>
				<td><form:input path="planDescription" /></td>
			</tr>

			<tr>
				<td>Plan Start Date :</td>
				<td><form:input path="planStartDate" /> </td>
						
			</tr>
			
			<tr>
					<td>Plan End Date :</td>
					<td><form:input   path="planEndDate" /></td>
			</tr>
			
			
			
			<tr>
					<td><input type="reset" value="Reset"></td>
					<td><input type="submit" value="Register" ></td>
				</tr>
			
			


		</table>



	</form:form>
	
	
	</div>

</body>
</html>