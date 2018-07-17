package com.developer.angularjs_oracle.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.developer.angularjs_oracle.dao.UserDao;
import com.developer.angularjs_oracle.dto.User;


@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);
	}

	@Override
	public User getByParam(String param, String value) {
		String query="FROM User WHERE "+ param +" =:param";
		try {
			return sessionFactory.getCurrentSession()
								 .createQuery(query,User.class)
								 .setParameter("param", value)
								 .getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
