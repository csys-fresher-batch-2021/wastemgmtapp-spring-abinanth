<%@page import="com.abinanth.model.PaymentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Search Status</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js" integrity="sha512-bZS47S7sPOxkjU/4Bt0zrhEtWx0y0CRkhEp8IckzK+ltifIIE9EMIMTuT/mEzoIMewUINruDBIR/jJnbguonqQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form onsubmit="search()" method="get">
		
			<h2>Search by Status or Recidency Name</h2>
			<input type="text" name="search"
				required>
			<button type="submit">Search</button>
		</form>

		<table class=" table table-container-fluid">
			<caption>Search</caption>
			<thead>
				<tr>
					<th scope="col">User Name</th>
					<th scope="col">Recidency No</th>
					<th scope="col">Recidency Name</th>
					<th scope="col">Amount</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody id="searchResults">
				
			</tbody>
		</table>
	</main>
	<script>
	function search() {
	event.preventDefault();
	let url="search";
	axios.get(url,data).then(res=> {
		let content="";
		let searchResult=res.data;
		console.log(searchResult);
		let i=0;
		for(let id of searchResult) {
			content+= "<tr><td>"+(++i)+"</td><td>"+id.recidencyNo+"</td><td>"+id.recidencyType+"</td><td>"
			+id.amount+"</td><td>"+id.status+"</td><td>"+id.due_date+"</td><td>"+id.paid_date+"</td><td>"+id.totalAmount+"</td></tr>";
		}
	document.querySelector("#searchResults").innerHTML=content;
	});

	
	}
	
	
	</script>

</body>
</html>