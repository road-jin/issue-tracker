package com.issuetracker.issue.ui.dto;

import java.util.List;

import com.issuetracker.issue.application.dto.IssueSearchInputData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IssueSearchRequest {

	private Boolean isOpen;
	private List<Long> assigneeIds;
	private List<Long> labelIds;
	private Long milestoneId;
	private Long authorId;
	private Boolean isCommentedByMe;

	public IssueSearchInputData toIssueSearchData(Long loginMemberId) { // 여기서 로그인한 유저 아이디 받기
		return new IssueSearchInputData(
			isOpen,
			assigneeIds,
			labelIds,
			milestoneId,
			authorId,
			getCommentAuthorId(loginMemberId)
		);
	}

	private Long getCommentAuthorId(Long loginMemberId) {
		if(isCommentedByMe == null || isCommentedByMe == Boolean.FALSE) {
			return null;
		}

		return loginMemberId;
	}
}
