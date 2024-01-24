package com.appsdeveloperblog.ws.api.ResourceServer.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

	@GetMapping("/status/check")
	public String status() {
		return "Working...";
	}

	@PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
	//@PreAuthorize("hasAuthority('ROLE_developer')")
	//@Secured("ROLE_developer")
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "Deleted user with id " + id + " and JWT subject " + jwt.getSubject();
	}

}
