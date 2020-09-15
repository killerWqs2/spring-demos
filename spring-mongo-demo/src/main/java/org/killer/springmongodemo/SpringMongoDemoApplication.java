package org.killer.springmongodemo;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class SpringMongoDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMongoDemoApplication.class, args);
		MongoTemplate mongo = applicationContext.getBean(MongoTemplate.class);

		test(mongo);
	}

	private static void test(MongoTemplate mongo) {
		// querywarpper 有点怀念啊，，
		List<User> users = mongo.find(new Query(Criteria.where("age").lt(23)).skip(2).limit(2), User.class);

		System.out.println(users);

	}

	@Data
	private static class User {

		private String name;

		private Integer age;

	}

}
