package com.example.a1.test.demorestcsvexel.service;

import com.example.a1.test.demorestcsvexel.model.Logins;
import com.example.a1.test.demorestcsvexel.model.Postings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class ReadAndExportCsvFileServiceImpl implements ReadAndExportCsvFileService {

    final readPostingsModelsService readPostingsModelsService;
    final readLoginsModelsService readLoginsModelsService;

    @Autowired
    public ReadAndExportCsvFileServiceImpl(readPostingsModelsService readPostingsModelsService, readLoginsModelsService readLoginsModelsService) {
        this.readPostingsModelsService = readPostingsModelsService;
        this.readLoginsModelsService = readLoginsModelsService;
    }

    @Override
    public void readLoginsCsvFileAndAddToDatabase(String path) {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path
                    , StandardCharsets.UTF_8));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] loginCell = line.split(splitBy);
                Logins logins = new Logins(loginCell[0].trim(),
                        loginCell[1].trim(),
                        Boolean.parseBoolean(loginCell[2].trim()),
                        loginCell[3].trim(),
                        loginCell[4].trim());
                readLoginsModelsService.saveOrUpdate(logins);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void readPostingscsvfileandaddtodatabase(String path) {
        String line = "";
        String splitBy = ";";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path
                    , StandardCharsets.UTF_8));
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                String[] postingCell = line.split(splitBy);
                Postings postings = new Postings(Long.parseLong(postingCell[0].trim()),
                        Long.parseLong(postingCell[1].trim()),
                        new SimpleDateFormat("dd.MM.yyyy").parse(postingCell[2].trim()),
                        new SimpleDateFormat("dd.MM.yyyy").parse(postingCell[3].trim()),
                        postingCell[4].trim(),
                        Integer.parseInt(postingCell[5].trim()),
                        postingCell[6].trim(),
                        Double.parseDouble(postingCell[7].trim().replaceAll(",",".")),
                        postingCell[8].trim(),
                        postingCell[9].trim());
                postings.setAuthorized_deliveries(false);
                readPostingsModelsService.saveOrUpdate(postings);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

