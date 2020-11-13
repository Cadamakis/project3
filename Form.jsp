<!DOCTYPE html>
<html>
<link href="my_css1.css" rel = "stylesheet" type = "text/css">
<head>
<title>Insert Product Form</title>
<style> 
input[type=submit] {
  background-color: springgreen;
  color: white;
  padding: 10px 25px;
  margin: 2px 1px;
  cursor: pointer;
}
</style>
</head>
<body>
	<form method="POST" action="Entry.do">
		<p align="center">
			<h2>Insert Product Details</h2> <br></br> 
			<h3>Name : <INPUT TYPE="text" NAME="name" VALUE="">
			</h3><br></br>
			<h3>Barcode :
			<INPUT TYPE="text" NAME="barcode" VALUE="">
			</h3><br></br>
			<h3>Color : 
			<INPUT TYPE="text" NAME="color" VALUE="">
			</h3><br></br>
			<h3>Description :
			<INPUT TYPE="text" NAME="description" VALUE="">
			</h3><br></br>
		</p>
		<center>
			<b>
			<input type="SUBMIT" value="Insert Product">
			</b> 
		</center>
	</form>
</body>
</html></html>
