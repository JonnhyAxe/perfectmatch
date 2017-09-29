package com.perfectmatch.perfectmatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfectmatch.perfectmatch.persistence.model.Sample;


public interface SampleRepository extends JpaRepository<Sample, String> {

}
