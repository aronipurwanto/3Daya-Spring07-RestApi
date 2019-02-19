<form id="form-product" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-3">Product</label>
		<div class="col-md-8">
			<select id="productId" name="productId" class="form-control" onChange="getProductById($(this).val());">
			
			</select>
			<input type="hidden" id="productName" name="productName">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">Package</label>
		<div class="col-md-8">
			<input type="hidden" id="packageId" name="packageId">
			<input type="text" id="packageName" name="packageName" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3">Price</label>
		<div class="col-md-8">
			<input type="text" id="price" name="price" value="0" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">Quantity</label>
		<div class="col-md-8">
			<input type="text" id="quantity" name="quantity" value="0" onKeypress="hitungSubTotal();" class="form-control"/>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">Sub Total</label>
		<div class="col-md-8">
			<input type="text" id="subTotal" name="subTotal" value="0" class="form-control"/>
		</div>
	</div>
	<div class="box-footer">
		<button type="button" class="btn btn-sm btn-success" onClick="addProduct($('#form-product'));">
			<i class="fa fa-plus"></i> Add
		</button>
		<button type="button" class="btn btn-sm btn-warning pull-right" data-dismiss="modal">
			<i class="fa fa-close"></i> Close
		</button>
	</div>
</form>
