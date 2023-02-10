package com.creamcheese.crackers.domain.Account.dto;

import com.creamcheese.crackers.domain.Account.domain.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountResDto {
	private String nickname;

	@Builder
	public AccountResDto(Account account) {
		this.nickname = account.getNickname();
	}
}
