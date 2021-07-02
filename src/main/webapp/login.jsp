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
	<div id="message">
	</div>
		<form onsubmit="loginCorrect()" method="post">
			
			<h3>Admin Login</h3>
			<label>Admin Name</label> <input type="text" id="adminName"
				name="username" required autofocus><br> <label>
				Password</label> <input type="password" id="adminPassword"
				name="password" required><br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
			<br> Note :<br> Admin name=admin<br> Admin
			password=admin123
		</form>
		<a href="UserLogin.jsp">User Login</a>
	</main>
<script>
function loginCorrect() {
	
	event.preventDefault();
	
	let userName=document.getElementById("adminName").value;
	
	let password=document.getElementById("adminPassword").value;
	let data={
			"userName":userName,
			"password":password
	}
	console.log(userName);
	let url="adminLoginServlet";
	axios.post(url,data).then(res=>{
		console.log(res.data);
		let data=res.data;
		//alert(data.infoMessage);
		document.querySelector("#message").innerHTML=data.infoMessage;
		window.location.href="TypeOfRecidency.jsp";
	}).catch(err=>{
		let data = err.response.data;
		console.log(err);
		alert(data.errorMessage);
		
	});
}


</script>
</body>
</html>