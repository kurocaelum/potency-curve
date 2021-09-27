package com.logap.potencycurve.entities.utils;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.logap.potencycurve.entities.Curve;
import com.opencsv.bean.CsvBindByPosition;

@Embeddable
@Table(name = "tb_pairs")
public class Pair {

	@CsvBindByPosition(position = 0)
	private String first;
	
	@CsvBindByPosition(position = 1)
	private String second;
	
	@ManyToOne
	@JoinColumn(name = "curve_id")
	private Curve curve;
	
	public Pair() {
	}

	public Pair(Curve curve, String first, String second) {
		this.curve = curve;
		this.first = first;
		this.second = second;
	}

	public String getFirst() {
		return first;
	}

	public String getSecond() {
		return second;
	}

	public Curve getCurve() {
		return curve;
	}
}
