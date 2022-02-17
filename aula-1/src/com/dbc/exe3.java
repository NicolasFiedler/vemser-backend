package com.dbc;

import java.util.Scanner;

public class exe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float valorTotal, valorPago;

        System.out.printf("Valor total: R$ ");
        valorTotal = scanner.nextFloat();
        System.out.printf("Valor pago: R$ ");
        valorPago = scanner.nextFloat();

        if (valorTotal <= valorPago){

        }else {
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");
        }
    }
}
