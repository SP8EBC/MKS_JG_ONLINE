package pl.jeleniagora.mks.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.online.CompetitionsDefinition;

public interface CompetitionsDaoInterface {

	public void addCompetitions(CompetitionsDefinition c);
	public void addCompetitions(CompetitionsDb c);
	public Collection<CompetitionsDb> listAllCompetitions();
	public CompetitionsDb returnCompetitionByName(String name);
	public void deleteCompetitions(String name);
	
}
