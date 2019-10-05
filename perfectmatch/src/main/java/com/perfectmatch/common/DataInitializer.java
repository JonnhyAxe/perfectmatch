package com.perfectmatch.common;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.perfectmatch.common.model.Role;
import com.perfectmatch.persistence.dao.UserRepository;
import com.perfectmatch.persistence.model.User;

/** Store initial users and books in mongodb. */
@Component
public class DataInitializer implements CommandLineRunner {

  public static final UUID WAYNE_USER_IDENTIFIER =
      UUID.fromString("c47641ee-e63c-4c13-8cd2-1c2490aee0b3");
  public static final UUID BANNER_USER_IDENTIFIER =
      UUID.fromString("69c10574-9064-40e4-85bd-5c68547f3f48");
  public static final UUID SERVICE_USER_IDENTIFIER =
      UUID.fromString("2cdd02c8-4fc0-4dc0-8e6a-00eeb2fa7c94");

  public static final UUID CURATOR_IDENTIFIER =
      UUID.fromString("40c5ad0d-41f7-494b-8157-33fad16012aa");
  public static final UUID ADMIN_IDENTIFIER =
      UUID.fromString("0d2c04f1-e25f-41b5-b4cd-3566a081200f");

  public static final UUID BOOK_CLEAN_CODE_IDENTIFIER =
      UUID.fromString("f9bf70d6-e56d-4cab-be6b-294cd05f599f");
  public static final UUID BOOK_CLOUD_NATIVE_IDENTIFIER =
      UUID.fromString("3038627d-627e-448d-8422-0a5705c9e8f1");
  public static final UUID BOOK_SPRING_ACTION_IDENTIFIER =
      UUID.fromString("081314cb-4abf-43e5-9b38-7d7261edb10d");
  public static final UUID BOOK_DEVOPS_IDENTIFIER =
      UUID.fromString("02c3d1fb-ca32-46bd-818f-704012b3fe9c");

  private final UserRepository userRepository;

  @Autowired
  public DataInitializer(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(String... args) {
    createUsers();
  }

  @Transactional
  void createUsers() {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    logger.info("Creating users with LIBRARY_USER, LIBRARY_CURATOR and LIBRARY_ADMIN roles...");
    List<User> userList = Stream
        .of(new User(SERVICE_USER_IDENTIFIER, "service-account-library-client@placeholder.org",
            "n/a", "n/a", Collections.singletonList("USER")),
            new User(WAYNE_USER_IDENTIFIER, "bruce.wayne@example.com", "Bruce", "Wayne",
                Collections.singletonList(Role.LIBRARY_USER.name())),
            new User(BANNER_USER_IDENTIFIER, "bruce.banner@example.com", "Bruce", "Banner",
                Collections.singletonList(Role.LIBRARY_USER.name())),
            new User(CURATOR_IDENTIFIER, "peter.parker@example.com", "Peter", "Parker",
                Collections.singletonList(Role.LIBRARY_CURATOR.name())),
            new User(ADMIN_IDENTIFIER, "clark.kent@example.com", "Clark", "Kent",
                Collections.singletonList(Role.LIBRARY_ADMIN.name())),
            new User(ADMIN_IDENTIFIER, "joao.machado@example.com", "joao", "machado",
                Collections.singletonList(Role.LIBRARY_ADMIN.name())))
        .map(userRepository::save).collect(Collectors.toList());
    logger.info("Created {} users", userList.size());
  }
}
