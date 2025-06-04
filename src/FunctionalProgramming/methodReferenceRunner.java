package FunctionalProgramming;

import java.util.List;

public class methodReferenceRunner {

    /* Syntax is -
    (classname::methodname) -> instead of lambda expression you can write the expression in the form of
    method references as well.
     */
    public static void print(Integer num){
        System.out.println(num);
    }

    public static boolean evenNumbersFilter(Integer num){
        return num%2 == 0;
    }

    public static void main(String[] args) {


        List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));

        List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
                .map(s -> s.length())
                .forEach(System.out::println); /*this method reference is a shortcut
                for the above expression*/

        List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
                .map(s -> s.length())
                .forEach(methodReferenceRunner::print);/*We are calling a
         static method here */

        /* Method references also work with a method which is being called on an instance.
        */

        List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
                .map(String::length) //we replaced the method which was called on an instance
                // to a method reference expression
                .forEach(methodReferenceRunner::print);

        //The reason why we go for method references is to make the code more readable.

        Integer max = List.of(23,45,67,34).stream().filter(n -> n%2 == 0)
                .max((n1,n2) -> Integer.compare(n1,n2))
                .orElse(0);

        System.out.println(max);

        Integer max1 = List.of(23,45,67,34).stream().filter(methodReferenceRunner::evenNumbersFilter)
                .max(Integer::compare)
                .orElse(0);

        System.out.println(max1);

        /* Method references can be used with both static methods as well as
        instance methods. And also method references can be used when the number of
        parameters are greater than one.
         */
    }
}
