import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Movimento movimento = new Movimento(1, LocalDate.of(2026, 1, 1), new BigDecimal("150"), "stipendio");
        System.out.println(movimento);
        Cliente cliente = new Cliente(1, "Omar", "Hassanein", "Milano");
        System.out.println(cliente);
        Conto conto = new Conto("IT60X0542811101000000000001", "Corrente", cliente);
        System.out.println(conto);
        try {
            conto.deposita(new BigDecimal(250000), "Stipendio");

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            conto.preleva(new BigDecimal(33000), "Cena");
        }catch (IllegalStateException e)   {
            System.out.println( e.getMessage());
        }

        System.out.println(conto.getSaldo());
        System.out.println(conto.getMovimenti());

    }
}
