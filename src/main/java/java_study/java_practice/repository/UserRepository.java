package java_study.java_practice.repository;

import java_study.java_practice.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByName(String name);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByNameAndPassword(String name, String password);

    Optional<UserEntity> findByEmail(String email);
}
