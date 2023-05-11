package com.priority.assessment.priority;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PriorityDAOImpl implements PriorityDAO {

	private static final String INSERTION_SUCCESS = "Insertion Success";
	private static final String INSERTION_FAILED = "Insertion Failed";
	
	private EntityManager entityManager;

	@Autowired
	public PriorityDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	
	@Override
	public Object addLifeArea(Map<String, Object> payload) {

		Session currentSession = entityManager.unwrap(Session.class);

		StringBuilder msg = new StringBuilder();
		
		try {
			//	Inserting a new area of life
		String queryString = "Insert into life_areas(`area`, `created_by`) values(?,?)";
		
		int inserted = entityManager.createNativeQuery(queryString).setParameter(1, String.valueOf(payload.get("areaName")))
				.setParameter(2, String.valueOf(payload.get("createdBy"))).executeUpdate();
		
		if (inserted == 1) {
			msg = msg.append("Life Area added Successfully");
		} else {
			msg = msg.append(INSERTION_FAILED);
		}
		
		} catch(Exception e) {
			System.out.println(e);
		}
		return msg;
	}
	
	@Override
	public boolean isAdmin(Map<String, Object> payload) {
		Session currentSession = entityManager.unwrap(Session.class);

		//	Query to check if the user is Admin
		String queryString = "SELECT COUNT(*) FROM users u WHERE u.id = " + payload.get("createdBy") + " AND u.is_admin = 1";

		NativeQuery query = currentSession.createNativeQuery(queryString);

		List<Object> result = query.getResultList();
		
		boolean status = false;
		
		if(Integer.parseInt(result.get(0).toString()) > 0) {
			status = true;
		}

		return status;
		
	}


	@Override
	public Object areaList() {

		Session currentSession = entityManager.unwrap(Session.class);

		//	Query to return all available life areas
		String queryString = "SELECT la.area FROM life_areas la where la.is_archived = 0 and la.is_deleted = 0";

		NativeQuery query = currentSession.createNativeQuery(queryString);

		List<Object> result = query.getResultList();
		
		return result;
	}


	@Override
	public Object addUserRatings(Map<String, Object> payload) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);

		StringBuilder msg = new StringBuilder();
		
		try {
			//	Insertion of priority rating with respective user and area
		String queryStringPriority = "Insert into user_priority(`user_id`, `area_id`, `priority`) values(?,?,?)";
		
		int inserted1 = entityManager.createNativeQuery(queryStringPriority).setParameter(1, String.valueOf(payload.get("userId")))
				.setParameter(2, String.valueOf(payload.get("areaId")))
				.setParameter(3, String.valueOf(payload.get("priorityRating"))).executeUpdate();
		
		//		Insertion of satisfaction rating with respective user and area
		String queryStringSatisfaction = "Insert into user_satisfaction(`user_id`, `area_id`, `satisfaction`) values(?,?,?)";
		
		int inserted2 = entityManager.createNativeQuery(queryStringSatisfaction).setParameter(1, String.valueOf(payload.get("userId")))
				.setParameter(2, String.valueOf(payload.get("areaId")))
				.setParameter(3, String.valueOf(payload.get("satisfactionRating"))).executeUpdate();
		
		//	Check if both priority and satisfaction rating inserted
		if (inserted1 * inserted2 == 1) {
			msg = msg.append("Ratings added Successfully");
		} else {
			msg = msg.append("Insertion Failed");
		}
		
		} catch(Exception e) {
			System.out.println(e);
		}
		return msg;
	}
}
