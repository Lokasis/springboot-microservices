package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {
    Optional<UserAction> findById(Long Id);
}
