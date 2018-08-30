package com.assignment.model;

public class Doctor {
    String docName, specialization, day, time;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Doctor() {

    }

    public Doctor(String docName, String specialization, String day, String time) {

        this.docName = docName;
        this.specialization = specialization;
        this.day = day;
        this.time = time;
    }
}