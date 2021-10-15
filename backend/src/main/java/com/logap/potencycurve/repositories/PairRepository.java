package com.logap.potencycurve.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.logap.potencycurve.entities.Pair;

public interface PairRepository extends JpaRepository<Pair, Long> {

	@Query("SELECT pair FROM Pair pair WHERE pair.curve.id = :curveId")
	List<Pair> findAllFromId(@Param("curveId") Long curveId);
}
