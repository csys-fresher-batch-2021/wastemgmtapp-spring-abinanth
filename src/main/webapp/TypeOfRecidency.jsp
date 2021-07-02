<%@page import="com.abinanth.model.RecidencyModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Waste Management</title>
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
			<tbody id="recidency">	
			</tbody>
		</table>
		<a href="addRecidency.jsp">Add Recidency</a>
	</main>
	<script>
	function getAllRecidency() {
		
				let url ="getAllRecidency"
				axios.get(url).then(res=> {
					let recidency=res.data;
					let i=0;
					let content="";
					for( let id of recidency) {
						console.log(id);
						let link ="<button type='button' onclick=deleteRecord('"+ id.recidencyType +"') class='btn btn-danger'>Delete</button>";
						console.log(link);
						content+= "<tr><td>"+(++i)+"</td><td>"+id.recidencyType+"</td><td>"+link+"</td></tr>";	
					}
					console.log(content);
					document.querySelector("#recidency").innerHTML=content;
	});
	}
			getAllRecidency();
			
			
			function deleteRecord (id){
				let cfm = confirm("Do you want to delete ?"); //return true/false
				let url ="deleteRecidency/"+ id;
				if(cfm){
					axios.delete(url).then(res=>{
						let recidencyType=res.data;
						console.log(recidencyType);
						alert("Deleted Successfully");
						getAllRecidency();
					});
				}
			}
	</script>
</body>
</html>