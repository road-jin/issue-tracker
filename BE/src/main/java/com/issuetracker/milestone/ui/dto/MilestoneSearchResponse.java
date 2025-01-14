package com.issuetracker.milestone.ui.dto;

import com.issuetracker.milestone.application.dto.MilestoneSearchInformation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class MilestoneSearchResponse {

	private String title;

	public static MilestoneSearchResponse from(MilestoneSearchInformation milestone) {
		return new MilestoneSearchResponse(
			milestone.getTitle()
		);
	}
}
