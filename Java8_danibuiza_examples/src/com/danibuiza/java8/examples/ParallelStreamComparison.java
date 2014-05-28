package com.danibuiza.java8.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dgutierrez-diez class to compare parallel stream computations -> stupid computation is
 *         done, without any other goal that test and compare the new java 8 streams results
 *         example: stream() duration 27651 stream().parallel() duration 8559 parallelStream()
 *         duration 8658 showing that parallel performs much better
 */
public class ParallelStreamComparison
{

    public static int calculateHard( int factor )
    {
        int result = 0;
        for( int i = 0; i < 10000; i++ )
        {
            for( int j = 0; j < 10000; j++ )
            {
                if( j % 2 == 0 )
                {
                    result *= factor;
                }
                if( i % 2 == 0 )
                {
                    result *= factor;
                }
                if( i / 2 == 0 && j > 10 && factor != 0 )
                {
                    result /= factor;
                }
                if( j / 2 == 0 && i > 10 && factor != 0 )
                {
                    result /= factor;
                }
            }
        }
        return result;
    }

    public static void main( String[] args )
    {
        List<Integer> list = new ArrayList<Integer>();
        for( int i = 0; i < 100; i++ )
        {
            list.add( i );
        }

        long start = System.currentTimeMillis();
        list.stream().allMatch( x -> calculateHard( x ) % 2 == 0 );
        long end = System.currentTimeMillis();

        System.out.println( "stream() duration " + ( end - start ) );

        start = System.currentTimeMillis();
        list.stream().parallel().allMatch( x -> calculateHard( x ) % 2 == 0 );
        end = System.currentTimeMillis();

        System.out.println( "stream().parallel() duration " + ( end - start ) );

        start = System.currentTimeMillis();
        list.parallelStream().allMatch( x -> calculateHard( x ) % 2 == 0 );
        end = System.currentTimeMillis();

        System.out.println( "parallelStream() duration " + ( end - start ) );
    }
}
