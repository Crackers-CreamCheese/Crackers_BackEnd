package com.creamcheese.crackers.domain.Account.dto;

import com.creamcheese.crackers.domain.Account.entity.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountUpdateReqDto {
	private String nickname;

	@Builder
	public AccountUpdateReqDto(String nickname) {
		this.nickname = nickname;
	}

	public Account toEntity() {
		return Account.builder()
				.nickname(this.nickname)
				.build();
	}
}
