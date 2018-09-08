package pl.jeleniagora.mks.dao;

import pl.jeleniagora.mks.types.online.CompetitionData;

public interface CompetitionDataDaoInterface {

	public void addCompetitionData(CompetitionData data);
	public void deleteCompetitionData(long serialNumber);
	public CompetitionData findCompetitionDataBySerialNumber(long serialNumber);
}
