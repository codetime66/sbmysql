package com.concretepage.dao;

import com.concretepage.entity.Person;
import java.util.List;

public interface IPersonDAO {

    public List<Person> getAllPersons();
    //public List<Person> getPersonShirts();
    public List<?> getPersonShirts();    
}
