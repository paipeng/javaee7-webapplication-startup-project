package com.paipeng.jpa.util;

import javax.enterprise.inject.Produces;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Only activate this producer if EntityManager is not yet available
 *
 */
public class EntityManagerProducer {
	@PersistenceContext
	private EntityManager entityManager;

	@Produces
	public EntityManager createEntityManager() throws NamingException {
		// entityManager will be injected when container managed persistence
		// is available
		if (entityManager != null) {
			return entityManager;
		}

		return entityManager;
	}

}
