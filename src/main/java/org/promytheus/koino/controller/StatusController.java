package org.promytheus.koino.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
	
	@GetMapping("/version")
	public Map<String, String> getVersion() {

        Map<String, String> response = new HashMap<>();

        response.put("version", "0.0.0001");
        
		return response;
    }
}
