package java8;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Practice {
    public static void main(String[] args) {

        Employee e0 = new Employee(0,"Rao",500);
        Employee e1 = new Employee(1,"Vikram",10000);
        Employee e2 = new Employee(2,"Singh",20000);
        Employee e3 = new Employee(3,"Jogawat",30000);
        ArrayList<Employee> elist = new ArrayList<Employee>();
        elist.add(e0);
        elist.add(e3);
        elist.add(e1);
        elist.add(e2);


        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(7);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);


        //Stand up straight

        //Print all numbers
        list.forEach(System.out::println);
        //Print all employees
        elist.forEach(System.out::println);
        //print all even numbers
        list.stream().filter(e->e%2==0).forEach(System.out::println);
        //print all the employees with id even
        elist.stream().filter(e->e.getId()%2==0).forEach(System.out::println);
        System.out.println("----------------------------------------------------------------------------");
        //Increment the salary of all the emp where salary is less than 12000
        elist.stream().map(e->{if(e.getSalary()<12000){
                                    e.setSalary((int)(e.getSalary()*1.1));}
                                    return e;})
                                    .forEach(System.out::println);
        //Just print all the salaries
        elist.stream().map(e->e.getSalary()).forEach(System.out::println);
        //Sort all the numbers
        list.stream().sorted().forEach(System.out::println);
        //sort the list of employees on the basis on salary and then name













    }
}
