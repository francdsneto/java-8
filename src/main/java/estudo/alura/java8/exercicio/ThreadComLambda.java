package estudo.alura.java8.exercicio;

public class ThreadComLambda {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("Executando um runnable")).start();

    }
}

