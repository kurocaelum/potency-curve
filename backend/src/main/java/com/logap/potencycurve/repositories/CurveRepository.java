package com.logap.potencycurve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logap.potencycurve.entities.Curve;

public interface CurveRepository extends JpaRepository<Curve, Long> {

}
