package com.example.a1.test.demorestcsvexel.controllers;

import com.example.a1.test.demorestcsvexel.model.Postings;
import com.example.a1.test.demorestcsvexel.service.readPostingsModelsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class ReadAndExportCsvFileController {

    final
    readPostingsModelsServiceImpl readPostingsModelsService;

    @Autowired
    public ReadAndExportCsvFileController(readPostingsModelsServiceImpl readPostingsModelsService) {
        this.readPostingsModelsService = readPostingsModelsService;
    }

    @GetMapping("/api")
    public List<Postings> returnPostingListByDatesAndAuthorizedDeliviery(
            @RequestParam String date1,
                                                                         @RequestParam String date2,
                                                                         @RequestParam (required = false) Boolean AuthorizedDeliviery) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        if (AuthorizedDeliviery == null) {
            try {
                return readPostingsModelsService.findByPstngDateBetween(simpleDateFormat.parse(date1),
                        simpleDateFormat.parse(date2));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            return readPostingsModelsService.findByPstngDateBetweenAndAuthorized_deliveriesIsTrue
                    (simpleDateFormat.parse(date1),
                            simpleDateFormat.parse(date2), AuthorizedDeliviery);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
