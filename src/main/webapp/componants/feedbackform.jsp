<html>
<head>
<title></title>
<%@include file="links.jsp"%>
</head>
<body class="bg-black">
	<%@include file="navbar.jsp"%>

	<div
		class=" p-4 d-flex flex-column justify-content-center align-items-center">
		<h3 class="text-white">Fill The Feedback Form</h3>
		<form action="<%=application.getContextPath()%>/feedback" method="post" class="mt-4 text-white">
			<!-- Email Input -->
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email
					address</label> <input type="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp" name="email" required="required">
				<div id="emailHelp" class="form-text text-white">We'll never
					share your email with anyone else.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Phone
					Number</label> <input type="text" class="form-control"
					id="exampleInputPassword1" name="phoneNumber" required="required">
			</div>

			<!--fEEDBACK Input -->
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Feedback</label>
				<textarea rows="10" cols="" placeholder="Enter Here"
					class="form-control" name="feedback" required="required"></textarea>
			</div>
			<div class="mb-3 text-center">
				<button type="reset" class="btn btn-warning m-4 mt-0">Reset</button>
				<button type="submit" class="btn btn-primary m-4 mt-0">Submit</button>
			</div>

		</form>
	</div>
</body>
</html>
