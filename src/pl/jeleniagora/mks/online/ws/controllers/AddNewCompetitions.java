package pl.jeleniagora.mks.online.ws.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.online.CompetitionsDefinition;

@RestController
public class AddNewCompetitions {
	
	@RequestMapping(value = "/addComps", method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> add(@RequestBody CompetitionsDefinition def) {
		ResponseEntity<String> resp = new ResponseEntity<String>(new String("test_ążźćłó"), HttpStatus.CREATED);
		return resp;
		
	}

}
