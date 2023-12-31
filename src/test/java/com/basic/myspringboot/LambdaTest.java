package com.basic.myspringboot;

import com.basic.myspringboot.dto.Customer;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {
    @Test
    void consumer_test() {
        //Immutable List
        List<Customer> customerList =
                List.of(new Customer("boot", 10),
                        new Customer("msa", 20),
                        new Customer("ktds", 50),
                        new Customer("wifi", 70));

        //1. Anonymous Inner Class
        customerList.forEach(new Consumer<Customer>() {
            @Override
            public void accept(Customer customer) {
                System.out.println(customer);
            }
        });
        //2. Lambda Expression
        customerList.forEach(cust -> System.out.println(cust));
        //3. Method Reference
        customerList.forEach(System.out::println);

        //Customer의 age 합계를 계산하기 (age >= 50)
        int sumOfAge =
                customerList.stream() //Stream<Customer>
                        .filter(customer -> customer.getAge() >= 50) //Stream<Customer>
                        .mapToInt(customer -> customer.getAge()) //IntStream
                        //.mapToInt(Customer::getAge)//IntStream
                        .sum();
        System.out.println("나이 합계 " + sumOfAge);

        //나이가 가장 많은 Customer 찾기 
        //IntStream의 max() 메서드 사용
        int maxAgeValue = customerList.stream() //Stream<Customer>
                .mapToInt(cust -> cust.getAge()) //IntStream
                .max() //OptionalInt
                .getAsInt();
        System.out.println("maxAgeValue = " + maxAgeValue);  //soutv
        //Stream의 max() 메서드 사용
        Integer maxValue = customerList.stream() //Stream<Customer>
                .map(cust -> cust.getAge()) //Stream<Integer>
                .max(Integer::compareTo)//Optional<Integer>
                .get();
        System.out.println("maxValue = " + maxValue);

        maxValue = customerList.stream()
                .map(cust -> cust.getAge())
                .max(Comparator.comparingInt(age -> age.intValue()))
                //.max(Comparator.comparingInt(Integer::intValue))
                .get();

    }

    @Test
    void consumer() {
        List<String> stringList =
                List.of("Java", "Python", "Kotlin");//Immutable List
        //Anonymous Inner class
        stringList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        });

        //Lambda Exepression
        //forEach(Consumer)
        //Consumer 의 추상메서드 void accept(T t)
        stringList.forEach(val -> System.out.println(val));
        //Method Reference
        stringList.forEach(System.out::println);
    }

    @Test
    void runnable() {
        //class MyRunnable implements Runnable
        //Thread(new MyRunnable())
        //Anonymous Inner class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner class");
            }
        });
        t1.start();
        //Lambda Expression
        Thread t2 = new Thread(() -> System.out.println("Lambda Expression") );
        t2.start();
    }
}
