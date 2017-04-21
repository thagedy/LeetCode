package com.test;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaijia Wei on 2017/4/7.
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzzTest {

    public static final String FIZZSTR = "Fizz";
    public static final String BUZZSTR = "Buzz";
    public static final String FIZZBUZZSTR = "FizzBuzz";
    public List<String> fizzBuzz(int n){
        List<String> result = new ArrayList<>(n);
        if (n<1){
            return result;
        }
        for (int i = 1; i <= n; i++){
            if (i%15==0){
                result.add(FizzBuzzTest.FIZZBUZZSTR);
            }else if (i%3==0){
                result.add(FizzBuzzTest.FIZZSTR);
            }else if (i%5==0){
                result.add(FizzBuzzTest.BUZZSTR);
            }else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public List<String> fizzBuzzBest(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }

}
