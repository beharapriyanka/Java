package FunctionalProgramming;

import java.util.List;

public class FPNumberRunner {
    public static void main(String[] args){
        List<Integer> numbers = List.of(1,2,3,4,5);
        int result = sumListFP(numbers);
        System.out.println(result);


    }

    public static Integer sumList(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static Integer sumListFP(List<Integer> numbers) {
        return numbers.stream().filter(num -> num%2 == 1).
                reduce(0, (num1, num2) -> num1+num2);
    }
}
