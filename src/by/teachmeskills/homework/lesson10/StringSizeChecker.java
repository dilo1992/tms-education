package by.teachmeskills.homework.lesson10;


public class StringSizeChecker {
    public static void printMinLength(String str) {
        String[] arr = str.split(" ");
        String arr2 = arr[0];
        for (String el : arr) {
            if (el.length() <= arr2.length())
                arr2 = el;
        }
        System.out.println("The string with the smallest length: " + arr2);
    }

    public static void printMaxLength(String str) {
        String[] arr = str.split(" ");
        String arr2 = " ";
        for (String el : arr) {
            if (el.length() >= arr2.length())
                arr2 = el;
        }
        System.out.println("The string with the largest length: " + arr2);
    }
}

