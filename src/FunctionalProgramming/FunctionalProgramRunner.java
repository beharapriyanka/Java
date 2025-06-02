package FunctionalProgramming;

import java.util.List;

public class FunctionalProgramRunner {

    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Banana", "Mango", "Cat", "Bat");
//        printElements(list);
//        printElementsWithFP(list);
          printElementsWithFilter(list);
          printElementsWithFPFilter(list);
    }
    public static void printElements(List<String> list){
        for(String element: list){
            System.out.println(element);
        }
    }

    public static void printElementsWithFilter(List<String> list){
        for(String element: list){
            if(element.endsWith("at")){
            System.out.println(element);
            }
        }
    }

    public static void printElementsWithFP(List<String> list){
     list.stream().forEach(element -> System.out.println(element));
    }

    public static void printElementsWithFPFilter(List<String> list){
        list.stream().filter(element -> element.endsWith("at")).forEach(element -> System.out.println(element));
    }
    /*For each element in this stream list, do a System.out.println of element.
    We are converting the list into a stream of values and we are calling forEach in it.
    we are passing what to do with each element.
    What are we sending to forEach? Is this data. No, this is not the data.
    This is action. We are sending the code, we are sending for each element to execute this.
    We are sending a function code to forEach.
    We are actually sending a function to execute on each of the element in the stream.
     */

}
