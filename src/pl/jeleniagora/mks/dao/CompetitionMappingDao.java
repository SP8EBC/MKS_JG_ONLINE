package pl.jeleniagora.mks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jeleniagora.mks.dao.repository.CmpsToCompetitionMappingDbRepository;
import pl.jeleniagora.mks.types.model.CmpsToCompetitionMappingDb;
import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMapping;
import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMappingEntry;

@Repository
public class CompetitionMappingDao implements CompetitionMappingDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CmpsToCompetitionMappingDbRepository repo;
	
	@Override
	@Transactional
	public void deleteAllMappingsForCompetitions(String name) {
		List <CmpsToCompetitionMappingDb> q = repo.findByCmpsName(name);
		
		q.forEach((CmpsToCompetitionMappingDb e) -> {
			em.remove(e);
		});
	}

	@Override
	@Transactional
	public void addMappings(CompetitionsToCompetitionMapping mapping) {
		mapping.entries.forEach((CompetitionsToCompetitionMappingEntry e) -> {
			CmpsToCompetitionMappingDb db = new CmpsToCompetitionMappingDb();
			
			db.competitionSerialNumber = e.competitionSerialNumber;
			db.cmpsName = e.competitionsName;
			db.competitionTypeName = e.competitionTypeName;
			
			em.persist(db);
		});
	}

}
