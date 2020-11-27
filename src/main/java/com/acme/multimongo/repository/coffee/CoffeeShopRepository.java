package com.acme.multimongo.repository.coffee;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author Visweshwar Ganesh
 * @Created 11/22/2020 - 3:25 PM
 */
public interface CoffeeShopRepository extends ReactiveMongoRepository<ShopEntity,String> {
}
