package com.perfectmatch.web.services;

import com.perfectmatch.common.interfaces.IOperations;
import com.perfectmatch.common.services.PersistenceService;
import com.perfectmatch.persistence.model.PerfectMatch;

/**
 * This class aims to expose Match (between Samples) related services for Web
 * Controllers
 *
 */
public interface PerfectMatchService extends PersistenceService<PerfectMatch>, IOperations<PerfectMatch>  {

    PerfectMatch findPerfectMatchByName(String name);
    
    PerfectMatch save( PerfectMatch resource);

}
