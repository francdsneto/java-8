package estudo.alura.java8;

import estudo.alura.java8.model.Curso;

import java.util.*;
import java.util.stream.Collectors;

public class ExemploCursos {

    public static void main(String[] args) {

        /**
         * Trabalhando com streams
         */
        List<Curso> cursos = new ArrayList<>();

        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("Javascript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAluno));
        //cursos.forEach(c -> System.out.println(c.getNome()));

        int sum = cursos.stream()
                .filter(c -> c.getAluno() >= 100)
                .mapToInt(Curso::getAluno)
                .sum();

        System.out.println(sum);

        cursos.stream()
                .filter(c -> c.getAluno() > 100)
                .findAny()
                .ifPresent(System.out::println);

//        cursos =  cursos.stream()
//                .filter(c -> c.getAluno() > 100).collect(Collectors.toList());

//        Map<String, Integer> mapaAlunos = cursos.stream()
//                .filter(c -> c.getAluno() > 100).collect(Collectors.toMap(
//                                                                        c -> c.getNome(),
//                                                                        c -> c.getAluno()));

        cursos.stream()
                .filter(c -> c.getAluno() > 100)
                .collect(Collectors.toMap(
                                        c -> c.getNome(),
                                        c -> c.getAluno()))
                .forEach((nome,alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

    }

}
