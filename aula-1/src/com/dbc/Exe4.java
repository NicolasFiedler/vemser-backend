package com.dbc;

import java.util.Scanner;

public class Exe4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        limpaTela();
        System.out.println("1 - Rio Grande do Sul");
        System.out.println("2 - Santa Catarina");
        System.out.println("3 - Bahia");
        System.out.println();
        System.out.printf("-> ");
        Integer select = scanner.nextInt();
        scanner.nextLine();
        limpaTela();

        switch (select){
            case 1:
                System.out.println("1 - Gramado");
                System.out.println("2 - Bento Gonçalves");
                System.out.println();
                System.out.printf("-> ");
                select = scanner.nextInt();
                scanner.nextLine();
                limpaTela();
                if (select == 1){
                    System.out.println("População estimada [2021]        36.864 pessoas");
                    System.out.println("Densidade demográfica [2010]     135,70 hab/km²");
                    System.out.println("Principal festa                  Natal Luz");
                }else if (select == 2){
                    System.out.println("População estimada [2021]        123.090 pessoas");
                    System.out.println("Densidade demográfica [2010]     280,86 hab/km²");
                    System.out.println("Principais feiras                Fenavinho, Expobento, Fimma Brasil");
                }else {
                    System.out.println("Valor invalido.");
                }
                break;
            case 2:
                System.out.println("1 - Pomerode");
                System.out.println("2 - Florianópolis");
                System.out.println();
                System.out.printf("-> ");
                select = scanner.nextInt();
                scanner.nextLine();
                limpaTela();
                if (select == 1){
                    System.out.println("População estimada [2021]        34.561 pessoas");
                    System.out.println("Densidade demográfica [2010]     129,28 hab/km²");
                    System.out.println("");
                    System.out.printf("Ao ir, experimente pratos da gastronomia alemã e \n" +
                            "cervejas artesanais variadas. Embora modesta em atrações, \n" +
                            "a cidade pode render um bom passeio para quem está \nvisitando o Sul do país!\n");
                }else if (select == 2){
                    System.out.println("População estimada [2021]        516.524 pessoas");
                    System.out.println("Densidade demográfica [2010]     623,68 hab/km²");
                    System.out.println("");
                    System.out.printf("A cidade tem praias para todos os gostos e desejos, \n" +
                            "seja você um amante do surf ou de praias desertas. \n" +
                            "Com lagoas, dunas, trilhas diversas, bairros cheios de \n" +
                            "história e uma gastronomia com pratos como peixes e ostras, \n" +
                            "é um destino para agradar pessoas de todas as idades!\n");
                }else {
                    System.out.println("Valor invalido.");
                }
                break;
            case 3:
                System.out.println("1 - Mata de São João");
                System.out.println("2 - Itacaré");
                System.out.println();
                System.out.printf("-> ");
                select = scanner.nextInt();
                scanner.nextLine();
                limpaTela();
                if (select == 1){
                    System.out.println("População estimada [2021]        47.643 pessoas");
                    System.out.println("Densidade demográfica [2010]     63,46 hab/km²");
                    System.out.println("");
                    System.out.printf("A Praia do Forte está localizada a cerca de 80 km \n" +
                            "de Salvador, na Bahia, e é um refúgio para quem busca \n" +
                            "sossego. É um lugar delicioso para aproveitar o mar, \n" +
                            "suas paisagens naturais, conhecer o famoso Projeto Tamar e relaxar.\n");
                }else if (select == 2){
                    System.out.println("População estimada [2021]        29.051 pessoas");
                    System.out.println("Densidade demográfica [2010]     32,96 hab/km²");
                    System.out.println("");
                    System.out.printf("Itacaré é um refúgio de praias bem preservadas, \n" +
                            "cercadas pela mata atlântica. É um lugar onde se \n" +
                            "encontra trechos de praias desertas, que são \n" +
                            "ideais para quem quer renovar as energias.\n");
                }else {
                    System.out.println("Valor invalido.");
                }
                break;
            default:
                System.out.println("Valor invalido.");
                break;
        }
    }

    private static void limpaTela(){
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}
