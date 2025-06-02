package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {

    public static <X> X doubleValue(X value){
        return value;
    }

    public static <X extends List> void duplicate(X list){
        list.addAll(list);
    }
    //Wildcards
    //Upperbound wildcards
    static double sumOfNumberList(List<? extends Number> numbers){
        double sum = 0.0;
        for(Number number: numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    //Lowerbound wildcards
    static void addACoupleOfValues(List<? super Number> numbers){
        numbers.add(1);
        numbers.add(1.0);
        numbers.add(1.0f);
        numbers.add(1l);
    }

    public static void main(String[] args){
        // My custom List - accepts any datatypes
        MyCustomList<String> list1 = new MyCustomList<>();
        list1.addElement("Mango");
        list1.addElement("Banana");
        list1.addElement("Apple");
        for (String element: list1.list) {
            System.out.println(element);
        }
//        System.out.println(list1);
//        System.out.println(list1.get(2));

        MyCustomList<Integer> list2 = new MyCustomList();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(7));
        for (Integer element: list2.list){
            System.out.println(element);
        }
//        System.out.println(list2);
//        System.out.println(list2.get(1));

        // My Custom Integer List - accepts only Number types because we have restricted it to only Number class
        // Byte, Short, Integer, Long, Float, Double are all subclasses of Number class.
        MyCustomIntegerList<Integer> list3 = new MyCustomIntegerList<>();
        list3.addElement(3);
        list3.addElement(4);
        list3.addElement(5);
        System.out.println(list3);

        MyCustomIntegerList<Double> list4 = new MyCustomIntegerList<>();
        list4.addElement(3.0);
        list4.addElement(4.0);
        list4.addElement(5.0);
        System.out.println(list4);

        //This is to see the advance use of generic that is we can use the generics with methods as well
        String value1 = doubleValue("Priyanka");
        Integer number1 = doubleValue(5);
        ArrayList list = doubleValue(new ArrayList());

        System.out.println("********************************");
        System.out.println(value1);
        System.out.println(number1);
        System.out.println(list);
        System.out.println("********************************");

        //duplicate list method
        ArrayList<Integer> listOfIntegers = new ArrayList<>(List.of(1,2,3,4,5));

        duplicate(listOfIntegers);
        System.out.println(listOfIntegers);

        //wildcard methods
        List emptyList = new ArrayList<Number>();
        addACoupleOfValues(emptyList);
        System.out.println(emptyList);

        System.out.println(sumOfNumberList(List.of(1,2,3,4,5)));
        System.out.println(sumOfNumberList(List.of(1.1,2.1,3.1,4.1,5.1)));
        System.out.println(sumOfNumberList(List.of(1l,2l,3l,4l,5l)));

    }
}
