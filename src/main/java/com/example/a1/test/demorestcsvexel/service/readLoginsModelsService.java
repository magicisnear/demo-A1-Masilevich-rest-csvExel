package com.example.a1.test.demorestcsvexel.service;

import com.example.a1.test.demorestcsvexel.model.Logins;
import com.example.a1.test.demorestcsvexel.repository.ReadLoginsModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface readLoginsModelsService {
    public List<Logins> getAllLogins();

    public Logins getLoginsById(Long id);

    public void saveOrUpdate(Logins logins);

    public void delete(Long loginsId);

}
