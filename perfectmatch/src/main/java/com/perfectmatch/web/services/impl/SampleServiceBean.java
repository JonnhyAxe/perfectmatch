package com.perfectmatch.web.services.impl;

import javax.validation.Valid;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;
import com.perfectmatch.web.services.SampleService;

/**
 *
 * Expose web services for Sample Entity
 *
 */
@Service
public class SampleServiceBean extends AbstractRawService<Sample> implements SampleService {

  @Autowired private SampleRepository sampleRepository;

  /*
   * (non-Javadoc)
   *
   * @see
   * com.perfectmatch.common.persistence.srvices.AbstractRawService#getDao()
   */
  @Override
  protected SampleRepository getDao() {

    return this.sampleRepository;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * com.perfectmatch.common.interfaces.ByNameSearchable#findByName(java.lang.
   * String)
   */
  @Override
  public Sample findByName(String name) {

    return this.sampleRepository.findByName(name);
  }

  public Sample save(@Valid Sample resource) {
    return this.sampleRepository.save(resource);
  }
}
