<!-- form mulai -->
<form id="form-create" class="form-horizontal">
	<div class="form-group">
		<label class="control-label col-md-2">Code</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="code" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" />
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" onClick="addData($('#form-create'))" class="btn btn-primary">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->