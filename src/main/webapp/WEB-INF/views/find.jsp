<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detaills</title>
<style type="text/css">
table tr td,th{
border: 1px solid black;
width: 100px;
text-align: center;
}
</style>
</head>
<body>
    <h2>${user.name} welcome!</h2>
    <table>
    <tr>
    <th>id</th>
    <th>name</th>
    <th>age</th>
    <th>sex</th>
    </tr>
    <tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.age}</td>
    <td>${user.sex}</td>
    </tr>
    </table>
 
</body>
</html>
