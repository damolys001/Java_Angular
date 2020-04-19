package com.net.angular.mongo.repositories;


import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.net.angular.mongo.models.Todo;

@Repository

public interface TodoRepository extends CrudRepository<Todo, String> {

}
//public interface TodoRepository extends MongoRepository<Todo, String> {

//}