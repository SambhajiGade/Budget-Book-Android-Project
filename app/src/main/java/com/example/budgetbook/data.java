package com.example.budgetbook;

import java.text.DateFormat;

public class data {

    public String day1,month1,year1,rs1;
    public int id,day,month,year,rs;
    public String note,upi,credit,debit,online,offline,Date;

    public data(int day, int month, int year, int rs, String credit, String debit, String note,String online,String offline,String upi,String Date){
        this.credit = credit;
        this.day = day;
        this.month = month;
        this.year = year;
        this.debit = debit;
        this.note = note;
        this.rs = rs;
        this.online = online;
        this.offline = offline;
        this.upi = upi;
        this.Date = Date;


    }

    public data(String day1,String month1,String year1,String rs1){

        this.day1 = day1;
        this.month1 = month1;
        this.year1 = year1;
        this.rs1 = rs1;
    }



    public int getId(){return id;}

    public String getCredit() {
        return credit;
    }

    public int getDay() {
        return day;
    }

    public String getDebit() {
        return debit;
    }

    public int getMonth() {
        return month;
    }

    public int getRs() {
        return rs;
    }

    public int getYear() {
        return year;
    }

    public String getNote() {
        return note;
    }

    public String  getOnline(){return online;}

    public String  getOffline(){return offline;}

    public String getUpi(){return upi;}

    public String getDate(){return Date;}

    public void setId(int id){this.id = id;}

    public void setDate(String Date){ this.Date = Date;}

    public void setDay(int day) {
        this.day = day;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOnline(String online){
        this.online = online;
    }

    public void setOffline(String offline){
        this.offline = offline;
    }

    public void setUpi(String upi){
        this.upi = upi;
    }



    public String getDay1() {
        return day1;
    }

    public String getMonth1() {
        return month1;
    }

    public String getRs1() {
        return rs1;
    }

    public String getYear1() {
        return year1;
    }

    public void setDay1(String day) {
        this.day1 = day1;
    }

    public void setMonth(String month1) {
        this.month1 = month1;
    }

    public void setRs(String rs1) {
        this.rs1 = rs1;
    }

    public void setYear(String year1) {
        this.year1 = year1;
    }

}
