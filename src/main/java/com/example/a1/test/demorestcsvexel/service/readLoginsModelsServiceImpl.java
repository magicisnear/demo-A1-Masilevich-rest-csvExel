package com.example.a1.test.demorestcsvexel.service;

import com.example.a1.test.demorestcsvexel.model.Logins;
import com.example.a1.test.demorestcsvexel.repository.ReadLoginsModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class readLoginsModelsServiceImpl implements readLoginsModelsService {
    final ReadLoginsModelsRepository readLoginsModelsRepository;

    @Autowired
    public readLoginsModelsServiceImpl(ReadLoginsModelsRepository readLoginsModelsRepository) {
        this.readLoginsModelsRepository = readLoginsModelsRepository;
    }

    @Override
    public List<Logins> getAllLogins() {
        return readLoginsModelsRepository.findAll();
    }

    @Override
    public Logins getLoginsById(Long id) {
        return readLoginsModelsRepository.getReferenceById(id);
    }

    @Override
    public void saveOrUpdate(Logins logins) {
        readLoginsModelsRepository.save(logins);
    }

    @Override
    public void delete(Long loginsId) {
        readLoginsModelsRepository.deleteById(loginsId);
    }

}
