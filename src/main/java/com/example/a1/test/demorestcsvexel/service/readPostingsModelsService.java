package com.example.a1.test.demorestcsvexel.service;

import com.example.a1.test.demorestcsvexel.model.Logins;
import com.example.a1.test.demorestcsvexel.model.Postings;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface readPostingsModelsService {
    public List<Postings> getAllPostings();

    public Postings getLoginsById(Long postingsId);

    public void saveOrUpdate(Postings postings);

    public void delete(Long postingsId);

    public void findAllByListOfIdAndSetActive(List<Long> list);

    List<Postings> findByPstngDateBetween(@Nullable Date PstngDateStart, @Nullable Date PstngDateEnd);

    List<Postings> findByPstngDateBetweenAndAuthorized_deliveriesIsTrue(Date PstngDateStart
            , Date PstngDateEnd, Boolean authorizedDelievery);

}
