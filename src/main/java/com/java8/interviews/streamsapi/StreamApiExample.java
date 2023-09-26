package com.java8.interviews.streamsapi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {
    public static void main(String[] args) {
        System.out.println("Given a list of integers, find out all the even / odd numbers that exist in the list using Stream functions?");
        List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        list1.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        list1.stream().filter(n -> n % 2 == 1).forEach(System.out::println);

        System.out.println("Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
        List<Integer> myList1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList1.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);

        System.out.println("How to find duplicate elements in a given integers list in java using Stream functions?");
        List<Integer> myList2 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();
        myList2.stream().filter(n -> !set.add(n)).forEach(System.out::println);

        System.out.println("Given the list of integers, find the first element of the list using Stream functions?");
        List<Integer> myList3 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList3.stream().findFirst().ifPresent(System.out::println);
       /* Runnable r = () -> {
            System.out.println("Thread running");
        };
        Thread t = new Thread(r);
        t.start();*/

        System.out.println("Given a list of integers, find the total number of elements present in the list using Stream functions?");
        List<Integer> myList4 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        int max = myList4.stream().max(Integer::compareTo).get();
        long count = myList4.stream().count();
        System.out.println("Count: " + count);

        System.out.println("Max Value: " + max);
        IntSummaryStatistics summaryStatistics = myList4.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(summaryStatistics);

        System.out.println(" Given a String, find the first non-repeated character in it using Stream functions?");
        String input = "Java articles are Awesome";
        Character result = input.chars()
                .mapToObj(s -> Character.toLowerCase((char) s))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(result);

        System.out.println("Given a String, find the first repeated character in it using Stream functions?");
        Character output = input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(output);

        System.out.println("Given a list of integers, sort all the values present in it using Stream functions?");
        List<Integer> myList5 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList5.stream().sorted().forEach(System.out::println);

        System.out.println("Given a list of integers, sort all the values present in it in descending order using Stream functions?");
        myList5.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        System.out.println("Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.");
        int[] arr = {10, 15, 8, 49, 25, 98, 98, 32, 15};
        System.out.println(containsDuplicate(arr));

        System.out.println("How will you get the current date and time using Java 8 Date and Time API?");
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time

        System.out.println("Write a Java 8 program to concatenate two Streams?");
        List<String> list3 = Arrays.asList("Java", "8");
        List<String> list4 = Arrays.asList("explained", "through", "programs");
        Stream<String> concateStream = Stream.concat(list3.stream(), list4.stream());
        concateStream.forEach(System.out::println);

        System.out.println("Java 8 program to perform cube on list elements and filter numbers greater than 50.");
        List<Integer> integerList = Arrays.asList(4, 5, 6, 7, 1, 2, 3);
        integerList.stream().map(i -> i * i * i).filter(i -> i > 50).forEach(System.out::println);

        System.out.println("Write a Java 8 program to sort an array and then convert the sorted array into Stream?");
        int array[] = {99, 55, 203, 99, 4, 91};
        Arrays.parallelSort(array);
        Arrays.stream(array).forEach(n -> System.out.println(n + " "));

        System.out.println("How to use map to convert object into Uppercase in Java 8?");
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("How to count each element/word from the String ArrayList in Java8?");
        List<String> names1 = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String, Long> namesCount = names1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        namesCount.forEach((c, count1) -> System.out.println(c + "-" + count1));

        System.out.println("How to find only duplicate elements with its count from the String ArrayList in Java8?");
        Map<String, Long> namesCount1 = names1.stream()
                .filter(x -> Collections.frequency(names1, x) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount1);

        System.out.println("Write a Program to find the Maximum element in an array?");
        int[] arr1 = {12, 19, 20, 88, 00, 9};
        System.out.println(findMaxElement(arr1));

        System.out.println("Write a program to print the count of each character in a String?");
        String s = "string data to count each  character";
        findCountOfChars(s);


    }

    private static void findCountOfChars(String s) {
        Map<String, Long> map = Arrays.stream(s.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        map.forEach((c, count1) -> System.out.println(c + "-" + count1));
    }

    private static int findMaxElement(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    private static boolean containsDuplicate(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        Set<Integer> set = new HashSet<>();
        if (set.size() == list.size()) {
            return false;
        }
        return true;
    }
}
