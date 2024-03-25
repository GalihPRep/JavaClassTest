<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style>
		body {
			height: 100%;
			margin: 0;
			font-family: Calibri;
			display: flex;
			align-items: center;
			justify-content: center;
			flex-direction: column;
			font-family: Calibri;
			font-size: 11pt;
		}
	    table {
	        border-collapse: collapse;
	    }
	
	    th, td {
	        border: 1px solid black;
	        padding: 8px;
	        text-align: left;
	    }
	    thead td {
	        background-color: #4472C4;
	        color: white;
	    }
	    .student-id {
	    	font-weight: bold;
	    }
	</style>
</head>
<body>
<div>
	<p>Welcome, ${username}.</p>
	<table>
		<thead><tr>
			<td>Department</td>
			<td>Student ID</td>
			<td>Marks</td>
	 		<td>Pass %</td>
		</tr></thead>
		<tbody>
			<c:forEach items="${students}" var="n">
				<tr>
					<td><c:out value="${n.department}"/></td>
					<td><a class="student-id" href="#" onclick="showStudentName('${n.studentName}')">
						<c:out value="${n.studentId}"/>
					</a></td>
					<td><c:out value="${n.mark}"/></td>
					<td><c:out value="${n.pass}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script>
	function mergeCells() {
	    var cellsDepartment = document.querySelectorAll('tbody tr td:first-child');
	    var previousDepartment = null;
	    var nthDepartment = null;
	    var rowspanDepartment = 1;
	    for (var i = 0; i < cellsDepartment.length; i++) {
	        var currentDepartment = cellsDepartment[i].textContent;
	        if (currentDepartment === previousDepartment) {
	        	rowspanDepartment++;
	        	cellsDepartment[i].style.display = 'none';
	        	cellsDepartment[nthDepartment].setAttribute('rowspan', rowspanDepartment);
	        } else {
	            previousDepartment = currentDepartment;
	            nthDepartment = i;
	            rowspanDepartment = 1;
	        }
	    }
	    var cellsPass = document.querySelectorAll('tbody tr td:last-child');
	    var previousPass = null;
	    var nthPass = null;
	    var rowspanPass = 1;
	    for (var i = 0; i < cellsPass.length; i++) {
	        var currentPass = cellsPass[i].textContent;
	        if (currentPass === previousPass) {
	        	rowspanPass++;
	        	cellsPass[i].style.display = 'none';
	        	cellsPass[nthPass].setAttribute('rowspan', rowspanPass);
	        } else {
	        	previousPass = currentPass;
	        	nthPass = i;
	        	rowspanPass = 1;
	        }
	    }
	}
	window.onload = mergeCells;
    function showStudentName(name) {
        alert("Student name: " + name);
    }
</script>
</body>
</html>