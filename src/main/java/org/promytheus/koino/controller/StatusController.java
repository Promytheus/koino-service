package org.promytheus.koino.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/status")
public class ContentController {
	
	@GetMapping("/version")
	@RolesAllowed({ "ROLE_user" })
    public Map<String, String> getVersion() {

        Map<String, String> response = new HashMap<>();

        response.put("version", "0.0.0001");
        
		return response;
    }
}
