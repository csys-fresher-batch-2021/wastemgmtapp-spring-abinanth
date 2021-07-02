<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Select Recidency Type</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js" integrity="sha512-bZS47S7sPOxkjU/4Bt0zrhEtWx0y0CRkhEp8IckzK+ltifIIE9EMIMTuT/mEzoIMewUINruDBIR/jJnbguonqQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Bill Calculation</h3>
		<form onsubmit="getBillDetails()" method="post">
			<label>Enter Name</label> <input type="text" name="username" id="userName"
				autofocus required><br> <label>Recidency Type</label>
				<label>Enter Recidency Type </label><input name="recidencyType" id="recidencyType">
    			<br> <label>Enter Recidency No</label> <input type="number"
				name="recidencyNo" id="recidencyNo" min=1 required><br> 
				<label>Enter
				The Street Name</label> <input type="text" name="streetName" id ="streetName" required><br>
			<label>Enter Your City</label> <input type="text" name="cityName" id="cityName"
				required><br> 
				<label>Enter Your District</label> <input
				type="text" name="districtName" id="district" required><br> 
				<label>Enter Number of years You need to pay</label>
				 <input type="number" name="date" id="year"
				min=1 max=3 required><br>
			<button type="submit" class="btn btn-primary">Get Bill</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
	<script>
	function getBillDetails() {
		event.preventDefault();
		alert("hi");
		let userName=document.getElementById("userName").value;
		let recidencyNo=document.getElementById("recidencyNo").value;
		let recidencyType=document.getElementById("recidencyType").value;
		let streetName=document.getElementById("streetName").value;
		let cityName=document.getElementById("cityName").value;
		let district=document.getElementById("district").value;
		let year=document.getElementById("year").value;
		let data={
				"userName":userName,
				 "recidencyNo":recidencyNo,
				 "recidenyType":recidencyType,
				 "streetName":streetName,
				 "cityName":cityName,
				 "district":district,
				 "year":year
		}
		let url="BillCalculator";
		axios.post(url,data).then(res=>{
			console.log(res.data);
			let data=res.data;
			alert(data.infoMessage);
		}).catch(err=>{
			let data = err.response.data;
			console.log(err);
			alert(data.errorMessage);
			window.location.href="BillCalculator.jsp";
			loginCorrect();
		});
	}
	</script>
</body>
</html>