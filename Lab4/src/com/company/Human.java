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
                        lastName = word;
                    } else {
                        day = Integer.parseInt(word);
                    }
                    break;
                case 2:
                    if (delimiter == " ") {
                        firstName = word;
                    } else {
                        month = Integer.parseInt(word);
                    }
                    break;
                case 3:
                    if (delimiter == " ") {
                        patronymic = word;;
                    } else {
                        year = Integer.parseInt(word);
                    }
                    break;
                default:
                    System.out.println("WRONG!");
                    break;
            }
            ++choice;
        }
    }

    public boolean checkDate() {
        if (month > 12) {
            return false;
        } else if (month == 2) { // february
            if (year % 400 == 0) {
                if (this.day > 29) {
                    return false;
                }
            } else if (year % 100 != 0 && year % 4 == 0) {
                if (this.day > 29) {
                    return false;
                }
            } else {
                if (this.day > 28) {
                    return false;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) { // april june september november
            if (this.day > 30) {
                return false;
            }
        } else if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) { // others
            if (day > 31) {
                return false;
            }
        }
        return true;
    }


}
