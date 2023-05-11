package com.priority.assessment.priority;

import java.util.Map;

public interface PriorityService {

	Object addLifeArea(Map<String, Object> payload);

	Object areaList();

	Object addUserRatings(Map<String, Object> payload);
	
}
