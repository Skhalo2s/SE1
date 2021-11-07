package Uebung3.view;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 *
 * @author Salah Khalosi
 * @fachbereich_kuerzel skhalo2s
 * @vision 1.0
 *
 */

public class Main {
    public static void main(String[] args) {
        //Client newClient = new Client();
        //newClient.startClient();
        AtomicInteger ai = new AtomicInteger( 10 );
        Stream<Integer> atomIntStream = Stream.generate( ai::getAndIncrement );

        //atomIntStream.forEach( System.out::println );
        Stream<Integer> integerStream = Stream.of( 1, 2, 7, 42, 4711,5,9,100).sorted();
        Stream<Integer> integerStreamF = Stream.of( 1, 2, 7, 42, 4711,5,9,100).filter( x -> x > 7 );

       //integerStream.forEach( System.out::println );
       integerStreamF.forEach( System.out::println );
        Integer summe1 = integerStream.reduce( 0, ( a, b ) -> a + b );
        System.out.println(summe1);


    }
}
