package exercicios.exe6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class exe6 {
    public static void main(String[] args) {
        Random rand = new Random(522071557);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            pessoas.add(new Pessoa("Pessoa " + rand.nextInt(20), rand.nextInt(70)));
        }
        printaVetor(pessoas);

        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        printaVetor(pessoas);

        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o2.getIdade() - o1.getIdade();
            }
        });
        printaVetor(pessoas);

        pessoas.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                if (o1.getNome().compareTo(o2.getNome()) != 0) {
                    return o1.getNome().compareTo(o2.getNome());
                } else {
                    return o1.getIdade() - o2.getIdade();
                }
            }
        });
        printaVetor(pessoas);
    }

    public static void printaVetor (ArrayList<Pessoa> vetor){
        for (Pessoa pessoa : vetor) {
            pessoa.imprimir();
        }
        System.out.println("");
    }
}
