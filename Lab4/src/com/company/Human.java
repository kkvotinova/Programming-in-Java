package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human {
    private String firstName;
    private String lastName;
    private String patronymic;

    private String data; // DD.MM.YYYY
    private String zodiacSign;

    private int day;
    private int month;
    private int year;

    public void split(String string, String delimiter) {
        byte choice = 1;
        for (String word : string.split(delimiter)) {
            switch (choice) {
                case 1:
                    if (delimiter.equals(" ")) {
                        lastName = word;
                    } else {
                        try {
                            day = Integer.parseInt(word);
                        } catch (NumberFormatException e) {
                            System.err.println("Wrong format of the string!");
                        }
                    }
                    break;
                case 2:
                    if (delimiter.equals(" ")) {
                        firstName = word;
                    } else {
                        try {
                            month = Integer.parseInt(word);
                        } catch (NumberFormatException e) {
                            System.err.println("Wrong format of the string!");
                        }
                    }
                    break;
                case 3:
                    if (delimiter.equals(" ")) {
                        patronymic = word;
                    } else {
                        try {
                            year = Integer.parseInt(word);
                        } catch (NumberFormatException e) {
                            System.err.println("Wrong format of the string!");
                        }
                    }
                    break;
                case 4:
                    data = word;
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
            if (year % 400 == 0 && this.day > 29) {
                return false;
            } else if ((year % 100 != 0 && year % 4 == 0) && (this.day > 29)) {
                return false;
            } else return this.day <= 28;
        } else
            if ((month == 4 || month == 6 || month == 9 || month == 11)
                && (this.day > 30)) { // april june september november
            return false;
        } else return (month != 1 && month != 3 && month != 5 && month != 7
                    && month != 8 && month != 10 && month != 12) || (day <= 31); // others
    }

    public void determiningZodiacSign() {
        switch (month) {
            case 1:
                if (day <= 19) {
                    zodiacSign = "Козерог";
                } else {
                    zodiacSign = "Водолей";
                }
                break;
            case 2:
                if (day <= 18) {
                    zodiacSign = "Водолей";
                } else {
                    zodiacSign = "Рыбы";
                }
                break;
            case 3:
                if (day <= 20) {
                    zodiacSign = "Рыбы";
                } else {
                    zodiacSign = "Овен";
                }
                break;
            case 4:
                if (day <= 19) {
                    zodiacSign = "Овен";
                } else {
                    zodiacSign = "телец";
                }
                break;
            case 5:
                if (day <= 20) {
                    zodiacSign = "Телец";
                } else {
                    zodiacSign = "Близнецы";
                }
                break;
            case 6:
                if (day <= 20) {
                    zodiacSign = "Близнецы";
                } else {
                    zodiacSign = "Рак";
                }
                break;
            case 7:
                if (day <= 22) {
                    zodiacSign = "Рак";
                } else {
                    zodiacSign = "Лев";
                }
                break;
            case 8:
                if (day <= 22) {
                    zodiacSign = "Лев";
                } else {
                    zodiacSign = "Дева";
                }
                break;
            case 9:
                if (day <= 22) {
                    zodiacSign = "Дева";
                } else {
                    zodiacSign = "Весы";
                }
                break;
            case 10:
                if (day <= 22) {
                    zodiacSign = "Весы";
                } else {
                    zodiacSign = "Скорпион";
                }
                break;
            case 11:
                if (day <= 21) {
                    zodiacSign = "Скорпион";
                } else {
                    zodiacSign = "Стрелец";
                }
                break;
            case 12:
                if (day <= 21) {
                    zodiacSign = "Стрелец";
                } else {
                    zodiacSign = "Козерог";
                }
                break;
            default:
                System.out.println("WRONG!");
                break;
        }
    }

    public String getData() {
        return data;
    }

    public String countAge() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String currentData = dateFormat.format(date);

        // person date
        int newDay = day;
        int newMonth = month;
        int newYear = year;

        split(currentData, "\\.");

        int age;
        if (newMonth < month) {
            age = year - newYear;
        } else if (newMonth > month) {
            age = year - newYear - 1;
        }  else {
            if (newDay <= day) {
                age = year - newYear;
            } else {
                age = year - newYear - 1;
            }
        }

        String string1;
        if (age % 10 == 1) {
            string1 = age + " год";
        } else if (age % 10 > 1 && age % 10 < 5) {
            string1 = age + " года";
        } else {
            string1 = age + " лет";
        }

        return string1;
    }

    public void answer() {
        System.out.println("Name: " + lastName + " " + firstName.toCharArray()[0]
                + "." + patronymic.toCharArray()[0] + ".");

        String gender = (patronymic.toCharArray()[patronymic.length() - 1] == 'ч') ? "Мужчина" : "Женщина";
        System.out.println("Gender: " + gender);

        determiningZodiacSign();
        System.out.println("Age: " + countAge());

        System.out.println("Zodiac sign: " + zodiacSign);
    }
}
