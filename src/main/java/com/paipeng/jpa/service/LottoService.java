package com.paipeng.jpa.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.paipeng.jpa.model.Lotto;

public class LottoService {
	@Inject
    protected EntityManager entityManager;
	
	public List<Lotto> getLottos() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Lotto> query = builder.createQuery(Lotto.class);//); // your Class<T>
		
		Root<Lotto> root = query.from(Lotto.class); // your Class<T>
		query.select(root);
		
		TypedQuery<Lotto> typedQuery = entityManager.createQuery(query);
		//List<Lotto> a = Collections.checkedList(, Lotto.class);
	    return typedQuery.getResultList();
	}
}
