package com.danibuiza.java8.examples;

/*Lambdas can be used to implement interfaces*/
public class IntegerCalculator
{

    interface IntegerMath
    {
        int operation( int a, int b );
    }

    public int operateBinary( int a, int b, IntegerMath op )
    {
        return op.operation( a, b );
    }

    public static void main( String... args )
    {

        IntegerCalculator myApp = new IntegerCalculator();
        /* usage of lambdas to implement interfaces */
        IntegerMath add = ( a, b ) -> a + b;
        IntegerMath sub = ( a, b ) -> a - b;
        IntegerMath mult = ( a, b ) -> a * b;
        IntegerMath div = ( a, b ) -> a / b;
        System.out.println( "50 + 50 = " + myApp.operateBinary( 50, 50, add ) );
        System.out.println( "50 - 50 = " + myApp.operateBinary( 50, 50, sub ) );
        System.out.println( "50 * 50 = " + myApp.operateBinary( 50, 50, mult ) );
        System.out.println( "50 / 50 = " + myApp.operateBinary( 50, 50, div ) );
    }
}
