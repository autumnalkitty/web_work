<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
<h3>Expression Language 테스트</h3>
<h4>el 로 산술연산하기</h4>
<p>1+1=<strong>${1+1}</strong></p>
<p>10-9=<strong>${10-9}</strong></p>
<p>10*10=<strong>${10*10}</strong></p>
<p>10/3=<strong>${10/3}</strong></p>
<h4>el 로 비교연산하기</h4>
<p>10은 2보다 커요: <strong>${10>2}</strong></p>
<p>10은 2보다 커요: <strong>${10 gt 2}</strong></p>
<p>10은 2와 같거나 커요: <strong>${10>=2}</strong></p>
<p>10은 2와 같거나 커요: <strong>${10 ge 2}</strong></p>
<p>10은 2보다 작아요: <strong>${10<2}</strong></p>
<p>10은 2보다 작아요: <strong>${10 lt 2}</strong></p>
<p>10은 2와 같거나 작아요: <strong>${10<=2}</strong></p>
<p>10은 2와 같거나 작아요: <strong>${10 le 2}</strong></p>
<h4>el 로 논리연산하기</h4>
<p>true || false: <strong>${true || false}</strong></p>
<p>true or false: <strong>${true or false}</strong></p>
<p>true && false: <strong>${true && false}</strong></p>
<p>true and false: <strong>${true and false}</strong></p>
<p>!true: <strong>${!true}</strong></p>
<p>not true: <strong>${not true}</strong></p>
<h4>empty 연산자</h4>
<p>empty null: <strong>${empty null}</strong></p>
<p>empty "": <strong>${empty ""}</strong></p>
<p>not empty null: <strong>${not empty null}</strong></p>
<p>not empty "": <strong>${not empty ""}</strong></p>
</body>
</html>