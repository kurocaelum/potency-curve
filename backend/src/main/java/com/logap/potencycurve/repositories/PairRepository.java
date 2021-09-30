package com.logap.potencycurve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logap.potencycurve.entities.Pair;

public interface PairRepository extends JpaRepository<Pair, Long> {

}
