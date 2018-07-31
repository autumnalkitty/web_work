<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/dropzone/upload_form.jsp</title>
<link rel="stylesheet" href="dropzone.css" />
<script src="dropzone.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
</head>
<body>
<h3>dropzone js 테스트</h3>
<form action="upload.jsp" method="post" class="dropzone" id="myForm">
	<input type="file"  name="myFile" id="myFile"/>
</form>
<script>
	Droptzone.options.myForm= {
			param: "myFile", 
			success: function(file, responseData) {
				console.log(responseData);
			}
	}
</script>
</body>
</html>