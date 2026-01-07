package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Yilmaz"));
        employees.add(new Employee(2, "Veli", "Demir"));
        employees.add(new Employee(3, "Ahmet", "Kaya"));
        employees.add(new Employee(2, "Veli", "Demir"));
        employees.add(new Employee(4, "Can", "Aydin"));

        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> cleanedList = removeDuplicates(employees);

    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Integer> seenIds = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee e : list) {
            if (!seenIds.add(e.getId())) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : list) {
            map.putIfAbsent(e.getId(), e);
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (Employee e : list) {
            counter.put(e.getId(), counter.getOrDefault(e.getId(), 0) + 1);
        }

        List<Employee> uniquesOnly = new LinkedList<>();

        for (Employee e : list) {
            if (counter.get(e.getId()) == 1) {
                uniquesOnly.add(e);
            }
        }
        return uniquesOnly;
    }

}