package com.priority.assessment.priority;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/priority")
public class PriorityController {

	@Autowired
	PriorityService priorityService;
	
	@PostMapping("/lifearea/add")
	public ResponseEntity<Map> addLifeArea(@RequestBody Map<String, Object> payload) {

		Map hm = new HashMap();
		try {
			hm.put("status", "Success");
			hm.put("statusCode", "S");
			hm.put("result", priorityService.addLifeArea(payload));

			return new ResponseEntity<Map>(hm, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Map>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/lifearea/list")
	public ResponseEntity<Map> areaList() {

		Map hm = new HashMap();
		hm.put("status", "Success");
		hm.put("statusCode", "S");
		hm.put("result", priorityService.areaList());

		return new ResponseEntity<Map>(hm, HttpStatus.OK);
	}
	
	@PostMapping("/rating/add")
	public ResponseEntity<Map> addUserRatings(@RequestBody Map<String, Object> payload) {

		Map hm = new HashMap();
		try {
			hm.put("status", "Success");
			hm.put("statusCode", "S");
			hm.put("result", priorityService.addUserRatings(payload));

			return new ResponseEntity<Map>(hm, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Map>(hm, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
