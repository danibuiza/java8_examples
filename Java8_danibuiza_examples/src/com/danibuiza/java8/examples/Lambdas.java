package com.danibuiza.java8.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambdas
{
    public static void main( String[] args )
    {
        List<String> names = Arrays.asList( "peter", "anna", "mike", "xenia" );

        Collections.sort( names, ( String a, String b ) -> {
            return b.compareTo( a );
        } );

        Collections.sort( names, ( String a, String b ) -> b.compareTo( a ) );

        Collections.sort( names, ( a, b ) -> b.compareTo( a ) );

        System.out.println( names );

        List<String> names2 = Arrays.asList( "peter", null, "anna", "mike", "xenia" );
        names2.sort( Comparator.nullsLast( String::compareTo ) );
        System.out.println( names2 );

        List<String> names3 = null;

        Optional.ofNullable( names3 ).ifPresent( list -> list.sort( Comparator.naturalOrder() ) );

        System.out.println( names3 );
    }

}
