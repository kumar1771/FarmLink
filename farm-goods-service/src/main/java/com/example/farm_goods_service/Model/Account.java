package com.example.farm_goods_service.Model;

public class Account {
    Integer AccountNumber;
    String AccountName;

    public Integer getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public Account(Integer accountNumber, String accountName) {
        AccountNumber = accountNumber;
        AccountName = accountName;
    }
}
