<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Plans Form</title>
<script type="text/javascript">
function deactivateConfirm() {
	return confirm("Are You Sure, You Want to deactivate the plan?");

}
function activateConfirm() {
	return confirm("Are You Sure, You Want to activate the plan?");

}
</script>
</head>
<body>
<div align="center">
		<h2>VIEW PLANS</h2><br>
		<font color="green">${succMsg}</font> <font color="red">${failMsg}</font><br>
		<a  href="planReg">Add Plan</a><br/><br/>
		
		<table border="1">
			<tr>
				<th>S.no</th>
				<th>PLan Name</th>
				<th>Plan Description</th>
				<th>Plan Star tDate</th>
				<th>Plan End Date</th>
				<th>Action</th>
			
			</tr>
			<c:forEach items="${plans}" var="plan">
			 
				<c:choose>
					<c:when test="${plan.planStatus == 'ACTIVE'}">
					<tr>
					<td>${plan.planId}</td>
					<td>${plan.planName}</td>
					<td>${plan.planDescription}</td>
					<td>${plan.planStartDate}</td>
					<td>${plan.planEndDate}</td>
			        	<td><a href="/editPlan?planId=${plan.planId}">Edit</a> &nbsp;&nbsp; <a 
									href="/deactivatePlan?planId=${plan.planId}"
									onclick="return deactivateConfirm()">DeActivate</a></td>
					</tr>
									
    				</c:when>
					<c:otherwise>
						<tr>
					<td>${plan.planId}</td>
					<td>${plan.planName}</td>
					<td>${plan.planDescription}</td>
					<td>${plan.planStartDate}</td>
					<td>${plan.planEndDate}</td>
			        	<td><a href="/editPlan?planId=${plan.planId}">Edit</a> &nbsp;&nbsp; <a 
									href="/activePlan?planId=${plan.planId}"
									onclick="return activateConfirm()">Activate</a></td>
					</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table><br><br>
		<a href="home" >back to Home</a>

	</div>

</body>
</html>