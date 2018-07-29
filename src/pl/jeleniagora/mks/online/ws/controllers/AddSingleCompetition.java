package pl.jeleniagora.mks.online.ws.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.online.AddSingleCompetitionReturn;
import pl.jeleniagora.mks.types.online.SingleCompetitionDefinition;

@RestController
public class AddSingleCompetition {

	@RequestMapping(value = "/addCmp", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> add(SingleCompetitionDefinition def) {
		
		AddSingleCompetitionReturn out = new AddSingleCompetitionReturn();
		out.id = 123456;
		out.returnTest = "test";
		
		ResponseEntity<AddSingleCompetitionReturn> resp = new ResponseEntity<AddSingleCompetitionReturn>(out, HttpStatus.CREATED);
		return resp;
		}
}
