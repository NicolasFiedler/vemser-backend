package exercicios.exe3;

import java.util.LinkedList;
import java.util.Queue;

public class exe3   {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        int cont = 0;

        System.out.println(fila);
        for (int i = 0; i < 5; i++) {
            fila.add(i);
            cont++;
        }
        System.out.println(fila);

        fila.poll();
        fila.poll();
        System.out.println(fila);

        fila.poll();
        System.out.println(fila);

        for (int i = 0; i < 3; i++) {
            fila.add(cont);
            cont++;
        }
        System.out.println(fila);

        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println(fila);
    }
}
