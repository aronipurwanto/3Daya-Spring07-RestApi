<!-- form mulai -->
<form id="form-delete" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" id="id" />
	
	<!-- code -->
	<div class="form-group">
		<label class="control-label col-md-2">Code</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="code" id="code" readonly="readonly" />
		</div>
	</div>
	
	<!-- name -->
	<div class="form-group">
		<label class="control-label col-md-2">Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" id="name" readonly="readonly"/>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">Package</label>
		<div class="col-md-10">
			<select name="packageId" class="form-control" id="packageId" readonly="readonly">
				<option value="">=Select Package=</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">Category</label>
		<div class="col-md-10">
			<select name="categoryId" class="form-control" id="categoryId" readonly="readonly">
				<option value="">=Select Package=</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2">Price</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="price" id="price" readonly="readonly" />
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-danger pull-left" onClick="deleteData($('#form-delete'))">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->