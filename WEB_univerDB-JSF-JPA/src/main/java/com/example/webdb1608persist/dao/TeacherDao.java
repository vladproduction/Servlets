package com.example.webdb1608persist.dao;

import com.example.webdb1608persist.entities.Teacher;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class TeacherDao {
    @PersistenceContext
    private EntityManager em;
    public List<Teacher> findAll(){
        return em.createNamedQuery("Teacher.findAll",Teacher.class)
                .getResultList();
    }

    public Teacher find(int id) {
        return em.find(Teacher.class, id);
    }
}
