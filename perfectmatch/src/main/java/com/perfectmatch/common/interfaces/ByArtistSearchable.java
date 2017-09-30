/*
 * Copyright 2017 by Brisa Inovação e Tecnologia S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Brisa, SA ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Brisa.
 */
package com.perfectmatch.common.interfaces;

import java.util.Set;

/**
 * <class description>
 *
 */
public interface ByArtistSearchable<T extends ByArtistQueryable> {

    Set<T> findByArtist(String name);
}
