package com.perfectmatch.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfectmatch.persistence.model.Sample;


public interface SampleRepository extends JpaRepository<Sample, String> {

}
