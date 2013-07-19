<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
function handleClick(evt) {
 document.location.href="sap.project1.TicketReservationServlet?buttonNum=node.value"
}

</script>

	<table id="table1" border="1" onclick="handleClick(event);">
		<thead>
			<tr>
				<th>Select
		</thead>
		<tbody>
			<tr>
				<td>
					<form name="f1" action="#">
						<input id="edit1" type="submit" name="1" value="1"> <input
							id="edit1" type="submit" name="2" value="2"> <input
							id="edit1" type="submit" name="3" value="3"> <input
							id="edit1" type="submit" name="4" value="4">

					</form>
			<tr>
				<td>
					<form name="f2" action="#">
						<input id="edit2" type="submit" name="5" value="5"> <input
							id="edit1" type="submit" name="6" value="6"> <input
							id="edit1" type="submit" name="7" value="7"> <input
							id="edit1" type="submit" name="8" value="8">
					</form>
			<tr>
				<td>
					<form name="f3" action="#">
						<input id="edit3" type="submit" name="9" value="9"> <input
							id="edit1" type="submit" name="10" value="10"> <input
							id="edit1" type="submit" name="11" value="11"> <input
							id="edit1" type="submit" name="12" value="12">
					</form>
		</tbody>
	</table>
</body>
</html>