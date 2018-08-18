package pl.jeleniagora.mks.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.jeleniagora.mks.types.model.CmpsToCompetitionMappingDb;
import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMapping;

public interface CmpsToCompetitionMappingDbRepository extends Repository<CmpsToCompetitionMappingDb, Integer> {

	public List<CmpsToCompetitionMappingDb> findByCmpsName(String name);
}
