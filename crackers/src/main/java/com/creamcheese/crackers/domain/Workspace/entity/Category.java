package com.creamcheese.crackers.domain.Workspace.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", updatable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "workspace_id")
	private Workspace workspace;

	@NotNull
	private String name;

	@Builder
	public Category(String name) {
		this.name = name;
	}
}
