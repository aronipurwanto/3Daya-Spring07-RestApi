<% request.setAttribute("contextName", request.getServletContext().getContextPath()); %>
<!-- form mulai -->
<form id="form-create" class="form-horizontal">
	<div class="box box-info">
		<div class="box-header with-border">
			<h3 class="box-title">From PO</h3>
		</div>
		<div class="box-body">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-2">PO Number</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="po[poNumber]" id="poNumber" />
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label col-md-2">PO Date</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="po[poDate]" id="poDate" />
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label col-md-2">Supplier</label>
						<div class="col-md-10">
							<select class="form-control" name="po[supplierId]" id="supplierId">
							
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-2">Notes</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="po[notes]" id="notes" />
						</div>
					</div>
				</div>
			</div>
			
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">List Product</h3>
					<div class="box-tools">
						<button type="button" id="btn-add-product" class="btn btn-sm btn-success"><i class="fa fa-plus"></i></button>
					</div>
				</div>
				<div class="box-body no-padding">
					<table class="table table-stipped">
						<thead>
							<tr>
								<th class="col-md-3">Product</th>
								<th>Packages</th>
								<th>Price</th>
								<th>Quantity</th>
								<th>Sub Total</th>
								<th>#</th>
							</tr>
						</thead>
						<tbody id="list-detail">					
						</tbody>
					</table>
				</div>
			</div>	
			<div class="row">
				<div class="col-md-6 col-md-offset-6">
					<div class="form-group">
						<label class="control-label col-md-4">Total Amount</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="po[totalAmount]" id="totalAmount" value="0" />
						</div>
					</div>
				</div>
			</div>		
		</div>
		
		<div class="box-footer">
			<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary">Simpan</button>
			<button type="button" class="btn btn-warning pull-right" data-dismiss="modal">Close</button>
		</div>	
	</div>
</form>
<!-- Form Selesai -->
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
	$(function(){
		loadSupplier(0);
	});
	
	// btn add click
	$("#btn-add-product").click(function(){
		$.ajax({
			url:'${contextName}/po/form-product',
			type:'get',
			dataType:'html',
			success:function(result){
				$('#modal-data').html(result);
				// show modal
				$('#modal-form').modal('show');
				// call load product
				loadProduct();
			}
		});
	});
	
	// load product
	function loadProduct(){
		$.ajax({
			url:'${contextName}/api/product/',
			type:'get',
			dataType:'json',
			success:function(result){
				$('#modal-data').find('#productId').empty();
				$('#modal-data').find('#productId').append('<option value=""></option>');
				$.each(result, function(index, item){
					$('#modal-data').find('#productId').append('<option value="'+ item.id +'">'+ item.name +'</option>');
				});
			}
		});
	}
	
	// ketika combo product di click
	function getProductById(pId){
		$.ajax({
			url:'${contextName}/api/product/'+pId,
			type:'get',
			dataType:'json',
			success:function(result){
				$('#modal-data').find('#packageId').val(result.packageId);
				$('#modal-data').find('#productName').val(result.name);
				$('#modal-data').find('#packageName').val(result.packages.name);
				$('#modal-data').find('#price').val(result.price);
				$('#modal-data').find('#quantity').focus();
			}
		});
	}
	// hitung sub total
	function hitungSubTotal(){
		var price = parseInt($('#modal-data').find('#price').val());
		var quantity = parseInt($('#modal-data').find('#quantity').val());
		var subTotal = price * quantity;
		$('#modal-data').find('#subTotal').val(subTotal);
	}
	
	// add product
	function addProduct($product){
		var dataProduct = $product.serializeJSON();
		var dataRow = '<tr>'+
				'<td>'+
					'<input type="hidden" name="detail[][productId]" value="'+ dataProduct.productId +'" class="form-control productId"/>'+
					'<input type="text" name="detail[][packageName]" value="'+ dataProduct.productName +'" class="form-control packageName"/>'+
				'</td>'+
				'<td>'+
					'<input type="hidden" name="detail[][packageId]" value="'+ dataProduct.packageId +'" class="form-control packageId"/>'+
					'<input type="text" name="detail[][packageName]" value="'+ dataProduct.packageName +'" class="form-control packageName"/>'+
				'</td>'+
				'<td><input type="text" name="detail[][price]" value="'+ dataProduct.price +'" class="form-control price"/></td>'+
				'<td><input type="text" name="detail[][quantity]" value="'+ dataProduct.quantity +'" class="form-control quantity"/></td>'+
				'<td><input type="text" name="detail[][subTotal]" value="'+ dataProduct.subTotal +'" class="form-control subTotal"/></td>'+
				'<td><button type="button" class="btn btn-remove btn-xs btn-danger"><i class="fa fa-trash"></i></button></td>'
			'</tr>';
		// add data to list-detail
		$('#list-detail').append(dataRow);
		// hide modal
		$('#modal-form').modal('hide');
		
		// menambah ke total
		// 1. get total yang lama
		var total = parseInt($('#totalAmount').val());
		var subTotal = parseInt(dataProduct.subTotal);
		// 2. total lama ditambah subtotal
		total = total+subTotal;
		// 3. kirim nilai total yang terakhir ke id totalAmount
		$('#totalAmount').val(total);
	}
	
	function addData($form){
		var dataForm = $form.serializeJSON();
		var dataPo = JSON.stringify(dataForm);
		$.ajax({
			// url ke api/po/
			url:'${contextName}/api/po/',
			type:'post',
			// data type berupa JSON
			dataType:'json',
			// mengirim parameter data
			data:dataPo,
			// mime type 
			contentType: 'application/json',
			success : function(result){
				// redirect to index
				window.location.replace('${contextName}/po');
			}
		});
	}
	
	// remove button
	$('#list-detail').on('click','.btn-remove', function(){
		$(this).closest('tr').remove();
	});
	
	function loadSupplier($selected){
		$.ajax({
			// url ke api/product/
			url:'${contextName}/api/supplier/',
			type:'get',
			// data type berupa JSON
			dataType:'json',
			success : function(result){
				// empty data first
				$("#supplierId").empty();
				$("#supplierId").append('<option value="">=Select Supplier=</option>');
				// looping data
				$.each(result, function(index, item){
					if($selected == item.id){
						$("#supplierId").append('<option value="'+ item.id +'" selected="selected">'+item.name +'</option>');
					}else {
						$("#supplierId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
					}
				});
			}
		});
	}
</script>


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