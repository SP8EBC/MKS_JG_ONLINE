package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.dao.CompetitionMappingDaoInterface;
import pl.jeleniagora.mks.types.online.CompetitionsToCompetitionMapping;

@RestController
public class UpdateMappings {
	
	@Autowired
	@Qualifier("competitionMappingDao")
	CompetitionMappingDaoInterface dao;

	@RequestMapping(value = "/updateMappings", method=RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> update(@RequestBody CompetitionsToCompetitionMapping def) {
		
		String competitionsName = def.entries.firstElement().competitionsName;
		
		dao.deleteAllMappingsForCompetitions(competitionsName);
		dao.addMappings(def);
		
		return null;
	}
}
