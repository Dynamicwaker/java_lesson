package com.dynamic.interview.proxy.demotwo;

import java.util.List;

/**
 * @author xinghuajian
 * @description 目标接口
 * @date 2019/10/21 13:57
 */
public interface PersonDao {

    void savePerson();

    void updatePerson();

    void deletePerson();

    List<Person> getPerson();

}
