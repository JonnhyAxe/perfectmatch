package com.perfectmatch.persistence.model.mongo;


import org.springframework.data.mongodb.core.mapping.Document;

import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.model.NameableEntity;
import com.perfectmatch.persistence.model.Music;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 *
 * This class represents an Music to sample from
 *
 */
@Getter
@Setter
@ToString
@Document(collection = "Music")
public class MongoMusic extends Music implements NameableEntity, ByArtistQueryable {

    /**
     *
     */
    private static final long serialVersionUID = -6021901171439734300L;

    



}
