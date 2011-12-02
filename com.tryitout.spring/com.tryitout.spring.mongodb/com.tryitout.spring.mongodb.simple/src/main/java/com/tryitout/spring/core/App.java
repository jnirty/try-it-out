package com.tryitout.spring.core;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.tryitout.spring.config.SpringMongoConfig;
import com.tryitout.spring.user.User;

public class App {
	private static final Logger logger = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		// For XML
		// ApplicationContext ctx = new
		// GenericXmlApplicationContext("mongo-config.xml");

		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		User user = new User("1001", "yong", "mook kim", 30);

		// save
		mongoOperation.save(user);

		// find
		User savedUser = mongoOperation.findOne(new Query(Criteria.where("id").is("1001")), User.class);

		logger.info("savedUser : " + savedUser);

		// update
		mongoOperation.updateFirst(new Query(Criteria.where("firstname").is("yong")), Update.update("age", 35), User.class);

		// find
		User updatedUser = mongoOperation.findOne(new Query(Criteria.where("id").is("1001")), User.class);

		logger.info("updatedUser : " + updatedUser);

		// Check that deletion worked
	    List<User> people =  mongoOperation.findAll(User.class);
	    
	    logger.info("Number of people = : " + people.size());
	    
		// delete by filter
		mongoOperation.remove(new Query(Criteria.where("id").is("1001")), User.class);
		

	}

}
