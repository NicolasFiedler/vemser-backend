package exercicios.exe4;

import java.util.Scanner;
import java.util.Stack;

public class exe4 {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        Integer num;

        for (int i = 0; i < 15; i++) {
            num = scanner.nextInt();
            scanner.nextLine();
            if (num % 2 == 0){
                pilha.add(num);
            } else if (!pilha.isEmpty()){
                pilha.pop();
            }
        }

        while (!pilha.isEmpty()){
            System.out.println(pilha.pop());
        }
    }
}
