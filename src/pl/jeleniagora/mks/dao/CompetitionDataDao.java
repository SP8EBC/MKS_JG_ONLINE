package pl.jeleniagora.mks.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jeleniagora.mks.dao.repository.CompetitionDataDbRepository;
import pl.jeleniagora.mks.types.model.CompetitionDataDb;
import pl.jeleniagora.mks.types.online.CompetitionData;
import pl.jeleniagora.mks.types.online.CompetitionDataEntry;

@Repository
public class CompetitionDataDao implements CompetitionDataDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CompetitionDataDbRepository repo;
	
	@Override
	@Transactional
	public void addCompetitionData(CompetitionData data) {
		for (CompetitionDataEntry en : data.entry) {
			CompetitionDataDb db = new CompetitionDataDb();
			int i = 0;
			
			db.clubName = en.clubName;
			db.competitionId = data.competitionId;
			db.competitionSerialNumber = data.competitionSerialNumber;
			db.competitorName = en.competitorName;
			db.competitorPartialRank = en.competitorPartialRank;
			db.competitorRank = en.competitorRank;
			db.competitorStartNumber = en.competitorStartNumber;
			db.scoredRunsTimesStr = new String[en.scoredRunsTimesStr.size()];
			for (String s : en.scoredRunsTimesStr) {
				db.scoredRunsTimesStr[i++] = s;
			}
			
			i =0;
			db.trainingRunsTimesStr = new String[en.trainingRunsTimesStr.size()];
			for (String s : en.trainingRunsTimesStr) {
				db.trainingRunsTimesStr[i++] = s;
			}
			//db.scoredRunsTimesStr = en.scoredRunsTimesStr;
			//db.trainingRunsTimesStr = en.trainingRunsTimesStr;
			
			db.birthYear = en.birthYear;
			db.totalScoredTimeStr = en.totalScoredTimeStr;
			
			em.persist(db);
		}
	}

	@Override
	@Transactional
	public void deleteCompetitionData(long serialNumber) {
		List<CompetitionDataDb> q = repo.findByCompetitionSerialNumber(serialNumber);
		

		if (q != null && q.size() > 0) {
//			em.getTransaction().begin();
			q.forEach((CompetitionDataDb elem) -> {
				em.remove(elem);
			});
			//em.getTransaction().commit();
		}
		
	}

	@Override
	public CompetitionData findCompetitionDataBySerialNumber(long serialNumber) {
		return null;
	}

}
