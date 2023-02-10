package com.creamcheese.crackers.domain.Account.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", updatable = false)
	private Integer id;


	@NotNull(message = "아이디은 필수입니다.")
	private String loginId;

	@NotNull(message = "닉네임은 필수입니다. ")
	private String nickname;

	@NotNull(message = "비밀번호는 필수입니다.")
	private String encodedPassword;

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
