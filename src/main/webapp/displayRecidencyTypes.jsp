<%@page import="com.abinanth.model.RecidencyModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of Recidency Type</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js" integrity="sha512-bZS47S7sPOxkjU/4Bt0zrhEtWx0y0CRkhEp8IckzK+ltifIIE9EMIMTuT/mEzoIMewUINruDBIR/jJnbguonqQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<table class=" table table-container-fluid">
			<caption>Available Recidency</caption>
			<h2>Recidency Types</h2>
			<thead>
				<tr>
					<th scope="col">S.No</th>
					<th scope="col">Recidency Types</th>
				</tr>
			</thead>
			<tbody id="listOfRecidencyType">
				
			</tbody>
		</table>
	</main>

<script>
 function listAllRecidency() {

		let url ="listAllRecidency"
		axios.get(url).then(res=> {
			let recidency=res.data;
			let i=0;
			let content="";
			for( let id of recidency) {
				console.log(id);
				content+= "<tr><td>"+(++i)+"</td><td>"+id.recidencyType+"</td></tr>";
			}
			console.log(content);
			document.querySelector("#listOfRecidencyType").innerHTML=content;
 });
 }


 listAllRecidency();
</script>
</body>
</html>