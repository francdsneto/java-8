package estudo.alura.java8.model;

public class Curso {

    private String nome;
    private int aluno;

    public Curso(String nome, int aluno) {
        this.nome = nome;
        this.aluno = aluno;
    }

    public String getNome() {
        return nome;
    }

    public int getAluno() {
        return aluno;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", aluno=" + aluno +
                '}';
    }
}
