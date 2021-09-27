package com.logap.potencycurve.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logap.potencycurve.entities.Curve;
import com.logap.potencycurve.entities.utils.Pair;
import com.logap.potencycurve.services.CurveService;

@RestController
@RequestMapping(value = "/curve")
public class CurveController {

	@Autowired
	private CurveService service;
	
	@GetMapping
	public ResponseEntity<List<Curve>> findAll() {
		List<Curve> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	//TODO TESTE
	@GetMapping(value = "/test")
	public ResponseEntity<List<String[]>> readCsv() {
		List<String[]> csv = service.readCsv();
		return ResponseEntity.ok(csv);
	}
	
	@GetMapping(value = "/test1")
	public ResponseEntity<List<Pair>> csvToPairs() {
		List<Pair> pairs = service.csvToPairs();
		return ResponseEntity.ok(pairs);
	}
}
