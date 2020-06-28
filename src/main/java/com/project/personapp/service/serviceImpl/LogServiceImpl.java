package com.project.personapp.service.serviceImpl;

import com.project.personapp.model.Log;
import com.project.personapp.model.Person;
import com.project.personapp.repository.LogRepository;
import com.project.personapp.service.LogService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public Log save(Log log) {
        return logRepository.save(log);
    }

    public Log makingLog(HttpServletRequest request) {
        Log log = new Log();

        log.setCreated(LocalDateTime.now());
        log.setEndPoint(request.getRequestURL().toString());
        log.setRemoteAddress(request.getLocalAddr());
        log.setRequestMethod(request.getMethod());

        return log;
    }

    public Log makingLog(HttpServletRequest request, Person person) {
        Log log = new Log();

        log.setCreated(LocalDateTime.now());
        log.setEndPoint(request.getRequestURL().toString());
        log.setRemoteAddress(request.getLocalAddr());

        JSONObject obj = new JSONObject(person);
        log.setBodyJson(obj.toString());

        log.setRequestMethod(request.getMethod());

        return log;
    }

}
