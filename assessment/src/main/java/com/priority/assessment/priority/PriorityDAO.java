package com.priority.assessment.priority;

import java.util.Map;

public interface PriorityDAO {

	Object addLifeArea(Map<String, Object> payload);

	boolean isAdmin(Map<String, Object> payload);

	Object areaList();

	Object addUserRatings(Map<String, Object> payload);
	
}
