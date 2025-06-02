package FunctionalProgramming;

import java.util.List;

public class FPNumberRunner {
    public static void main(String[] args){
        List<Integer> numbers = List.of(1,2,3,4,5);
        int result = sumListFP(numbers);
        System.out.println(result);

        int result1 = sumListFPLambda(numbers);
        System.out.println(result1);


    }

    public static Integer sumList(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number; //This is called as Mutations
        }
        return sum;
    }

    public static Integer sumListFP(List<Integer> numbers) {
        return numbers.stream().filter(num -> num%2 == 1).
                reduce(0, (num1, num2) -> num1+num2);
    }

    public static Integer sumListFPLambda(List<Integer> numbers) {
        return numbers.stream().filter(num -> num%2 == 1).
                reduce(0, (num1, num2) -> {
                    System.out.println(num1 + " " + num2);
                    return num1+num2;});
    }
/*the above method is having all the statements, but with lambda expression
we can have these statements written in a single statement.
 */

}
