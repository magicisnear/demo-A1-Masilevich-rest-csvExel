package com.example.a1.test.demorestcsvexel.service;

import org.springframework.stereotype.Service;

public interface ReadAndExportCsvFileService {
    public void readLoginsCsvFileAndAddToDatabase(String path);
    public void readPostingscsvfileandaddtodatabase(String path);
}
