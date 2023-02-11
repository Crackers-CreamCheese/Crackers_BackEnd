package com.creamcheese.crackers.domain.Workspace.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "schedule_id", updatable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "workspace_id")
	private Workspace workspace;

	@NotNull(message = "요일을 입력해주세요.")
	private String day;

	@NotNull(message = "시작 시간을 입력해주세요.")
	private Integer startTime;

	@NotNull(message = "종료 시간을 입력해주세요.")
	private Integer endTime;

	@Builder
	public Schedule(String day, Integer startTime, Integer endTime) {
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
}