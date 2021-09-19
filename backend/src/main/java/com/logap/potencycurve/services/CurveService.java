package com.logap.potencycurve.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logap.potencycurve.entities.Curve;
import com.logap.potencycurve.repositories.CurveRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class CurveService {

	@Autowired
	private CurveRepository curveRepository;
	
	public List<Curve> findAll() {
		return curveRepository.findAll();
	}
	
	//TODO read csv
	public List<String[]> readCsv() {
		ClassLoader classLoader = getClass().getClassLoader();
				
		try (CSVReader reader = new CSVReader(new FileReader(classLoader.getResource("static/Abr-2017-curva-potencia-windbox.csv").getFile()))) {
		      List<String[]> r = reader.readAll();
		      r.forEach(x -> System.out.println(Arrays.toString(x)));
		      return r;
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//TODO findById()
}
