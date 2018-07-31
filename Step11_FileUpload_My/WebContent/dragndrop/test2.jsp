<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/dragndrop/test2.jsp</title>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>
<style>
	.box {
		width: 100px;
		height: 100px;
		background-color: yellow;
		border: 1px solid red;
		float: left;
	}
	.drop-area {
		width: 300px;
		height: 300px;
		background-color: pink;
		margin: 0 auto;
		clear: left;
	}
</style>
</head>
<body>
<h3>drag and drop 테스트</h3>
<div class="box" draggable="true" id="one">drag me!</div>
<div class="box" draggable="true" id="two">drag me!</div>
<div class="box" draggable="true" id="three">drag me!</div>
<div class="drop-area"></div>
<script>	
	$(".box").on("dragstart", function(e) {
		$(this).text("dragging…");
		//이벤트가 일어난 요소의 id 값을 읽어오기
		var id=$(this).attr("id");
		//info 라는 키값으로 이벤트 객체에 담기
		e.originalEvent.dataTransfer.setData("info", id);
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
		//드롭된 요소의 정보를 읽어오기
		var info=e.originalEvent.dataTransfer.getData("info");
		$(this).text(info+" dropped!");
	});
</script>
</body>
</html>