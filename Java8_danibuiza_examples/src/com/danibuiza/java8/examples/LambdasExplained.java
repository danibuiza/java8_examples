package com.danibuiza.java8.examples;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdasExplained
{

    static void simpleLambda( Person person )
    {
        /*
         * composed of an input separated by commas p an arrow -> the lambda expression itself
         * p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
         */
        Consumer<Person> myConsumer = ( p ) -> {

            if( p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25 )
            {
                System.out.println( "male between 18 and 25" );
            }
            else
            {
                System.out.println( "other" );
            }

        };

        myConsumer.accept( person );
    }

    static boolean simpleLambdaWithReturn( Person person )
    {
        /* return statement can be used */
        Predicate<Person> myPredicate = p -> {

            return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;

        };

        return myPredicate.test( person );

    }

    static class Person
    {
        private int age = 0;

        private Sex sex = Sex.MALE;

        public Person( int age, Sex sex )
        {
            this.age = age;
            this.sex = sex;
        }

        int getAge()
        {
            return age;
        }

        public Sex getGender()
        {
            return sex;
        }

        enum Sex
        {
            MALE, FEMALE
        };

    }

    public static void main( String[] args )
    {
        Person p = new Person( 22, Person.Sex.MALE );

        Person p2 = new Person( 222, Person.Sex.MALE );

        simpleLambda( p );

        System.out.println( "simpleLambdaWithReturn( p ) person 222 male " + simpleLambdaWithReturn( p2 ) );
    }

}
