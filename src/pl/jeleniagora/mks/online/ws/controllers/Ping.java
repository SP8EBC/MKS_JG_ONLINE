package pl.jeleniagora.mks.online.ws.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

	@RequestMapping("/ping")
	public String ping(@RequestParam(value="echo")String echo) {
		return echo;
	}
}
