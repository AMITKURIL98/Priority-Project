package com.priority.assessment.priority;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriorityServiceImpl implements PriorityService {
	
	@Autowired
	PriorityDAO priorityDAO;
	
	@Override
	public Object addLifeArea(Map<String, Object> payload) {

		//	Check if the user adding the area of life is an Admin
		if(priorityDAO.isAdmin(payload)) {
			return priorityDAO.addLifeArea(payload);
		} else {
			return "Only Admin can add an Area of Life";
		}
	}

	@Override
	public Object areaList() {

		return priorityDAO.areaList();
	}

	@Override
	public Object addUserRatings(Map<String, Object> payload) {
 
		Object result = null;
		int priority = Integer.parseInt(String.valueOf(payload.get("priorityRating")));
		int satisfaction = Integer.parseInt(String.valueOf(payload.get("satisfactionRating")));
		
		//	Check if priority and satisfaction ratings lie within scale of 1 to 5
		if(priority >= 1 && priority <= 5) {
			if(satisfaction >= 1 && satisfaction <= 5) {
				result = priorityDAO.addUserRatings(payload); 
			}
		} else {
			result = "Rating scale is wrong, it should be in scale of 1 to 5 !!";
		}
		return result;
	}

}
