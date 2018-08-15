package pl.jelenigora.mks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jeleniagora.mks.dao.repository.CompetitionsToCompetitionMappingDbRepository;
import pl.jeleniagora.mks.types.model.CompetitionsToCompetitionMappingDb;
import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMapping;
import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMappingEntry;

@Repository
public class CompetitionMappingDao implements CompetitionMappingDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CompetitionsToCompetitionMappingDbRepository repo;
	
	@Override
	@Transactional
	public void deleteAllMappingsForCompetitions(String name) {
		List <CompetitionsToCompetitionMappingDb> q = repo.findByCompetitionsName(name);
		
		q.forEach((CompetitionsToCompetitionMappingDb e) -> {
			em.remove(e);
		});
	}

	@Override
	public void addMappings(CompetitionsToCompetitionMapping mapping) {
		mapping.entries.forEach((CompetitionsToCompetitionMappingEntry e) -> {
			CompetitionsToCompetitionMappingDb db = new CompetitionsToCompetitionMappingDb();
			
			db.competitionSerialNumber = e.competitionSerialNumber;
			db.competitionsName = e.competitionsName;
			
		});
	}

}
