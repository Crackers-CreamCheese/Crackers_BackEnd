package com.creamcheese.crackers.domain.Workspace.entity;


import com.creamcheese.crackers.domain.Account.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Workspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workspace_id", updatable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	@OneToMany(mappedBy = "workspace")
	private Category category;

	@OneToMany(mappedBy = "workspace")
	private Schedule schedule;

	@NotNull(message = "시급을 입력해주세요")
	private Integer wage = 9160;

	@NotNull(message = "근무지 이름을 입력해주세요.")
	private String name;

}
