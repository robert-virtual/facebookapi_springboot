package com.example.facebookapi.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query(value = "select u.* from customer c inner join users u on u.customer_id = c.id where email = ?1 ",nativeQuery = true)
     User getUserByEmail(String email);
}
