<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="sendData">
	ID <input type="number" name="id"><br>
	Name <input type="text" name="name"><br>
	Desg <input type="text" name="desg"><br>
	Salary <input type="number" name="salary"><br>
	<input type="submit" value="Send Data"><br>
	
	
</form>


<br>
	<br>
	<br>
	<hr>
	<h1>Delete using Id</h1>
	<form action="deleteData">
		<table>
			<tr>
				<td>Enter ID of user to be deleted</td>
				<td><input type="number" name="id"></td>
				<td></td><td><input type="submit" value="Delete"></td>
			</tr>
		</table>
	<br>
	<br>
	<br>
</body>
</html>