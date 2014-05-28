package com.danibuiza.java8.examples;

import java.util.function.Consumer;

/*Accessing Local Variables of the Enclosing Scope*/
public class LambdaScopeTest
{

    public int x = 0;

    class FirstLevel
    {

        public int x = 1;

        void methodInFirstLevel( int x )
        {

            Consumer<Integer> myConsumer = ( y ) -> {
                System.out.println( "x = " + x ); // parameter
                System.out.println( "y = " + y ); // parameter value
                System.out.println( "this.x = " + this.x ); // FirstLevel.x
                System.out.println( "LambdaScopeTest.this.x = " + LambdaScopeTest.this.x ); //global
            };

            myConsumer.accept( x );
            
            
            Consumer<Integer> myConsumer2 = ( y ) -> {
                int var  = 10;
                System.out.println( "var = " + var ); // internal value -> possible to declare variables inside lambdas
                System.out.println( "x = " + x ); // parameter
                System.out.println( "y = " + y ); // parameter value
                System.out.println( "this.x = " + this.x ); // FirstLevel.x
                System.out.println( "LambdaScopeTest.this.x = " + LambdaScopeTest.this.x ); //global
            };

            myConsumer2.accept( x );

        }
    }

    public static void main( String... args )
    {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel(); //this is new
        fl.methodInFirstLevel( 23 );
    }
}
