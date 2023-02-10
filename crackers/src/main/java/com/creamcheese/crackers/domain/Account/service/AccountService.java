package com.creamcheese.crackers.domain.Account.service;

import com.creamcheese.crackers.domain.Account.domain.Account;
import com.creamcheese.crackers.domain.Account.dto.AccountUpdateReqDto;
import com.creamcheese.crackers.domain.Account.dto.SignUpReqDto;
import com.creamcheese.crackers.domain.Account.repository.AccountRepository;
import com.creamcheese.crackers.global.exception.CustomException.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository accountRepository;

	//private final BCryptPasswordEncoder passwordEncoder;


	@Transactional //TODO:readOnly 적용
	public Account findById(Integer id) {
		return accountRepository.findById(id)
				.orElseThrow(AccountNotFoundException::new);
	}

	@Transactional//TODO:readOnly 적용
	public boolean isExistedLoginId(String loginId){
		return accountRepository.existsByLoginId(loginId);
	}

	@Transactional
	public int signUp(SignUpReqDto requestDto){
		/*if (isExistedId(requestDto.getAccoutId())){
			//throw new EmailDuplicateException(); TODO: 수정
		}
		//String encodedPassword = encodePassword(requestDto.getPassword());
		//Account account = accountRepository.save(requestDto.toEntity(encodedPassword));*/
		Account account = accountRepository.save(requestDto.toEntity());
		return account.getId();
	}

/*	@Transactional
	public int update(UUID accountId, AccountUpdateReqDto requestDto){
		Account account = findById(accountId);
		account.updateAccount(requestDto.getNickname());
		return account.getId();
	}*/
}
