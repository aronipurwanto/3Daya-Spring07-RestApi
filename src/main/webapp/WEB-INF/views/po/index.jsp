<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">PO List</h3>
	</div>
	<div class="box-body">
		<div class="row">
			<div class="col-md-3">
				<input type="text" class="form-control"/>
			</div>
			<div class="col-md-2 col-md-offset-7">				
				<button type="button" class="btn btn-info btn-sm">Export</button>
				<a href="${contextName}/new-po" id="btn-add" class="btn btn-success btn-sm">
					<i class="fa fa-plus"></i> Add
				</a>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>No PO</th>
					<th>Tgl PO</th>
					<th>Supplier</th>
					<th>Notes</th>
					<th>Total Amount</th>
					<th>#</th>
				</tr>
			</thead>
			<tbody id="list-data">
			</tbody>
		</table>		
	</div>
</div>

<div class="modal" id="modal-form">
	<div class="modal-dialog">
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title" id="modal-title">Form Input</h3>
			</div>
			<div class="box-body" id="modal-data">
				
			</div>
		</div>
	</div>
</div>
<script>
	// method yang pertama kali dipanggil saat page di load
	$(function(){
		// memanggil method loadData;
		loadData();
	});
	
	//ketika button add di click
	$("#btn-add").click(function(){
		$.ajax({
			url:'${contextName}/po/create',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Add New Category");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
			}
		});
	});
	
	//method loadData
	function loadData(){
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				//kosong data di table
				$("#list-data").empty();
				// looping data dengan jQuery
				$.each(result, function(index, item){
					var dataRow ='<tr>'+
						'<td>'+ item.poNumber +'</td>'+
						'<td>'+ item.poDate+'</td>'+
						'<td>'+ item.supplier.name+'</td>'+
						'<td>'+ item.notes+'</td>'+
						'<td>'+ item.totalAmount+'</td>'+
						'<td class="col-md-1">'+
							'<button type="button" class="btn btn-edit btn-warning btn-xs" value="'+ item.id +'"><i class="fa fa-edit"></i></button> '+
							'<button type="button" class="btn btn-detail btn-success btn-xs" value="'+ item.id +'"><i class="fa fa-eye"></i></button> '+
							'<button type="button" class="btn btn-delete btn-danger btn-xs" value="'+ item.id +'"><i class="fa fa-trash"></i></button> '+
						'</td>'+
						'</tr>';
					$("#list-data").append(dataRow);
				});
				// menampilkan data ke console => F12
				console.log(result);
			}
		});
	}
	
	// method untuk add data
	function addData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/',
			type:'post',
			// data type berupa JSON
			dataType:'json',
			// mengirim parameter data
			data:JSON.stringify(dataForm),
			// mime type 
			contentType: 'application/json',
			success : function(result){
				//menutup modal
				$("#modal-form").modal('hide');
				// panggil method load data, untuk melihat data terbaru
				loadData();
			}
		});
		console.log(dataForm);
	}
	
	// function get data 
	function getData(dataId){
		// panggil API
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/'+dataId,
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(dataApi){
				$('#modal-data').find('#id').val(dataApi.id);
				$('#modal-data').find('#code').val(dataApi.code);
				$('#modal-data').find('#name').val(dataApi.name);
				
				console.log(dataApi);
			}
		});
	}
	
	// ketidak btn-edit di click
	$('#list-data').on('click','.btn-edit', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/po/edit',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Edit Data Category");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				// panggil method getData
				getData(vid);
			}
		});
	});
	
	// method untuk delete data
	function editData($form){
		// memangil method getFormData dari file
		// resources/dist/js/map-form-objet.js
		var dataForm = getFormData($form);
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/',
			type:'put',
			// data type berupa JSON
			dataType:'json',
			// mengirim parameter data
			data:JSON.stringify(dataForm),
			// mime type 
			contentType: 'application/json',
			success : function(result){
				//menutup modal
				$("#modal-form").modal('hide');
				// panggil method load data, untuk melihat data terbaru
				loadData();
			}
		});
		console.log(dataForm);
	}
	
	// ketidak btn-detail di click
	$('#list-data').on('click','.btn-detail', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/po/detail',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Detail Data Category");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				//panggil method
				getData(vid);
			}
		});
	});
	
	// ketidak btn-delete di click
	$('#list-data').on('click','.btn-delete', function(){
		var vid = $(this).val();
		$.ajax({
			url:'${contextName}/po/delete',
			type:'get',
			dataType:'html',
			success : function(result){
				//mengganti judul modal
				$("#modal-title").html("Delete Data Category");
				//mengisi content dengan variable result
				$("#modal-data").html(result);
				//menampilkan modal pop up
				$("#modal-form").modal('show');
				//panggil method
				getData(vid);
			}
		});
	});
	
	// method untuk delete data
	function deleteData($form){
		// memangil method getFormData dari file
		var vid = $form.find("#id").val();
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/'+vid,
			// method http di controller
			type:'delete',
			// data type berupa JSON
			dataType:'json',
			// jika sukses
			success : function(result){
				//menutup modal
				$("#modal-form").modal('hide');
				// panggil method load data, untuk melihat data terbaru
				loadData();
				console.log(result);
			}
		});
	}
</script>

