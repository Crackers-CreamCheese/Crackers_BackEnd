package com.creamcheese.crackers.domain.Account.entity;

import com.creamcheese.crackers.domain.Workspace.entity.Workspace;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", updatable = false)
	private Integer id;

	@NotNull(message = "아이디는 필수입니다.")
	private String loginId;

	@NotNull(message = "닉네임은 필수입니다. ")
	private String nickname;

	@NotNull(message = "비밀번호는 필수입니다.")
	private String encodedPassword;

	@OneToMany(mappedBy = "account")
	private List<Workspace>  workspaces = new ArrayList<>();

	@Builder
	public Account(String loginId, String nickname, String encodedPassword) {
		this.loginId = loginId;
		this.nickname = nickname;
		this.encodedPassword = encodedPassword;
	}

	public void updateAccount(String nickname){
		this.nickname = nickname;
	}
}
