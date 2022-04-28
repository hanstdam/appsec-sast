package com.sonatype.infosec.owasp.a01;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;

import com.sonatype.infosec.owasp.a01.exceptions.NotFoundException;
import com.sonatype.infosec.owasp.a01.models.Profile;
import com.sonatype.infosec.owasp.a01.enumerations.ApiErrorCode;

@RestController
public class ProfileController {

	@RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Profile> getProfile(@RequestParam Integer id) throws NotFoundException {
		HashMap<Integer, Profile> map = new HashMap<>();
		map.put(1, new Profile("Hans", 5, "111-222-333"));
		map.put(2, new Profile("Long", 6, "444-555-666"));
		map.put(10, new Profile("AdminMike", 7, "777-888-999"));

		if (map.containsKey(id)) {
			return new ResponseEntity<Profile>(map.get(id), HttpStatus.OK);
		}
		
		throw new NotFoundException(ApiErrorCode.PROFILE_ENTITY_NOT_FOUND, "Profile entity not found");
	}
}
