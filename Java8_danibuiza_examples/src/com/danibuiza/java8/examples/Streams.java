package com.danibuiza.java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author dgutierrez-diez from Benjamin Winterberg just for playing with java 8 streams new stuff
 */
public class Streams
{
    public static void main( String[] args )
    {
        
        
        //you can declare streams this way as well to use streams from arrays...
        int[] numbers = {1, 2, 3, 4};
        IntStream numbersFromArray = Arrays.stream(numbers);
       

        
        
        List<String> collectionStr = new ArrayList<>();
        collectionStr.add( "uno" );
        collectionStr.add( "dos" );
        collectionStr.add( "tres" );
        collectionStr.add( "cuatro" );
        collectionStr.add( "cinco" );
        collectionStr.add( "seis" );
        collectionStr.add( "siete" );
        collectionStr.add( "ocho" );

        // filtering -> should print seis and siete

        System.out.println( "filtering" );

        collectionStr.stream().filter( ( s ) -> s.startsWith( "s" ) ).forEach( System.out::println );

        // sorting ->collection sorted by alphabetic order

        System.out.println( "sorting" );

        collectionStr.stream().sorted().forEach( System.out::println );

        // mapping -> convert to upper case

        System.out.println( "mapping" );

        collectionStr.stream().map( String::toUpperCase ).forEach( System.out::println );

        // matching -> true
        
        System.out.println( "matching any" );

        boolean anyStartsWithS = collectionStr.stream().anyMatch( ( s ) -> s.startsWith( "s" ) );

        System.out.println( anyStartsWithS ); 

        // matching -> false
        
        System.out.println( "matching false all" );
        
        boolean allStartsWithA = collectionStr.stream().allMatch( ( s ) -> s.startsWith( "a" ) );

        System.out.println( allStartsWithA ); // false

        System.out.println( "matching true none" );
        
        boolean noneStartsWithZ = collectionStr.stream().noneMatch( ( s ) -> s.startsWith( "z" ) );

        System.out.println( noneStartsWithZ ); // true

        // counting

        System.out.println( "counting" );  // -> 2
        
        long startsWithS = collectionStr.stream().filter( ( s ) -> s.startsWith( "s" ) ).count();

        System.out.println( startsWithS ); // 2

        // reducing -> cinco#cuatro#dos#ocho#seis#siete#tres#uno

        Optional<String> reduced = collectionStr.stream().sorted().reduce( ( s1, s2 ) -> s1 + "#" + s2 );

        reduced.ifPresent( System.out::println );
        
    }
}
