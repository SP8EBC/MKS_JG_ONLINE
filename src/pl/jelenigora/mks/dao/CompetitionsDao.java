package pl.jelenigora.mks.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.jeleniagora.mks.dao.repository.CompetitionsDbRepository;
import pl.jeleniagora.mks.types.model.CompetitionsDb;

@Component
public class CompetitionsDao implements CompetitionsDaoInterface {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CompetitionsDbRepository repo;
	
	@Override
	@Transactional
	public void addCompetitions(CompetitionsDb c) {
		em.persist(c);

	}

	@Override
	public Collection<CompetitionsDb> listAllCompetitions() {
		return null;
	}

	@Override
	@Transactional
	public void deleteCompetitios(CompetitionsDb c) {

	}

	@Override
	public CompetitionsDb returnCompetitionByName(String name) {
		return null;
	}

}
