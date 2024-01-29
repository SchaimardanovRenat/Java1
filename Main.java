package org.example;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class AgeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Как тебя зовут? ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name);
        System.out.print("Введи свою дату рождения в формате ДД.ММ.ГГГГ: ");
        String birthDateStr = scanner.nextLine();

        try {
            Date birthDate = parseDate(birthDateStr);
            checkAge(birthDate);
        } catch (ParseException e) {
            System.out.println("Ошибка при вводе даты! Попробуйте еще раз.");
            return;
        } catch (AgeException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    static void checkAge(Date birthDate) throws AgeException {
        Date currentDate = new Date();
        int age = calculateAge(birthDate, currentDate);
        if (age >= 18) {
            System.out.println("Ты совершеннолетний!");
        } else {
            throw new AgeException("Ты несовершеннолетний!");
        }
    }

    static int calculateAge(Date birthDate, Date currentDate) {
        long diff = currentDate.getTime() - birthDate.getTime();
        long ageInMillis = 1000L * 60 * 60 * 24 * 365;
        return (int) (diff / ageInMillis);
    }

    static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(dateStr);
    }

    static class AgeException extends Exception {
        public AgeException(String message) {
            super(message);
        }
    }
}
