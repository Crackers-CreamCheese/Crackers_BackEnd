package com.creamcheese.crackers.domain.Workspace.repository;

import com.creamcheese.crackers.domain.Account.entity.Account;
import com.creamcheese.crackers.domain.Workspace.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {
	@Override
	Optional<Workspace> findById(Integer integer);

	List<Workspace> findByAccount(Account account);

}
