package org.me.javastudy.pipelines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class AggregateOperations {

    public static void main(String[] args){
        AggregateOperations ao = new AggregateOperations();
        ao.examples();
    }

    public void examples(){
        System.out.println("An aggregate operation is a method/operation that acts on every element in a collection via internal iteration");
        System.out.println("i.e. that the logic of iterating through the stream on which the aggregate operations are taking place is abstracted from the programmer");
        System.out.println("and is accomplished via the compiler");
        System.out.println("");
        System.out.println("Aggregate operations process elements from a stream, not a collection");
        System.out.println("Aggregate operations rely on functional interfaces to specify the behavior of certain aggregate functions");

        //streams
        System.out.println("");
        System.out.println("A stream is a sequence of elements in transient format that support sequential and parallel aggregate operations");
        System.out.println("The Collection interface includes a stream() method that returns a stream of the generic collection type");

        //pipelines
        System.out.println("");
        System.out.println("A pipeline is a sequence of aggregate operations. There are three components to any pipeline:");
        System.out.println("1) Source: A source is a software component that can return a stream");
        List<String> collection = Arrays.asList("This","is","a","collection","of","String","Objects");
        Stream<String> streamOfStrings = collection.stream(); // in this case the List<String> object is the source
        System.out.println("2) Intermediate Operations: These are aggregate operations which return a new stream");
        //e.g.
        Optional<String> optionalString = streamOfStrings.sorted(String::compareTo).//here we can use a method reference to abstract the lambda expression that could be used to return an anonymous Comparator class
                peek((e) -> System.out.println(e)).
                filter((e) -> e.length() > 2).//returns a stream where the result of the predicate is true
                map((e) -> e.substring(2)).//performs the provided function on all the elements of the stream and returns a new stream of the mapped elements
                reduce((e1,e2) -> e1+e2); //
        if(optionalString.isPresent()){
            System.out.println("3) Terminal operation: an aggregate operation that does not return a string. In this case an Optional<String> object is returned");
            System.out.println(optionalString.get());
        } else
            System.out.println("I guess something went wrong");
    }
}
