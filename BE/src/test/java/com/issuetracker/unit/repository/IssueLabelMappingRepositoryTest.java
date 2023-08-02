package com.issuetracker.unit.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.issuetracker.issue.domain.IssueLabelMapping;
import com.issuetracker.issue.infrastrucure.IssueLabelMappingRepository;
import com.issuetracker.util.DatabaseInitialization;
import com.issuetracker.util.RepositoryTest;

@RepositoryTest
class IssueLabelMappingRepositoryTest {

	private IssueLabelMappingRepository issueLabelMappingRepository;
	private DatabaseInitialization databaseInitialization;

	@Autowired
	public IssueLabelMappingRepositoryTest(JdbcTemplate jdbcTemplate) {
		this.issueLabelMappingRepository = new IssueLabelMappingRepository(jdbcTemplate);
		this.databaseInitialization = new DatabaseInitialization(jdbcTemplate);
	}

	@BeforeEach
	void setUp() {
		databaseInitialization.initialization();
		databaseInitialization.loadData();
	}

	@Test
	void 여러_개의_이슈와_라벨을_매핑한_정보를_생성할_수_있다() {
		// given
		List<IssueLabelMapping> issueLabelMappings = List.of(
			IssueLabelMapping.builder().issueId(1L).labelId(1L).build(),
			IssueLabelMapping.builder().issueId(1L).labelId(2L).build(),
			IssueLabelMapping.builder().issueId(1L).labelId(3L).build()
		);

		// when
		int[] actual = issueLabelMappingRepository.saveAll(issueLabelMappings);

		// then
		assertThat(actual).containsExactly(1, 1, 1);
	}
}
