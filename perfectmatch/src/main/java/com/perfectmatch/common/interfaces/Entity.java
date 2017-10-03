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

import java.io.Serializable;

/**
 * <class description>
 *
 */
public interface Entity extends Serializable {

    Long getId();

    void setId(final Long id);

}
