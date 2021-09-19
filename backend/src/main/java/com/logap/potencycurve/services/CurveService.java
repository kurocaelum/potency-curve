package com.logap.potencycurve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logap.potencycurve.entities.Curve;
import com.logap.potencycurve.repositories.CurveRepository;

@Service
public class CurveService {

	@Autowired
	private CurveRepository curveRepository;
	
	public List<Curve> findAll() {
		return curveRepository.findAll();
	}
}
