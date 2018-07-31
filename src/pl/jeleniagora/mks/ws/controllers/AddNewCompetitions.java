package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.model.CompetitionsDb;
import pl.jeleniagora.mks.types.online.CompetitionsDefinition;
import pl.jelenigora.mks.dao.CompetitionsDao;

@RestController
public class AddNewCompetitions {
	
	@Autowired
	CompetitionsDao dao;
	
	@RequestMapping(value = "/addComps", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> add(@RequestBody CompetitionsDefinition def) {
		dao.addCompetitions(CompetitionsDb.fromCompetitionsDef(def));
		ResponseEntity<String> resp = new ResponseEntity<String>(new String("test_ążźćłó"), HttpStatus.CREATED);
		return resp;
		
	}

}
