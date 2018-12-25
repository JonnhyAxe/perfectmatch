package com.perfectmatch.web.services.impl;

import java.util.Objects;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.web.services.SampleMatchService;

/**
 *
 * Expose web services for Match Entity
 *
 */
@Service
public class SampleMatchServiceBean extends AbstractRawService<Match>
    implements SampleMatchService {

  @Autowired private SampleMatchRepository dao;

  /*
   * (non-Javadoc)
   *
   * @see
   * com.perfectmatch.common.persistence.srvices.AbstractRawService#getDao()
   */
  @Override
  protected SampleMatchRepository getDao() {

    return this.dao;
  }

  @Override
  public boolean contains(Match newMatch) {
    return Objects.nonNull(dao.findAllBymusicName(newMatch.getMusicNameThis()))
        || Objects.nonNull(dao.findAllBymusicName(newMatch.getMusicNameThat()));
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * com.perfectmatch.common.interfaces.ByNameSearchable#findByName(java.lang.
   * String)
   */
  @Override
  public Match findMatchByName(String name) {
	  //TODO add preconditions name
    String[] musics = name.split(",");
    return this.dao.findMatchByMusics(musics[0], musics[1]);
  }
  
  //implement save method
}
