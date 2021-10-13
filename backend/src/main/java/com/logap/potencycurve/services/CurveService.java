package com.logap.potencycurve.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logap.potencycurve.dto.CurveDTO;
import com.logap.potencycurve.entities.Curve;
import com.logap.potencycurve.repositories.CurveRepository;

@Service
public class CurveService {

	@Autowired
	private CurveRepository curveRepository;

	public List<CurveDTO> findAll() {
		List<Curve> result = curveRepository.findAll();
		return result.stream().map(x -> new CurveDTO(x)).collect(Collectors.toList());
	}
	
	public Curve save(Curve obj) {
		return curveRepository.save(obj);
	}
		
	// TODO findById()
}
