package org.promytheus.koino.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {
	
	@GetMapping
	public Map<String, String> getVersion() {

        Map<String, String> response = new HashMap<>();

        response.put("application", "koino-service");
        response.put("version", "0.0.1");
        
		return response;
    }
}
