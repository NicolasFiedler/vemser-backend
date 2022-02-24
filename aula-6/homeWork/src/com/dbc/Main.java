package com.dbc;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        lista.forEach(System.out::println);
        System.out.println();

        //2- filtrar todas as pessoas com salario maior do que 5 mil
        lista.stream()
                .filter(pessoa -> pessoa.getSalario() > 5000.)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente
        lista.stream()
                .filter(pessoa -> pessoa.getCargo().equalsIgnoreCase("desenvolvedor"))
                .sorted(Comparator.comparing(Pessoa::getSalario))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        //4- fazer a média salarial de todos
        System.out.println("Media: " + lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average().getAsDouble());
        System.out.println();

        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        System.out.println(lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 20000));
        System.out.println();

        //6 - retornar uma lista de todos os ids das pessoas
        List<Integer> listaId = lista.stream()
                .map(pessoa -> pessoa.getId())
                .collect(Collectors.toList());
        listaId.forEach(System.out::println);
        System.out.println();

        //7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        List<Salario> salarios = lista.stream()
                .map(pessoa -> {
                    Salario salario = new Salario(pessoa.getId(), pessoa.getSalario());
                    return salario;
                }).collect(Collectors.toList());
        salarios.forEach(System.out::println);
        System.out.println();

        //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores
        Map<Integer, String> table = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(table + "\n");

        //9- com o mapa da questão 8, retornar o nome com o id=2
        System.out.println(table.get(2));
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }
    }

    static class Salario {
        private Integer id;
        private Double salario;

        public Salario(Integer id, Double salario) {
            this.id = id;
            this.salario = salario;
        }

        public Integer getId() {
            return id;
        }

        public Double getSalario() {
            return salario;
        }

        @Override
        public String toString() {
            return "Salario{" +
                    "id=" + id +
                    ", salario=" + salario +
                    '}';
        }
    }
}
