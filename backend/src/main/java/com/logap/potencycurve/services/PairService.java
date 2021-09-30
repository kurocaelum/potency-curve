package com.logap.potencycurve.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.logap.potencycurve.entities.Curve;
import com.logap.potencycurve.entities.Pair;
import com.logap.potencycurve.repositories.PairRepository;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class PairService {
	
	@Autowired
	private PairRepository pairRepository;
	
	public List<Pair> findAll() {
		return pairRepository.findAll();
	}
	
	public List<Pair> saveAll(List<Pair> list) {
		return pairRepository.saveAll(list);
	}
	
	public List<Pair> csvToPairs(MultipartFile file, Curve curve) {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			List<Pair> pairs = new CsvToBeanBuilder<Pair>(reader)
			        .withType(Pair.class)
			        .withSeparator(';')
			        .withSkipLines(1)
			        .build()
			        .parse();
			
			pairs.forEach(pair -> pair.setCurve(curve));
			return pairs;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
