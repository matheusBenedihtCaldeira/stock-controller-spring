package com.bytewave.stockcontroller.repositories;

import com.bytewave.stockcontroller.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
