package pl.jeleniagora.mks.dao;

import java.util.Vector;

import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMapping;

public interface CompetitionMappingDaoInterface {

	public void deleteAllMappingsForCompetitions(String name);
	public void addMappings(CompetitionsToCompetitionMapping mapping);
}
