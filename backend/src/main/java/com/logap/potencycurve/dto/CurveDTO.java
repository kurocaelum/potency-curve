package com.logap.potencycurve.dto;

import java.io.Serializable;

import com.logap.potencycurve.entities.Curve;

public class CurveDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public CurveDTO() {
	}

	public CurveDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CurveDTO(Curve obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
