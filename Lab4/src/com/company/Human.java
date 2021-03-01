package com.company;

public class Human {
    private String firstName = new String();
    private String lastName = new String();
    private String patronymic = new String();

    private int day = 0;
    private int month = 0;
    private int year = 0;

    public void split(String string, String delimiter) {
        byte choice = 1;
        for (String word : string.split(delimiter)) {
            switch (choice) {
                case 1:
                    if (delimiter == " ") {
                        this.lastName = word;
                    } else {
                        this.day = Integer.parseInt(word);
                    }
                    break;
                case 2:
                    if (delimiter == " ") {
                        this.firstName = word;
                    } else {
                        this.month = Integer.parseInt(word);
                    }
                    break;
                case 3:
                    if (delimiter == " ") {
                        this.patronymic = word;;
                    } else {
                        this.year = Integer.parseInt(word);
                    }
                    break;
                default:
                    break;
            }
            ++choice;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(byte year) {
        this.year = year;
    }
}
