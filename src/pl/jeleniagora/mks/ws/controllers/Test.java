package pl.jeleniagora.mks.ws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.jelenigora.mks.dao.CompetitionsDao;

@Component
public class Test {

//	@Autowired
//	CompetitionsDao dao;
	
	@Autowired
	@Qualifier("competitionsDao")
	CompetitionsDao dao1;
}
