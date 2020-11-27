//package com.acme.multimongo;
//
//import com.acme.multimongo.repository.burger.StoreEntity;
//import com.acme.multimongo.repository.coffee.ShopEntity;
//import com.mongodb.reactivestreams.client.MongoClients;
//import de.flapdoodle.embed.mongo.MongodExecutable;
//import de.flapdoodle.embed.mongo.MongodStarter;
//import de.flapdoodle.embed.mongo.config.IMongodConfig;
//import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
//import de.flapdoodle.embed.mongo.config.Net;
//import de.flapdoodle.embed.mongo.distribution.Version;
//import de.flapdoodle.embed.process.runtime.Network;
//import java.util.List;
//import org.junit.Assert;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//@SpringBootTest
//class MultimongoApplicationTests {
//
//	@Autowired
//	MultimongoApplication multimongoApplication;
//
//	private static final String CONNECTION_STRING = "mongodb://%s:%d";
//
//	protected MongodExecutable mongodExecutable;
//	protected ReactiveMongoTemplate mongoTemplate;
//
//	@AfterEach
//	void clean() {
//		mongodExecutable.stop();
//	}
//
//	@BeforeEach
//	void setup() throws Exception {
//		String ip = "localhost";
//		int port = 27017;
//
//		IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
//				.net(new Net(ip, port, Network.localhostIsIPv6()))
//				.build();
//
//		MongodStarter starter = MongodStarter.getDefaultInstance();
//		mongodExecutable = starter.prepare(mongodConfig);
//		mongodExecutable.start();
//		this.mongoTemplate = new ReactiveMongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)), "test");
//	}
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void processStore_Success() {
//
//		Mono<List<StoreEntity>> data = multimongoApplication.testStore();
//
//		StepVerifier.create(data)
//				.thenConsumeWhile(t -> {
//					Assert.assertTrue(t.size() > 0);
//					Assert.assertEquals(t.get(0).getName(),"BK");
//					return true;
//				})
//				.verifyComplete();
//	}
//	@Test
//	void processCafe_Success() {
//
//		Mono<List<ShopEntity>> data = multimongoApplication.testCafe();
//		StepVerifier.create(data)
//				.thenConsumeWhile(t -> {
//					Assert.assertEquals(t.size(),3);
//					Assert.assertEquals(t.get(0).getName(),"SB");
//					return true;
//				})
//				.verifyComplete();
//	}
//
//}
