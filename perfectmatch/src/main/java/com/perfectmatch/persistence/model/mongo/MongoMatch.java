package com.perfectmatch.persistence.model.mongo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.perfectmatch.common.model.NameableEntity;
import com.perfectmatch.persistence.model.Match;

/**
 *
 * Represents an match between two samples
 *
 */
@Document(collection = "Match")
public class MongoMatch extends Match implements NameableEntity, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -1382192135218935022L;
}
