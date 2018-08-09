package pl.jelenigora.mks.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.jeleniagora.mks.types.model.CompetitionDataDb;
import pl.jeleniagora.mks.types.online.CompetitionData;
import pl.jeleniagora.mks.types.online.CompetitionDataEntry;

@Component
public class CompetitionDataDao implements CompetitionDataDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public void addCompetitionData(CompetitionData data) {
		for (CompetitionDataEntry en : data.entry) {
			CompetitionDataDb db = new CompetitionDataDb();
			
			db.clubName = en.clubName;
			db.competitionId = data.competitionId;
			db.competitionSerialNumber = data.competitionSerialNumber;
			db.competitorName = en.competitorName;
			db.competitorPartialRank = en.competitorPartialRank;
			db.competitorRank = en.competitorRank;
			db.competitorStartNumber = en.competitorStartNumber;
			db.scoredRunsTimesStr = en.scoredRunsTimesStr;
			db.trainingRunsTimesStr = en.trainingRunsTimesStr;
			
			em.persist(db);
		}
	}

	@Override
	public void deleteCompetitionData(long serialNumber) {

	}

	@Override
	public CompetitionData findCompetitionDataBySerialNumber(long serialNumber) {
		return null;
	}

}