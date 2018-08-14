package pl.jeleniagora.mks.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.model.CompetitionsToCompetitionMappingDb;

public interface CompetitionsToCompetitionMappingDbRepository extends Repository<CompetitionsDb, Integer> {

	public List<CompetitionsToCompetitionMappingDb> findByCompetitionsName(String name);
}
