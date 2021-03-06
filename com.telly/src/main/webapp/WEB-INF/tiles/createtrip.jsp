<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<h2>Create a Bus Trip</h2>

<sf:form method="post" modelAttribute="bus">


	<div class="error">
		<sf:errors path="date"></sf:errors>
	</div>

	<table class="form-horizontal" role="form">
		<tr>
			<td class="control-label col-sm-2">Leave Date:</td>
			<td><sf:input class="col-sm-10" path="date" name="date"
					type="date" /><br/></td>
		<tr>
		<tr>
			<td class="control-label col-sm-2">Destination</td>
			<td><sf:input class="col-sm-10" path="destination"
					name="destination" type="text" /><br />
				<div class="error">
					<sf:errors path="destination"></sf:errors>
				</div></td>
		<tr>
		<tr>
			<td class="control-label col-sm-2">Transporter</td>
			<td><sf:input class="col-sm-10" path="transporterid"
					name="transporterid" type="text" /><br />
				<div class="error">
					<sf:errors path="transporterid"></sf:errors>
				</div></td>
		<tr>
			<td>
			<td>
			<td><input class="btn-primary pull-right" value="Create Trip"
				type="submit" /></td>
		</tr>
	</table>


</sf:form>