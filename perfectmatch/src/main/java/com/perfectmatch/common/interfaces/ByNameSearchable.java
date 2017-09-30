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


/**
 * This interface is used by the business logic as the name 'Searchable' (rather
 * than Queryable) name implies
 *
 */
public interface ByNameSearchable<T extends ByNameQueryable> {

    T findByName(final String name);
}
