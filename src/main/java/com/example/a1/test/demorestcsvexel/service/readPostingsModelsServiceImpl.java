package com.example.a1.test.demorestcsvexel.service;

import com.example.a1.test.demorestcsvexel.model.Postings;
import com.example.a1.test.demorestcsvexel.repository.ReadPostingsModelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class readPostingsModelsServiceImpl implements readPostingsModelsService {

    final ReadPostingsModelsRepository readPostingsModelsRepository;

    @Autowired
    public readPostingsModelsServiceImpl(ReadPostingsModelsRepository readPostingsModelsRepository) {
        this.readPostingsModelsRepository = readPostingsModelsRepository;
    }

    @Override
    public List<Postings> getAllPostings() {
        return readPostingsModelsRepository.findAll();
    }

    @Override
    public Postings getLoginsById(Long postingsId) {
        return readPostingsModelsRepository.getReferenceById(postingsId);
    }

    @Override
    public void saveOrUpdate(Postings postings) {
        readPostingsModelsRepository.save(postings);
    }

    @Override
    public void delete(Long postingsId) {
        readPostingsModelsRepository.deleteById(postingsId);
    }

    @Override
    public void findAllByListOfIdAndSetActive(List<Long> list) {
        for (Long l : list) {
            Optional<Postings> postings = readPostingsModelsRepository.findById(l);
            if (postings.isPresent()) {
                Postings posting = postings.get();
                posting.setAuthorized_deliveries(true);
                readPostingsModelsRepository.save(posting);
            }
        }
    }

    @Override
    public List<Postings> findByPstngDateBetween(Date PstngDateStart, Date PstngDateEnd) {
        return readPostingsModelsRepository.findByPstngDateBetween(PstngDateStart,PstngDateEnd);
    }

    @Override
    public List<Postings> findByPstngDateBetweenAndAuthorized_deliveriesIsTrue(Date PstngDateStart
            , Date PstngDateEnd, Boolean authorizedDelievery) {
        return readPostingsModelsRepository.findByPstngDateBetweenAndAuthorized_deliveriesIsTrue(PstngDateStart,
                PstngDateEnd, authorizedDelievery);
    }
}
