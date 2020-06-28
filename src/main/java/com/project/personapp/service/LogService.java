package com.project.personapp.service;

import com.project.personapp.model.Log;
import com.project.personapp.model.Person;

import javax.servlet.http.HttpServletRequest;

public interface LogService {
    Log save(Log log);
    Log makingLog(HttpServletRequest request);
    Log makingLog(HttpServletRequest request, Person person);

}
