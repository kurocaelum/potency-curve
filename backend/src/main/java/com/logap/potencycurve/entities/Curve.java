package com.logap.potencycurve.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logap.potencycurve.entities.utils.Pair;

@Entity
@Table(name = "tb_curves")
public class Curve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@Embedded
	private List<Pair> plotData = new ArrayList<>();

	public Curve() {
	}

	public Curve(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public List<Pair> getPlotData() {
		return plotData;
	}
}
