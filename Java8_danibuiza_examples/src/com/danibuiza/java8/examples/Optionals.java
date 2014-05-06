package com.danibuiza.java8.examples;

import java.util.Optional;

/**
 * @author dgutierrez-diez testing the optionals in java 8
 */
public class Optionals
{

    public static void main( String[] args )
    {

        Optional<String> optional = Optional.of( "bam" );

        Optional<String> emptyOptional = Optional.empty();

        String nullString = null;
        Optional<String> nullableOptional = Optional.ofNullable( nullString );

        optional.isPresent(); // true
        optional.get(); // "bam"
        optional.orElse( "fallback" ); // "bam"

        optional.ifPresent( ( s ) -> System.out.println( s.charAt( 0 ) ) ); // "b"

        optional.ifPresent( System.out::println );

        emptyOptional.ifPresent( System.out::println );

        emptyOptional.orElseThrow(IllegalStateException::new);
        
        System.out.println( emptyOptional.orElse( "not null" ) ) ;
    }
}
