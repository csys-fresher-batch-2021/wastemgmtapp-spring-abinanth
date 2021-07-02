<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Recidency</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js" integrity="sha512-bZS47S7sPOxkjU/4Bt0zrhEtWx0y0CRkhEp8IckzK+ltifIIE9EMIMTuT/mEzoIMewUINruDBIR/jJnbguonqQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form onsubmit="addRecidency()" method="post">
			<h2>Add Recidency</h2>
			<label for=" addRecidency">Recidency</label> <input type="text"
				name="recidency" id="recidency" required>
			<button type="submit">Submit</button>
		</form>
	</main>
	<script>
	function addRecidency() {
		event.preventDefault();
		let recidencyName=document.getElementById("recidency").value;
		let data={
				"recidencyType":recidencyName
		}
			let url="insertRecidency";
		axios.post(url,data).then(res=>{
			console.log(res.data);
			window.location.href="TypeOfRecidency.jsp";
		});
	}
	</script>
</body>
</html>