package com.perfectmatch.persistence.dao;


import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.User;

public interface UserRepository extends MongoRepository<User, String>, ByNameSearchable<User> {

  // // @EntityGraph(attributePaths = "roles")
  Optional<User> findOneByEmail(String email);

  Optional<User> findOneByIdentifier(UUID identifier);

  void deleteUserByIdentifier(UUID identifier);
}
