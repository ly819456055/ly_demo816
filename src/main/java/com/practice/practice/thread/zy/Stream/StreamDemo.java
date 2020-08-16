package com.practice.practice.thread.zy.Stream;

import com.practice.practice.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        Person person1 = new Person(10,"aaaa",20);
        Person person2 = new Person(11,"bbbb",22);
        Person person3 = new Person(12,"cccc",18);
        Person person4 = new Person(14,"dddd",28);
        Person person5 = new Person(16,"eeee",26);
        List<Person> list = Arrays.asList(person1,person2,person3,person4,person5);
        //筛选出id是整数的
        list.stream().filter(p -> {return p.getId()%2 == 0;}).forEach(System.out::println);
        //再加上筛选出年龄大于24的
        list.stream().filter(p -> {return p.getId()%2 == 0;})
                .filter(p -> p.getAge() > 24)
                .forEach(System.out::println);
        //再将name都变成大写
        System.out.println("---------------------------");
        list.stream()
                .filter(p -> p.getId()%2 == 0)
                .filter(p -> p.getAge() > 24)
                .map(p -> p.getName().toUpperCase()).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("---------------------------");
        //再将名字倒序排序
        list.stream()
                .filter(p -> p.getId()%2 == 0)
                .filter(p -> p.getAge() > 20)
                .map(p -> p.getName().toUpperCase())
                .sorted((o1, o2) -> o2.compareTo(o1))
                .limit(1).forEach(System.out::println);




//        List<Integer> list = Arrays.asList(1,2,3);
//        List list2 = list.stream().map(x -> {return x*2;}).collect(Collectors.toList());
//        System.out.println(list);
//        System.out.println(list2);
    }

    private static void initStream() {
        Function<String,Integer> function = s -> (s.length());
        System.out.println(function.apply("abc"));
        Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test(".."));
        Consumer<String> consumer = s -> { System.out.println(s); };
        consumer.accept("sss");
        Supplier<String> supplier = () -> {return "HelloWord";};
        System.out.println(supplier.get());
    }
}
