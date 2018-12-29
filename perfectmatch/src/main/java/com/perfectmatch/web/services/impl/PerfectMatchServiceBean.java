package com.perfectmatch.web.services.impl;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.PerfectMatchRepository;
import com.perfectmatch.persistence.model.PerfectMatch;
import com.perfectmatch.web.services.PerfectMatchService;

/**
 *
 * Expose web services for Match Entity
 *
 */
@Service
public class PerfectMatchServiceBean extends AbstractRawService<PerfectMatch>
    implements PerfectMatchService {

  @Autowired private PerfectMatchRepository dao;

  /*
   * (non-Javadoc)
   *
   * @see
   * com.perfectmatch.common.persistence.srvices.AbstractRawService#getDao()
   */
  @Override
  protected PerfectMatchRepository getDao() {

    return this.dao;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * com.perfectmatch.common.interfaces.ByNameSearchable#findByName(java.lang.
   * String)
   */
  @Override
  public PerfectMatch findPerfectMatchByName(String name) {
    Preconditions.checkNotNull(name, "Match name cannot be null");
    return this.getDao().findByName(name);
  }

  @Override
  public PerfectMatch save(PerfectMatch resource) {
	  Preconditions.checkNotNull(resource,  "Perfect Match object cannot be null");
	  return this.getDao().save(resource);
  }
}
