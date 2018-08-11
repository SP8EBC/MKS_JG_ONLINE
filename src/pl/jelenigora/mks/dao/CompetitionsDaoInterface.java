package pl.jelenigora.mks.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import pl.jeleniagora.mks.types.model.CompetitionsDb;

public interface CompetitionsDaoInterface {

	public void addCompetitions(CompetitionsDb c);
	public Collection<CompetitionsDb> listAllCompetitions();
	public CompetitionsDb returnCompetitionByName(String name);
	public void deleteCompetitios(CompetitionsDb c);
	
}
