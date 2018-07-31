package pl.jelenigora.mks.dao;

import java.util.Collection;

import pl.jeleniagora.mks.types.model.CompetitionsDb;

public interface CompetitionsDaoInterface {

	public void addCompetitions(CompetitionsDb c);
	public Collection<CompetitionsDb> listAllCompetitions();
	public void deleteCompetitios(CompetitionsDb c);
	
}
