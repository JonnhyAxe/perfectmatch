package com.perfectmatch.common.interfaces;

/**
 * This interface is used by the business logic as the name 'Searchable' (rather
 * than Queryable) name implies
 *
 */
public interface ByNameSearchable<T extends ByNameQueryable> {

  T findByName(final String name);
}
