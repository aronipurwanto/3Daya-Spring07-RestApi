<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Category List</h3>
	</div>
	<div class="box-body">
		<table class="table">
			<thead>
				<tr>
					<th>Kode</th>
					<th>Name</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.code}</td>
					<td>${item.name}</td>
					<td></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</div>
</div>