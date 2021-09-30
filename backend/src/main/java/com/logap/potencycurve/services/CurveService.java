package com.logap.potencycurve.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logap.potencycurve.entities.Curve;
import com.logap.potencycurve.entities.Pair;
import com.logap.potencycurve.repositories.CurveRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

@Service
public class CurveService {

	@Autowired
	private CurveRepository curveRepository;

	public List<Curve> findAll() {
		return curveRepository.findAll();
	}
	
	public Curve save(Curve obj) {
		return curveRepository.save(obj);
	}
	
	// TODO TESTE read csv
	public List<String[]> readCsv() {
		String fileName = "static/Abr-2017-curva-potencia-windbox.csv";
		ClassLoader classLoader = getClass().getClassLoader();
		CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

		try (CSVReader reader = new CSVReaderBuilder(new FileReader(classLoader.getResource(fileName).getFile()))
				.withCSVParser(csvParser).withSkipLines(1).build()) {
			List<String[]> r = reader.readAll();
			r.forEach(x -> System.out.println(Arrays.toString(x)));
			return r;
		} catch (IOException | CsvException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// TODO TESTE read csv
	public List<Pair> csvToPairsTest() {
		String fileName = "static/Abr-2017-curva-potencia-windbox.csv";
		ClassLoader classLoader = getClass().getClassLoader();
		
		try {
			List<Pair> pairs = new CsvToBeanBuilder<Pair>(new FileReader(classLoader.getResource(fileName).getFile()))
			        .withType(Pair.class)
			        .withSeparator(';')
			        .withSkipLines(1)
			        .build()
			        .parse();
			return pairs;
		} catch (IllegalStateException | FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// TODO findById()
}
