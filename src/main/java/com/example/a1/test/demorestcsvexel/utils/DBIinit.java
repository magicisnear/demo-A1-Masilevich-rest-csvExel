package com.example.a1.test.demorestcsvexel.utils;

import com.example.a1.test.demorestcsvexel.repository.ReadPostingsModelsRepository;
import com.example.a1.test.demorestcsvexel.service.ReadAndExportCsvFileService;
import com.example.a1.test.demorestcsvexel.service.readPostingsModelsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBIinit {

    final ReadAndExportCsvFileService readAndExportCsvFileService;

    final
    ReadPostingsModelsRepository readPostingsModelsRepository;

    final
    readPostingsModelsService readPostingsModelsService;

    @Autowired
    public DBIinit(ReadAndExportCsvFileService readAndExportCsvFileService, ReadPostingsModelsRepository readPostingsModelsRepository, readPostingsModelsService readPostingsModelsService) {
        this.readAndExportCsvFileService = readAndExportCsvFileService;
        this.readPostingsModelsRepository = readPostingsModelsRepository;
        this.readPostingsModelsService = readPostingsModelsService;
    }

    @PostConstruct
    private void postConstruct(){
        readAndExportCsvFileService.readLoginsCsvFileAndAddToDatabase
                ("src/main/resources/csv/logins.csv");
        readAndExportCsvFileService.readPostingscsvfileandaddtodatabase
                ("src/main/resources/csv/postings.csv");
        System.out.println(readPostingsModelsRepository.findByAppAccountNameAndIsActive().toString());
        readPostingsModelsService.findAllByListOfIdAndSetActive(
                readPostingsModelsRepository.findByAppAccountNameAndIsActive());
    }


}
