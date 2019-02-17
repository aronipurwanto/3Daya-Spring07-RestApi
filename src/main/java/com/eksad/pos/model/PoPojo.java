package com.eksad.pos.model;

import java.util.List;

public class PoPojo {
	private PoModel po;
	private List<PoDetailModel> detail;
	public PoModel getPo() {
		return po;
	}
	public void setPo(PoModel po) {
		this.po = po;
	}
	public List<PoDetailModel> getDetail() {
		return detail;
	}
	public void setDetail(List<PoDetailModel> detail) {
		this.detail = detail;
	}
}
