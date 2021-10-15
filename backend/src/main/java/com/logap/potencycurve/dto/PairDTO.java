package com.logap.potencycurve.dto;

import java.io.Serializable;

import com.logap.potencycurve.entities.Pair;

public class PairDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Double first;
	private Double second;

	public PairDTO() {
	}

	public PairDTO(Double first, Double second) {
		this.first = first;
		this.second = second;
	}
	
	public PairDTO(Pair obj) {
		this.first = obj.getFirst();
		this.second = obj.getSecond();
	}

	public Double getFirst() {
		return first;
	}

	public void setFirst(Double first) {
		this.first = first;
	}

	public Double getSecond() {
		return second;
	}

	public void setSecond(Double second) {
		this.second = second;
	}
}
