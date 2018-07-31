<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/dragndrop/test1.jsp</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<style>
	.box {
		width: 100px;
		height: 100px;
		background-color: yellow;
	}
	.drop-area {
		width: 300px;
		height: 300px;
		background-color: pink;
		margin: 0 auto;
	}
</style>
</head>
<body>
<h3>drag and drop 테스트</h3>
<div class="box" draggable="true">drag me!</div>
<div class="drop-area"></div>
<script>	
	$(".box").on("dragstart", function(e) {
		$(this).text("dragging…");
	});
	$(".box").on("dragend", function(e) {
		$(this).text("dragend!");
	});
	$(".drop-area").on("dragover", function(e) {
		e.preventDefault();
		e.stopPropagation();
	});
	$(".drop-area").on("drop", function(e) {
		e.preventDefault();
		e.stopPropagation();
		$(this).text("something dropped!");
	});
</script>
</body>
</html>