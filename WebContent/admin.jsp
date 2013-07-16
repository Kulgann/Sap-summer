<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
</head>
<body>
 <center>
 <p><font size=20>ADMIN CONTROL PANEL</font></p>
 <br>
 <% if(request.getParameter("answer")!=null) { %>
 <p><%= request.getParameter("answer") %></p>
 <br>
 <% } %>
 <form action=AdminServlet method="post" name=myForm>
  <table border=1>
   <tr>
    <td>
     <select name="action">
      <option value="0" selected>neshto si</option>
      <option value="1">Create Database</option>
     </select>
    </td>
    <td>
     <input type="submit" value="DO!">
    </td>
   </tr>
  </table>
 </form>
 </center>
</body>
</html>