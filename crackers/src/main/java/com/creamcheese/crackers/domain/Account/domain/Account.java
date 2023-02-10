package com.creamcheese.crackers.domain.Account.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", updatable = false)
	private int id;


	@NotNull(message = "아이디은 필수입니다.")
	private String loginId;

	@NotNull(message = "비밀번호는 필수입니다.")
	private String encodedPassword;

	@Builder
	public Account(String userId, String encodedPassword) {
		this.loginId = userId;
		this.encodedPassword = encodedPassword;
	}

	public void updateAccount(String nickname){
		this.loginId = nickname;
	}
}
