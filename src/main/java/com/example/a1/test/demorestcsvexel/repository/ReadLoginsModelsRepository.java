package com.example.a1.test.demorestcsvexel.repository;

import com.example.a1.test.demorestcsvexel.model.Logins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadLoginsModelsRepository extends JpaRepository<Logins, Long> {

//    которое будет указывать, что User Name (postings.csv) находится
//    в списке AppAccountName (logins.csv) и IsActive
//    в постинг репозитории джойним обе таблицы постинг и логин
//    select from Postings inner join Logins on Postings.UserName = Logins.AppAccountName where IsActive=true;
}
