package com.acme.multimongo.repository.burger;

import org.reactivestreams.Publisher;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Visweshwar Ganesh
 * @Created 11/22/2020 - 3:25 PM
 */
//@Repository
public interface BurgerStoreRepository extends ReactiveMongoRepository<StoreEntity,String> {
	@Query("{ 'name': ?0 }")
	public Flux<StoreEntity> findAllByName(String name);
	@Query("{ 'name': ?0 }")
	public Flux<StoreEntity> deleteByName(String name);
}
