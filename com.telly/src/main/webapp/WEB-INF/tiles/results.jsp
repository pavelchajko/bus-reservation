<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Search</h2>



<sf:form method="post" modelAttribute="bus">


	<div class="error">
		<sf:errors path="date"></sf:errors>
	</div>
	
	<table class="form-horizontal" role="form">
		<tr>


			<td class="control-label col-sm-2">Date:</td>
			<td><sf:input class="col-sm-10" path="date" name="date"
					type="date" /><br/>
		<tr>
		
		<tr>
			<td class="control-label col-sm-2">Destination</td>
			<td><sf:input class="col-sm-10" path="destination"
					name="destination" type="text" /><br />
				<div class="error">
					<sf:errors path="destination"></sf:errors>
				</div></td>
		<tr>
	
		
			<td>
			<td><input class="btn-primary pull-right" value="Search"
				type="submit" /></td>
		</tr>
	</table>
</sf:form>

<p>
	<br>



	<c:forEach var="results" items="${results}">
		<p>
			Date:
			<c:out value="${results.date}"></c:out>
		<p>
			Destination:
			<c:out value="${results.destination}"></c:out>
		<p>
		
		<p>
			Transporter:
			<c:out value="${results.transporterid}"></c:out>
		<p>
		
		
			<c:if test="${results != null}">
				<sf:form method="post"
					action="${pageContext.request.contextPath}/book"
					modelAttribute="reservations">
					
					<input id="id" name="id" type="hidden" value="${results.id}" />
					<input id="transporterid" name="transporterid" type="hidden" value="${results.transporterid}" />
					<p>
						Row:
					<input id="row" name="row" type="text" />
					</p>
					<p>
						Seat:
					<input id="seat" name="seat" type="text" />
				   </p>
					<input class="btn-primary" value="Book" type="submit" />
				

				</sf:form>
				<br>
			</c:if>
	</c:forEach>


</p>