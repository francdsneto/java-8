package estudo.alura.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();
        palavras.add("Aluno");
        palavras.add("Estudando");
        palavras.add("Java 8");

        Collections.sort(palavras);

        System.out.println(palavras);

        ComparadorPorTamanho comparador = new ComparadorPorTamanho();

        /**
         * Em vez de utilizar a Classe Collections para fazer o sort, agora temos
         * o sort *Implementado* dentro da interface List através de um método default
         */
        //Collections.sort(palavras, new ComparadorPorTamanho());

        /**
         * Uso do default method dentro de uma interface
         */
        //palavras.sort(new ComparadorPorTamanho());

        /**
         * Usando Comparator com Lambda
         */

//        palavras.sort((a,b) -> {
//            if(a.length() < b.length())
//                return -1;
//            if(a.length() < b.length())
//                return 1;
//            return 0;
//        });

        /**
         * Melhorando o lambda acima
         */
        //palavras.sort((a,b) -> Integer.compare(a.length(),b.length()));

        /**
         * Usando method reference
         */
        //palavras.sort(Comparator.comparing(p -> p.length()));

        /**
         * O código acima é equivalente ao código abaixo
         */
        //Comparator<String> comparadorDeStrings = Comparator.comparing(s -> s.length());
//        Function<String, Integer> funcao = s -> s.length();
//        Function<String, Integer> funcao = String::length;
//        Comparator<String> comparadorDeStrings = Comparator.comparing(funcao);
//        palavras.sort(comparadorDeStrings);

        /**
         * Melhorando método reference
         */

        palavras.sort(Comparator.comparing(String::length));

        System.out.println(palavras);

        /**
         * Em vez de se utilizar o foreach com o java 8 é possível utilizar o forEach
         * implementado como método deafult da interface Iterable
         */
//        for (String p: palavras) {
//            System.out.println(p);
//        }

        /**
         * Executando com uma classe que implementa Consumer
         */
        //palavras.forEach(new ImprimeNaLinha());

        /**
         * Usando classe anônimas em vez de implementar uma classe que estende consumer
         */
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        //palavras.forEach(consumer);

        /**
         * Em vez de instanciar uma classe anônima também se pode dar um new
         * em consumer direto no parâmetro
         */
//        palavras.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        /**
         * Usando Lambda para realizar a mesma tarefa
         *
         * Obs: Quando uma interface possui apenas um método, ou seja, interfaces chamadas interfaces funcionais,
         * é possível se utilizar a sintaxe do lambda.
         */
//        palavras.forEach((String p) -> {
//            System.out.println(p);
//        });

        /**
         * Se o método do consumer possui apenas 1 argumento, não é necessário informar o tipo
         * nem se utilizar de parenteses
         */
//        palavras.forEach(p -> {
//            System.out.println(p);
//        });

        /**
         * Se dentro das chaves possui apenas 1 comando, é possível tirar as chaves e o ponto e virgula
         */
        //palavras.forEach(p -> System.out.println(p));

        /**
         * Usando method reference
         */
        palavras.forEach(System.out::println);

        /**
         * A expressão acima equivale ao código abaixo.
         *
         * A expressão lambda pode ser convertida em um consumer
         */
//        Consumer<String> impressor = s -> System.out.println(s);
//        Consumer<String> impressor = System.out::println;
//        palavras.forEach(impressor);

    }

}

class ImprimeNaLinha implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length())
            return -1;
        if(o1.length() < o2.length())
            return 1;
        return 0;
    }
}