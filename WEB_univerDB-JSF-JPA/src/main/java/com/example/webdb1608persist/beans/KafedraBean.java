package com.example.webdb1608persist.beans;

import com.example.webdb1608persist.dao.KafedraDao;
import com.example.webdb1608persist.entities.Kafedra;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Getter
public class KafedraBean implements Serializable {

    @EJB
    private KafedraDao kafedraDao;
    private Kafedra kafedra = new Kafedra();
    private Kafedra selected;

    public List<Kafedra> getKafedraList(){
        return kafedraDao.findAll();
    }

    public void add() {
        kafedraDao.add(kafedra);
        kafedra = new Kafedra();
    }

    public void remove(int id) {
        kafedraDao.remove(id);
    }

    public String showTeachers(int id) {
        selected = kafedraDao.find(id);
        return "teachers_by_kafedra";
    }

    public String edit(int id) {
        selected = kafedraDao.find(id);
        return "update_kafedra";
    }

    public String update() {
        kafedraDao.update(selected);
        selected = null;
        return "index";
    }
}
