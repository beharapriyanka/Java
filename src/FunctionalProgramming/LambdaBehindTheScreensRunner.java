package FunctionalProgramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class evenNumberPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return number%2 == 0;
    }
}

class consumeListElements implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}

class squareOfNumber implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer num) {
        return num*num;
    }
}
public class LambdaBehindTheScreensRunner {

    public static void main(String[] args) {
        List.of(23,43,34,45,36,48).stream().filter(n -> n%2 == 0)
                .forEach(e -> System.out.println(e));

        List.of(23,43,34,45,36,48).stream().filter(n -> n%2 == 0).map(n -> n*n)
                .forEach(e -> System.out.println(e));

        //Stream<T> filter(Predicate<? super T> predicate);
        /* boolean test(T t); this is the only method present in the
        functional interface Predicate.
        filter accepts a predicate, a class of Type Predicate.
        Predicate Interface has a method called test. This is the only method which
        will not have the implementation.
        So how does "n -> n%2 == 0" get mapped to a implementation of the predicate
        interface? - notes
         */
        System.out.println("********************************************");
        List.of(23,43,34,45,36,48).stream().filter(new evenNumberPredicate())
                .forEach(e -> System.out.println(e));

        System.out.println("********************************************");
        List.of(23,43,34,45,36,48).stream().filter(new evenNumberPredicate())
                .forEach(new consumeListElements());

        System.out.println("***********************************************");
        List.of(23,43,34,45,36,48).stream().filter(new evenNumberPredicate()).map(new squareOfNumber())
                .forEach(new consumeListElements());
    }
}
