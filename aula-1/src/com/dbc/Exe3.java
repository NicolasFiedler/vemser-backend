package com.dbc;

import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float valorTotal, valorPago;

        System.out.printf("Valor consumido: R$ ");
        valorTotal = scanner.nextFloat();
        System.out.printf("Valor pago: R$ ");
        valorPago = scanner.nextFloat();

        if (valorTotal <= valorPago){
            //acho q a 3.C esta escrita errada. Era pra ser "maior" nao?

            Float troco = valorPago - valorTotal;

            if (troco == 0) {
                System.out.println("Valor pago, nao ha troco.");
            } else {
                System.out.printf("O troco é de: R$ %.2f", troco);
            }
        }else {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
        }
    }
}
