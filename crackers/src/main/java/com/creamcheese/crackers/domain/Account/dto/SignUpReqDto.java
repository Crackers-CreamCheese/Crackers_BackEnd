package com.creamcheese.crackers.domain.Account.dto;

import com.creamcheese.crackers.domain.Account.domain.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpReqDto {
	private String loginId;
	private String password;

	@Builder
	public SignUpReqDto( String loginId, String password) {
		this.loginId = loginId;
		this.password = password;
	}

	public Account toEntity() {
		return Account.builder()
				.encodedPassword(this.password)
				.loginId(this.loginId)
				.build();
	}
}
