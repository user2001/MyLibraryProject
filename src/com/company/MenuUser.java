package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MenuUser {
    Map<LocalDateTime, String> map = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void userHello() {
        System.out.println(ANSI_BLUE + "MENU:");
        System.out.println("TAKE A BOOK - \'1\'");
        System.out.println("BOOKS BY DATE -\'2\',");
        System.out.println("RANGE OF BOOKS -\'3\'");
        System.out.println("RANGE OF DATES -\'4\'");
        System.out.println("COUNT OF BOOKS BY DATE -\'5\'");
        System.out.println("EXIT -\'9\'" + ANSI_RESET);
    }

    public void userChoice() throws Exception {
        while (true) {
            userHello();
            int chooseNumber = scanner.nextInt();
            switch (chooseNumber) {
                case 1:
                    System.out.println(ANSI_GREEN + "Write down the tittle of chosen book" + ANSI_RESET);
                    takeBook();
                    break;
                case 2:
                    System.out.println(ANSI_GREEN + "Enter date in format 2022-01-14:" + ANSI_RESET);
                    showBooksByDate();
                    break;
                case 3:
                    rangeOfBooks();
                    break;
                case 4:
                    rangeOfDates();
                    break;
                case 5:
                    System.out.println(ANSI_GREEN + "Enter date in format 2022-01-14" + ANSI_RESET);
                    countOfBooksByDate();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println(ANSI_RED + "Error, wrong answer" + ANSI_RESET);
                    userHello();
            }
        }
    }

    public void takeBook() {
        Scanner input = new Scanner(System.in);
        String putTitle = input.nextLine();
        map.put(LocalDateTime.now(), putTitle);
        System.out.println("Congrats! You've made a good choice, have a nice reading");
//            Set<Map.Entry<LocalDateTime, String>> entries = map.entrySet();
//            for (Map.Entry<LocalDateTime, String> entry : entries) {
//                System.out.println(entry.getKey().toLocalDate() + " " + "\'"+ entry.getValue()+ "\'");
//            }
    }

    public void rangeOfBooks() {
        Set<Map.Entry<LocalDateTime, String>> entries = map.entrySet();
        for (Map.Entry<LocalDateTime, String> entry : entries) {
            System.out.println(ANSI_GREEN + "Range of books" + ANSI_RESET);
            System.out.println(entry.getValue());
        }
    }

    public void rangeOfDates() {
        Set<Map.Entry<LocalDateTime, String>> entries = map.entrySet();
        for (Map.Entry<LocalDateTime, String> entry : entries) {
            System.out.println(ANSI_GREEN + "Range of dates" + ANSI_RESET);
            System.out.println(entry.getKey().toLocalDate());
        }
    }

    public void showBooksByDate() {
        String dateNeeded = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDateTime = LocalDate.parse(dateNeeded, formatter);
        Set<Map.Entry<LocalDateTime, String>> entries = map.entrySet();
        for (Map.Entry<LocalDateTime, String> entry : entries) {
            if (entry.getKey().toLocalDate().equals(formatDateTime)) {
                System.out.println(map.get(entry.getKey()));
            } else System.out.println("No one books was taken");
            break;
        }
    }

    public void countOfBooksByDate() {
        String dateNeeded = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDateTime = LocalDate.parse(dateNeeded, formatter);
        Set<Map.Entry<LocalDateTime, String>> entries = map.entrySet();
        int count = 0;
        for (Map.Entry<LocalDateTime, String> entry : entries) {
            if (entry.getKey().toLocalDate().equals(formatDateTime)) {
                count++;
            }
        }
        System.out.println("This day " + count + " book(books) were taken");
    }

}

