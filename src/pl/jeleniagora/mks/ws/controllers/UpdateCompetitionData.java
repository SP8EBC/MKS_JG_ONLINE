package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.online.CompetitionData;
import pl.jelenigora.mks.dao.CompetitionDataDao;
import pl.jelenigora.mks.dao.CompetitionDataDaoInterface;

@RestController
public class UpdateCompetitionData {
	
	@Autowired
	@Qualifier("competitionDataDao")
	CompetitionDataDaoInterface dao;
	
	@RequestMapping(value = "/updateCmpData/{$1}", method=RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> update(@RequestBody CompetitionData data, @PathVariable("$1") long id) {
		dao.addCompetitionData(data);
		ResponseEntity<String> resp = new ResponseEntity<String>(new String("test_ążźćłó"), HttpStatus.OK);
		return resp;
	}

}
