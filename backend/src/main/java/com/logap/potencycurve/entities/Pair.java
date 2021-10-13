package com.logap.potencycurve.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByPosition;

@Entity
@Table(name = "tb_pairs")
public class Pair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	public void setCurve(Curve curve) {
		this.curve = curve;
	}
}
