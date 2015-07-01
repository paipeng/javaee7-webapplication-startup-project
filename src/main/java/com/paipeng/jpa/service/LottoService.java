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
		List<Lotto> lottos =  typedQuery.getResultList();
		
		for( Lotto lotto : lottos) {
			lotto.setSum(getSum(lotto));
		}
		
		return lottos;
	}
	
	public Lotto getLastLotto() {
		Lotto lotto = (Lotto) entityManager.createNamedQuery(Lotto.getLastLotto).setMaxResults(1).getSingleResult();
		return lotto;
	}
	
	private int getSum(Lotto lotto) {
		
		return lotto.getZ1() + 
				lotto.getZ2() +
				lotto.getZ3() +
				lotto.getZ4() +
				lotto.getZ5() +
				lotto.getZ6();
	
		/*
		TypedQuery<Integer> query = entityManager.createNamedQuery(Lotto.getSum, Integer.class);
		query.setParameter("lottoId", lotto.getId());
		
		Integer result = query.getSingleResult();
		if (result == null) {
			result = 0;
		}
				
		return result.intValue();
		*/
	}
}
