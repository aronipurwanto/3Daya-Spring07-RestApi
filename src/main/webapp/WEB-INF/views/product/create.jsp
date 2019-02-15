<!-- form mulai -->
<form id="form-create" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-2">Code</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="code" id="code" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" id="name" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">Package</label>
		<div class="col-md-10">
			<select name="packageId" class="form-control" id="packageId">
				<option value="">=Select Package=</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">Category</label>
		<div class="col-md-10">
			<select name="categoryId" class="form-control" id="categoryId">
				<option value="">=Select Package=</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">Price</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="price" id="price" />
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary pull-left">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->