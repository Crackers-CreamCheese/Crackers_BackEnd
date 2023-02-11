package com.creamcheese.crackers.domain.Account.dto;

import com.creamcheese.crackers.domain.Account.entity.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpReqDto {


	private String loginId;

	@NotBlank
	@Length(min = 2, max = 16)
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!.?,])[A-Za-z\\d!.?,]{2,16}$",
			message = "16자 이내의 영문자 및 숫자와 ?,!,., , 특수문자로 입력해주세요.")
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
