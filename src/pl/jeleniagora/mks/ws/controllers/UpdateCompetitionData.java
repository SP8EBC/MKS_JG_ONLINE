package pl.jeleniagora.mks.ws.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.online.CompetitionData;

@RestController
public class UpdateCompetitionData {
	
	@RequestMapping(value = "/updateCmpData", method=RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> update(CompetitionData data) {
		return null;
	}

}
