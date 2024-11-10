package com.ai.be.domains.user.repository;

import com.ai.be.domains.user.dto.PhoneDto;
import com.ai.be.domains.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(value = "{ '_id': ?0 }", fields = "{ 'phone': 1, '_id': 0 }")
    Optional<PhoneDto> findPhoneOptionalByUserId(String userId);
    Optional<User> findByPhone(String phone);
}
