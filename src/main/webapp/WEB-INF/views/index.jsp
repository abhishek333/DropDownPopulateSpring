<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dropdown option populate</title>
</head>
<body>
	Country:
	<select id="country">
		<option value="-1">--select--</option>
		<c:forEach items="${countries}" var="country">
		<option value="${country.id}">${country.name}</option>
		</c:forEach>
	</select>
	State:	
	<select id="state">
		<option value="-1">--select--</option>		
	</select>
	
<c:url value="/bootstrap_3.2/js/jquery-1.9.1.js" var="jquery"/>
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript">
$('select#country').change(function(e){
	var $state = $('select#state');
	$state.empty();	
	$.getJSON('${pageContext.request.contextPath}/getstates/'+$(this).val(),function(states){
		console.log(JSON.stringify(states));
		$.each(states,function( key, val ) {
			$state.append($("<option></option>")
                    .attr("value",val.id)
                    .text(val.name));
		});
	});
});
</script>
</body>
</html>