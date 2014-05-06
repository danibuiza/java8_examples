package com.danibuiza.java8.examples;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ThaiBuddhistDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author dgutierrez-diez based on the code of Benjamin Winterberg testing java.time package new
 *         stuff...
 */
public class DateAPI
{

    public static void main( String[] args )
    {

        LocalDate testEndOfMonth = LocalDate.of( 2014, Month.JULY, 31 );
        LocalDate oneDayMore = testEndOfMonth.plus( 1, ChronoUnit.DAYS );

        System.out.println( "check oneDayMore " + oneDayMore.getMonth() );
        System.out.println( "check oneDayMore " + oneDayMore.getDayOfWeek() );

        LocalTime lTime = LocalTime.now();
        System.out.println( lTime );

        Period period = Period.between( testEndOfMonth, oneDayMore );
        System.out.println( period.getDays() );

        ThaiBuddhistDate thaiDate = ThaiBuddhistDate.now();
        System.out.println( thaiDate.get( ChronoField.DAY_OF_WEEK ) );

    }

}
