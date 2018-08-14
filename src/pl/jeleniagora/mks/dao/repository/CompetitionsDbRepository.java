package pl.jeleniagora.mks.dao.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.jeleniagora.mks.types.model.CompetitionsDb;

public interface CompetitionsDbRepository extends Repository<CompetitionsDb, Integer> {

	public List<CompetitionsDb> findByCompetitionsName(String name);

}
