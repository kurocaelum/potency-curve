package com.logap.potencycurve.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pairs")
public class Pair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long first;
	private Long second;
	
	@ManyToOne
	@JoinColumn(name = "curve_id")
	private Curve curve;
	
	public Pair() {
	}

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
