package com.creamcheese.crackers.domain.Workspace.controller;


import com.creamcheese.crackers.domain.Account.dto.AccountResDto;
import com.creamcheese.crackers.domain.Account.dto.SignUpReqDto;
import com.creamcheese.crackers.domain.Account.entity.Account;
import com.creamcheese.crackers.domain.Workspace.dto.WorkspaceReqDto;
import com.creamcheese.crackers.domain.Workspace.dto.WorkspaceResDto;
import com.creamcheese.crackers.domain.Workspace.dto.WorkspaceUpdateReqDto;
import com.creamcheese.crackers.domain.Workspace.entity.Workspace;
import com.creamcheese.crackers.domain.Workspace.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/v1/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {
	private final WorkspaceService workspaceService;

	@PostMapping
	public ResponseEntity<WorkspaceResDto> create(@RequestBody @Valid final WorkspaceReqDto requestDto) {
		Workspace workspace = workspaceService.create(requestDto);
		return ResponseEntity.ok()
				.body(new WorkspaceResDto(workspace));
	}

	@PatchMapping("/update")
	public ResponseEntity<WorkspaceResDto> update(@RequestBody final WorkspaceUpdateReqDto requestDto)
	{
		Workspace workspace = workspaceService.update(requestDto);
		return ResponseEntity.ok()
				.body(new WorkspaceResDto(workspace));

	}

	//TODO: 조회

}
