package net.loanmanagement.repository;

import net.loanmanagement.model.UserAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserActionRepository extends JpaRepository<UserAction, Long> {
    Optional<UserAction> findById(Long Id);
}
