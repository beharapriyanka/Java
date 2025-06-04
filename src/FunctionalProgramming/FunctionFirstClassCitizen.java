package FunctionalProgramming;

import java.util.List;
import java.util.function.Predicate;

public class FunctionFirstClassCitizen {

    public static void main(String[] args){
        //1.Storing functions in variables
        //2.Passing functions to methods
        //3.Returning functions from methods

        //The above three is possible because of functional interfaces

        //1. example


        Predicate<Integer> integerOddPredicate = getIntegerPredicate(); //2. example
        Predicate<Integer> integerEvenPredicate = n -> n % 2 != 0;
        //in the above we are storing functions in variables
        List.of(23,43,34,45,36,48).stream()
                .filter(integerOddPredicate).map(n -> n*n)
                .forEach(n -> System.out.println(n));

        /*
        Right click -> Refactor -> Extract Local Variable -> Then give a name
         */

    }

    private static Predicate<Integer> getIntegerPredicate() {
        return n -> n % 2 == 0;
    }
    //the above method is returning a function/method back.
}

/* Function with a functional programming is a first class citizen. You can store it
into variables, you can pass it to methods and you can return it back from methods.
 */