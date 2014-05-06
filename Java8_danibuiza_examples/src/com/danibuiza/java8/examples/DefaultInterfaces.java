package com.danibuiza.java8.examples;

/**
 * @author dgutierrez-diez based on the code of Benjamin Winterberg testing default interface
 *         methods in java 8
 */
interface DanibuizaInterfaceWithDefaults
{
    default String getBasicName()
    {
        return "default name in the interface ";
    }

    String toBeImplemented();

    // default String toString(){ // not possible -> Object
    // return getBasicName() + toBeImplemented();
    // }

    default String showAsString()
    {
        return getBasicName() + toBeImplemented();
    }
}

class DanibuizaClassUsingDefaults implements DanibuizaInterfaceWithDefaults
{

    @Override
    public String toBeImplemented()
    {
        return "implemented in the class ";
    }

}

class DanibuizaClassNotUsingDefaults implements DanibuizaInterfaceWithDefaults
{

    @Override
    public String toBeImplemented()
    {
        return "implemented in the class ";
    }

    @Override
    public String getBasicName()
    {
        return "default name implemented in the class ";
    }

}

public class DefaultInterfaces
{

    public static void main( String[] args )
    {

        DanibuizaClassUsingDefaults defaults = new DanibuizaClassUsingDefaults();

        DanibuizaClassNotUsingDefaults notDefaults = new DanibuizaClassNotUsingDefaults();

        System.out.println( notDefaults.showAsString() );

        System.out.println( defaults.showAsString() );
    }

}
