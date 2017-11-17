package org.readingmonitor.users.repository;

import org.readingmonitor.users.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.lang.String;

public interface UserRepository extends MongoRepository<User, String>{
	User findByEmail(String email);
	User findByEmailAndPassword(String email,String password);
}
