package com.concretepage.service;

import java.util.List;

import com.concretepage.entity.Person;

public interface IPersonService {
     public List<Person> getAllPersons();
     //public List<Person> getPersonShirts();
     public List<?> getPersonShirts();
}
