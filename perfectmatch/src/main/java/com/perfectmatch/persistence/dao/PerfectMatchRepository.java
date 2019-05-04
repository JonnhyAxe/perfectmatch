package com.perfectmatch.persistence.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.PerfectMatch;

public interface PerfectMatchRepository
    extends ReactiveCrudRepository<PerfectMatch, String>, ByNameSearchable<PerfectMatch> {
}
