package pl.jeleniagora.mks.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jeleniagora.mks.dao.repository.CompetitionsDbRepository;
import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.online.CompetitionsDefinition;

@Repository
public class CompetitionsDao implements CompetitionsDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Repozytorium spring-data dla łatwego budownia zapytań do bazy danych
	 */
	@Autowired
	CompetitionsDbRepository repo;	
	
	@Override
	@Transactional
	@Deprecated
	public void addCompetitions(CompetitionsDb c) {
				
		em.persist(c);

	}

	@Override
	public Collection<CompetitionsDb> listAllCompetitions() {
		return null;
	}

	@Override
	@Transactional
	public void deleteCompetitions(String name) {
		List<CompetitionsDb> checkedComp = repo.findByCompetitionsName(name);

		if (checkedComp != null && checkedComp.size() > 0)
			em.remove(checkedComp.get(0));
	}

	@Override
	public CompetitionsDb returnCompetitionByName(String name) {
		List<CompetitionsDb> checkedComp = repo.findByCompetitionsName(name);

		if (checkedComp != null && checkedComp.size() > 0)
			return checkedComp.get(0);
		else return null;
	}

	@Override
	public void addCompetitions(CompetitionsDefinition c) {
		
	}

}
