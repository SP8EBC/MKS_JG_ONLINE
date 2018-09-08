package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.dao.CompetitionsDao;
import pl.jeleniagora.mks.dao.CompetitionsDaoInterface;
import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.online.CompetitionsDefinition;

@RestController
public class AddNewCompetitions {
	
	@Autowired
	@Qualifier("competitionsDao")
	public CompetitionsDaoInterface dao;
	
	@RequestMapping(value = "/addComps", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> add(@RequestBody CompetitionsDefinition def) {
		ResponseEntity<String> resp;
		CompetitionsDb fromDb = dao.returnCompetitionByName(def.competitionsName);
		
		if (fromDb != null) {
			resp = new ResponseEntity<String>(new String("ALREADY_CREATED"), HttpStatus.CONFLICT);
			return resp;
		}
		resp = new ResponseEntity<String>(new String("test_ążźćłó"), HttpStatus.CREATED);
		dao.addCompetitions(CompetitionsDb.fromCompetitionsDef(def));
		return resp;
		
	}

}
