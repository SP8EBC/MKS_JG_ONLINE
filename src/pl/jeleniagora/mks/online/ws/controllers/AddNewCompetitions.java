package pl.jeleniagora.mks.online.ws.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.jeleniagora.mks.types.online.CompetitionsDefinition;

@RestController
public class AddNewCompetitions {
	
	@RequestMapping("/addComps")
	public ResponseEntity<?> add(@RequestBody CompetitionsDefinition def) {
		return null;
		
	}

}
