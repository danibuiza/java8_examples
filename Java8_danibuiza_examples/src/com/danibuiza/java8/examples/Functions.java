package com.danibuiza.java8.examples;

import java.util.function.BiFunction;

import com.danibuiza.java8.examples.LambdasExplained.Person;
import com.danibuiza.java8.examples.LambdasExplained.Person.Sex;

public class Functions
{

    public static void main( String[] args )
    {
        BiFunction<Integer, Person.Sex, Person> biFunctionExample = ( n, str ) -> {
            return new Person( n, str );
        };

        Integer age = 22;
        Sex sex = Sex.FEMALE;
        System.out.println( biFunctionExample.apply( age, sex ).getAge() + ";"
            + biFunctionExample.apply( age, sex ).getGender() );
    }
}
