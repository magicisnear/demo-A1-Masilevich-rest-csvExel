package com.example.a1.test.demorestcsvexel.repository;

import com.example.a1.test.demorestcsvexel.model.Postings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.swing.text.StyledEditorKit;
import java.util.Date;
import java.util.List;

@Repository
public interface ReadPostingsModelsRepository extends JpaRepository<Postings, Long> {
    @Query(nativeQuery = true, value = "select postings.id from postings inner join logins" +
            "            on postings.user_name = logins.app_account_name where is_active=true")
    public List<Long> findByAppAccountNameAndIsActive();

    @Query("select p from Postings p where p.PstngDate between ?1 and ?2")
    List<Postings> findByPstngDateBetween(@Nullable Date PstngDateStart, @Nullable Date PstngDateEnd);

    @Query("select p from Postings p where p.PstngDate between ?1 and ?2 and p.Authorized_deliveries = ?3")
    List<Postings> findByPstngDateBetweenAndAuthorized_deliveriesIsTrue(Date PstngDateStart
            , Date PstngDateEnd, Boolean authorizedDelievery);




}
