package com.dynamic.interview.proxy.demotwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/21 13:59
 */
public class PersonDaoImpl implements PersonDao {

    @Override
    public void savePerson() {
        System.out.println("save Person");
    }

    @Override
    public void updatePerson() {
        System.out.println("update Person");
    }

    @Override
    public void deletePerson() {
        System.out.println("delete Person");
    }

    @Override
    public List<Person> getPerson() {
        Person person = new Person();
        person.setPid(1L);
        person.setName("aaa");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        for (Person personTmep : personList) {
            System.out.println(personTmep.getName());
        }
        return personList;
    }

}
