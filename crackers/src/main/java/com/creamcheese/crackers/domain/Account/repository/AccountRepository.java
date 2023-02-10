package com.creamcheese.crackers.domain.Account.repository;

import com.creamcheese.crackers.domain.Account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	Optional<Account> findById(Integer id);
	Boolean existsByLoginId(String loginId);
}
