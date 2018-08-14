package pl.jeleniagora.mks.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.jeleniagora.mks.types.model.CompetitionDataDb;

public interface CompetitionDataDbRepository extends Repository<CompetitionDataDb, Integer>{
	
	public List<CompetitionDataDb> findByCompetitionSerialNumber(Long serial);
}
