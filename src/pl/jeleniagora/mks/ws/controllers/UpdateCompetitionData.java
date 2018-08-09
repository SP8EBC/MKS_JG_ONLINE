package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.online.CompetitionData;
import pl.jelenigora.mks.dao.CompetitionDataDao;

@RestController
public class UpdateCompetitionData {
	
	@Autowired
	@Qualifier("competitionDataDao")
	CompetitionDataDao dao;
	
	@RequestMapping(value = "/updateCmpData/{$1}", method=RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> update(@RequestBody CompetitionData data, @PathVariable("$1") long id) {
		return null;
	}

}
