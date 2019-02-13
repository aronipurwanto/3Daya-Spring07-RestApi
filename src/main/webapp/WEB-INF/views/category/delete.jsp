<!-- form mulai -->
<form id="form-delete" class="form-horizontal">
	<!-- id -->
	<input type="hidden" name="id" />
	
	<!-- code -->
	<div class="form-group">
		<label class="control-label col-md-2">Code</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="code" readonly="readonly" />
		</div>
	</div>
	
	<!-- name -->
	<div class="form-group">
		<label class="control-label col-md-2">Name</label>
		<div class="col-md-10">
			<input type="text" class="form-control" name="name" readonly="readonly"/>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary">Simpan</button>
		<button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
	</div>
</form>
<!-- Form Selesai -->