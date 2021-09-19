package com.logap.potencycurve.entities.utils;

import javax.persistence.Embeddable;

@Embeddable
public class Pair {

	private Long first;
	private Long second;

	public Pair(Long first, Long second) {
		this.first = first;
		this.second = second;
	}

	public Long getFirst() {
		return first;
	}

	public Long getSecond() {
		return second;
	}
}
