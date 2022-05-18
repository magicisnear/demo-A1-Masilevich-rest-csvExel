package com.example.a1.test.demorestcsvexel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Postings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "Mat_Doc")
    Long Mat_Doc;
    @Column(name = "Item")
    Long Item;
    @Column(name = "Doc_Date")
    Date Doc_Date;
    @Column(name = "PstngDate")
    Date PstngDate;
    @Column(name = "MaterialDescription")
    String MaterialDescription;
    @Column(name = "Quantity")
    int Quantity;
    @Column(name = "BUn")
    String BUn;
    @Column(name = "Amount_LC")
    Double Amount_LC;
    @Column(name = "Crcy")
    String Crcy;
    @Column(name = "UserName")
    String UserName;
    @Column(name = "Authorized_deliveries")
    boolean Authorized_deliveries;

    public Postings(Long mat_Doc, Long item, Date doc_Date,
                    Date pstng_Date, String materialDescription, int quantity,
                    String BUn, Double amount_LC, String crcy, String userName) {
        Mat_Doc = mat_Doc;
        Item = item;
        Doc_Date = doc_Date;
        PstngDate = pstng_Date;
        MaterialDescription = materialDescription;
        Quantity = quantity;
        this.BUn = BUn;
        Amount_LC = amount_LC;
        Crcy = crcy;
        UserName = userName;
    }
}
