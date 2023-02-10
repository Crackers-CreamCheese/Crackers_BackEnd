package com.creamcheese.crackers.domain.Account.dto;

import com.creamcheese.crackers.domain.Account.domain.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpReqDto {
	private String nickname;
	private String password;

	@Builder
	public SignUpReqDto(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}

	public Account toEntity() {
		return Account.builder()
				.encodedPassword(this.password)
				.nickname(this.nickname)
				.build();
	}
}
