package com.yizhilu.os.core.gain;

import java.util.List;
import java.util.ArrayList;

public class NameSpaceVO {
	private String name;
	private List<TableVO> tableList = new ArrayList<TableVO>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TableVO> getTableList() {
		return tableList;
	}

	public void setTableList(List<TableVO> tableList) {
		this.tableList = tableList;
	}
}
