package com.HobooProject.demo.Spring.dao.impl;

import com.HobooProject.demo.Spring.dao.CityDAO;
import com.HobooProject.demo.Spring.model.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
@Repository
public class CityDAOImpl implements CityDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<City> getAllCities()  {
        String line="select c from City as c ";
       List cityList = this.sessionFactory.getCurrentSession().createQuery(line).list();
      return cityList;

        }

//    @Override
//    public Long getCityIdbyName(final String name)  {
//        String line = "select id from City  where name = :name";
//        Query query = this.sessionFactory.getCurrentSession().createQuery(line);
//        query.setParameter("name", name);
//        Long cityId=(Long) query.list().get(0);
//
//        return cityId;
//    }

    @Override
    public City getCityById(final long id) {
        String line = "select c from City as c where id = :id";
        Query <City> query = this.sessionFactory.getCurrentSession().createQuery(line,City.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
