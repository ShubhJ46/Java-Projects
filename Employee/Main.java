package Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId()      { return id; }
    public String getName() { return name; }
    public int getSalary()  { return salary; }
    public void increaseSalary (int inc) {
        this.salary += inc;
    }

}

public class Main {
    public static boolean areAnagrams (String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c: s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c: s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
    public static void main(String[] args) {
        //Task 1
        Employee e1 = new Employee(1, "Shubham", 500);
        Employee e2 = new Employee(2, "Divay", 400);
        Employee e3 = new Employee(3, "Aman", 300);
        Employee e4 = new Employee(1, "Pratyush", 200);

        ArrayList<Employee> arr = new ArrayList<Employee>();

        arr.add(e1);
        arr.add(e2);
        arr.add(e3);
        arr.add(e4);


        //Task 2
        Comparator<Employee> bySalary = 
                            (a, b) -> Integer.compare(a.getSalary(), b.getSalary());

        Comparator<Employee> byName = 
                            (a, b) -> a.getName().compareTo(b.getName());

        Comparator<Employee> byIdThenName = Comparator.comparingInt(Employee::getId)
                                                      .thenComparing(Employee::getName);

        Collections.sort(arr, bySalary);

        System.err.print("By salary ascending: ");
        for (Employee e: arr) {
            System.err.print(e.getName() + " ");
        }

        Collections.sort(arr, bySalary.reversed());

        System.err.print("\nBy salary descending: ");
        for (Employee e: arr) {
            System.err.print(e.getName() + " ");
        }

        Collections.sort(arr, byName);

        System.err.print("\nBy name ascending: ");
        for (Employee e: arr) {
            System.err.print(e.getName() + " ");
        }

        Collections.sort(arr, byIdThenName);

        System.err.print("\nBy id then name: ");
        for (Employee e: arr) {
            System.err.print(e.getName() + " ");
        }

        //Task 3
        try {
            for (Employee e: arr) {
                arr.add(new Employee(4, "Amit", 50));
            }
        } catch (ConcurrentModificationException exc) {
            System.out.println("\nCaught CME: " + exc);
        }

        //Task 4
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        list.add(3);
        list.add(4);
        list.add(5);

        try {
            for (int x: list) {
                list.add(6);
            }
        } catch (ConcurrentModificationException exc) {
            System.out.println("\nCaught CME: " + exc);
        }

        //Task 5A
         int[] array = {1, 2, 3, 2, 1, 4, 1};

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num: array) {
            if (mp.containsKey(num)) {
                mp.put(num, mp.get(num)+1);
            } else {
                mp.put(num, 1);
            }
        }

        for (int key: mp.keySet()) {
            System.out.println(key + "->" + mp.get(key));
        }


        //Task 5B
        String s1 = "abcd";
        String s2 = "bcdd";

        System.err.println("Strings are anagrams: " + areAnagrams(s1, s2));

        String c = new String("abc");
        String d = new String("abc");
        System.out.println(c == d);

    }
}
