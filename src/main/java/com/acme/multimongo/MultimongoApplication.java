package com.acme.multimongo;

import com.acme.multimongo.repository.burger.BurgerStoreRepository;
import com.acme.multimongo.repository.burger.StoreEntity;
import com.acme.multimongo.repository.coffee.CoffeeShopRepository;
import com.acme.multimongo.repository.coffee.ShopEntity;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableWebFlux
public class MultimongoApplication implements CommandLineRunner {

	@Autowired
	private BurgerStoreRepository burgerStoreRepository;
	@Autowired
	private CoffeeShopRepository coffeeShopRepository;



	public static void main(String[] args) {
		SpringApplication.run(MultimongoApplication.class, args);
	}

	@Override
	public void run(String ... args)  {
		Mono<List<StoreEntity>> storeList = this.testStore();
		Mono<List<ShopEntity>> cafeList = this.testCafe();

		storeList.then(cafeList).subscribe();
	}

	protected Mono<List<StoreEntity>> testStore(){
		Mono storeDeleteMono = this.burgerStoreRepository.deleteAll();


		Mono<List<StoreEntity>> rsp = storeDeleteMono
				.thenMany(
						Flux.just("BK","MCD","FG")
								.map(name -> new StoreEntity(name,new Random().nextInt()%10))
								.flatMap(burgerStoreRepository::save)
				).thenMany(burgerStoreRepository.findAll())
				.collectList();

		return rsp;


	}
	protected Mono<List<ShopEntity>> testCafe(){
		Mono shopDeleteMono = this.coffeeShopRepository.deleteAll();


		return shopDeleteMono
				.thenMany(
						Flux.just("SB","DD","TH")
								.map(name -> new ShopEntity(name,new Random().nextInt()%10))
								.flatMap(coffeeShopRepository::save)
				).thenMany(coffeeShopRepository.findAll())
				.collectList();
	}


}
