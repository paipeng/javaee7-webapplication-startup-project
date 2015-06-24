package com.paipeng.jpa.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.paipeng.jpa.model.Lotto;

public class LottoService {
	@Inject
    protected EntityManager entityManager;
	
	public List<Lotto> getLottos() {
		Query query = entityManager.createQuery("SELECT l FROM Lotto l");
	    return (List<Lotto>) query.getResultList();
	}
}
