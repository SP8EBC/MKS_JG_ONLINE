package pl.jelenigora.mks.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMapping;

@Repository
public class CompetitionMappingDao implements CompetitionMappingDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void deleteAllMappingsForCompetitions(String name) {

	}

	@Override
	public void addMappings(CompetitionsToCompetitionMapping mapping) {

	}

}
