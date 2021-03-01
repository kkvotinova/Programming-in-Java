package com.company;

public class Human {
    private String firstName = new String();
    private String lastName = new String();
    private String patronymic = new String();

    private String zodiacSign = new String();

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

    public String determiningZodiacSign() {
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
        return zodiacSign;
    }
}
