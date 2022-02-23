package com.dbc;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
//	    Calculo soma = (num1 , num2) -> num1 + num2;
//        Calculo multiplicacao = (num1 , num2) -> num1 * num2;
//
//        System.out.println(soma.calculo(2, 3));
//        System.out.println(multiplicacao.calculo(2, 3));

//        Function<Double, Double> cos = (value) -> Math.cos(value);
//        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
//
//        Function<Double, Double> cosSqrt = sqrt.compose(cos);
//        System.out.println(cosSqrt.apply(1000.));


        System.out.println(fatorial2(5));
    }

    public static Integer fatorial (Integer num){
        if (num > 0){
            if(num == 1){
                return num;
            }
            return num + fatorial(num - 1);
        }
        return null;
    }

    public static Integer fatorial2 (Integer num){
        if (num > 0){
            if(num == 1){
                System.out.println(num);
                return num;
            }
            System.out.println(num);
            return num + fatorial2(num - 1);
        }
        return null;
    }
}
