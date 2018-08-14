package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.online.CompetitionsDefinition;
import pl.jelenigora.mks.dao.CompetitionsDaoInterface;

@RestController
public class UpdateExistingCompetitions {
	
	@Autowired
	@Qualifier("competitionsDao")
	public CompetitionsDaoInterface dao;

	@RequestMapping(value = "/updateComps", method=RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> update(@RequestBody CompetitionsDefinition def) {
	
		dao.deleteCompetitions(def.competitionsName);
		dao.addCompetitions(CompetitionsDb.fromCompetitionsDef(def));
		
		ResponseEntity<String> resp = new ResponseEntity<String>(new String("test_ążźćłó"), HttpStatus.OK);
		return resp;
		
	}
}
