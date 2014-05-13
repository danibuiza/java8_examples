package com.danibuiza.java8.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Predicates
{
    public static void main( String[] args )
    {
        List<String> listLocal = new ArrayList<String>();
        listLocal.add( "dani" );
        listLocal.add( "buiza" );
        System.out.println( "list before:" );
        listLocal.forEach( System.out::println );

        Predicate<String> predicateLocal = new Predicate<String>()
        {

            @Override
            public boolean test( String str )
            {
                return str != null && str.contains( "dani" );
            }

        };

        Stream<String> filtered = listLocal.stream().filter( predicateLocal );

        System.out.println( "list after:" );
        listLocal.forEach( System.out::println );

        System.out.println( "filtered:" );
        filtered.forEach( System.out::println );
    }
}
