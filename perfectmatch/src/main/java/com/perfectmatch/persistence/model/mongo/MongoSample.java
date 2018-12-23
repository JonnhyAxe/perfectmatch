package com.perfectmatch.persistence.model.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import com.perfectmatch.common.model.NameableEntity;
import com.perfectmatch.persistence.model.Sample;

/**
 * This class represents an Sample of one specific music
 *
 */
@Document(collection = "Sample")
public class MongoSample extends Sample implements NameableEntity {

  /**
   *
   */
  private static final long serialVersionUID = -4491810249031763816L;
}
