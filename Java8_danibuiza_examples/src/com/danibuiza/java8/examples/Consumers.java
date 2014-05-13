package com.danibuiza.java8.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Consumers
{
    public static void main( String[] args )
    {
        Consumer<Double> consumerLocal = new Consumer<Double>()
        {

            @Override
            public void accept( Double number )
            {
                number += 2;

            }
        };

        List<Double> listDoubles = new ArrayList<Double>();
        listDoubles.add( 1000.0 );
        listDoubles.add( 2000.0 );
        listDoubles.add( 3000.0 );

        System.out.println( "list before:" );
        listDoubles.forEach( System.out::println );

        Stream<Double> streamLocal = listDoubles.stream();
        streamLocal.forEach( listDouble -> listDouble += 2 );
        /*
         * System.out.println( "list after:" ); streamLocal.forEach( System.out::println ); //
         * crashes
         */
        System.out.println( "list after:" );
        listDoubles.forEach( System.out::println );// does not work -> changes are not stored
        
        listDoubles.replaceAll( listElement -> listElement+2 );
        
        System.out.println( "list after replace All:" );
        listDoubles.forEach( System.out::println );// does  work -> Unary operator

    }
}
