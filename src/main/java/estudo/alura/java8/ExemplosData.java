package estudo.alura.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ExemplosData {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE,05);

        int anos = olimpiadasRio.getYear() - hoje.getYear();

        System.out.println(anos);

        Period periodo = Period.between(hoje,olimpiadasRio);

        LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);

        System.out.println(proximasOlimpiadas);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String valorFormatado = proximasOlimpiadas.format(formatador);

        System.out.println(valorFormatado);

        LocalDateTime agora = LocalDateTime.now();

        System.out.println(agora);

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        System.out.println(agora.format(formatadorComHoras));

        LocalTime horaIntervalo = LocalTime.of(15,30);

        System.out.println(horaIntervalo);
    }

}
