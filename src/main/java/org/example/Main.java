package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // LinkedList tanımlıyoruz
        LinkedList<Employee> employeeList = new LinkedList<>();

        // Employee ekliyoruz
        employeeList.add(new Employee(1, "John", "Doe"));
        employeeList.add(new Employee(2, "Jane", "Doe"));
        employeeList.add(new Employee(3, "John", "Smith"));
        employeeList.add(new Employee(1, "John", "Doe"));  // Duplicate

        // Find duplicates
        List<Employee> duplicates = findDuplicates(employeeList);
        System.out.println("Duplicates: ");
        for (Employee e : duplicates) {
            System.out.println(e);
        }

        // Find uniques
        Map<Integer, Employee> uniques = findUniques(employeeList);
        System.out.println("Uniques: ");
        for (Map.Entry<Integer, Employee> entry : uniques.entrySet()) {
            System.out.println(entry.getValue());
        }

        // Remove duplicates
        List<Employee> noDuplicates = removeDuplicates(employeeList);
        System.out.println("No Duplicates: ");
        for (Employee e : noDuplicates) {
            System.out.println(e);
        }
    }

    // Find duplicates
    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> uniqueSet = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee e : list) {
            if (!uniqueSet.add(e)) {
                duplicates.add(e);
            }
        }
        return duplicates;
    }

    // Find uniques
    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueEmployees = new HashMap<>();

        for (Employee e : employees) {
            if (e != null) { // Null kontrolü ekledik
                uniqueEmployees.putIfAbsent(e.getId(), e);
            }
        }
        return uniqueEmployees;
    }

    // Remove duplicates
    public static List<Employee> removeDuplicates(List<Employee> list) {
        Set<Employee> uniqueSet = new HashSet<>();
        List<Employee> noDuplicates = new LinkedList<>();

        for (Employee e : list) {
            if (!uniqueSet.add(e)) {
                continue;  // Eğer e zaten set'te varsa, geç
            }
            noDuplicates.add(e);
        }
        return noDuplicates;
    }
}

