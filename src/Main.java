import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Movimento movimento = new Movimento(1, LocalDate.of(2026, 1, 1), new BigDecimal("150"), "stipendio");
        //System.out.println(movimento);
       // Cliente cliente = new Cliente(1, "Omar", "Hassanein", "Milano");
       // System.out.println(cliente);
       // Conto conto = new Conto("IT60X0542811101000000000001", "Corrente", cliente);
        //System.out.println(conto);
        Banca banca =new Banca();
        Cliente c =banca.creaCliente("Omar","Hassanein","Milano");
        Conto cc =banca.apriConto(c,"corrente");
        //System.out.println(cc);
        try {
            //conto.deposita(new BigDecimal(250000), "Stipendio");

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
          //  conto.preleva(new BigDecimal(33000), "Cena");
        }catch (IllegalStateException e)   {
            System.out.println( e.getMessage());
        }

       // System.out.println(conto.getSaldo());
       // System.out.println(conto.getMovimenti());
        //System.out.println(banca.trovaConto("IT60X0542811101000000000001"));
        Cliente c2 = banca.creaCliente("Mario", "Rossi", "Milano");
        Conto b = banca.apriConto(c2, "CORRENTE");
        try {
            cc.deposita(new BigDecimal("1000.00"), "Stipendio");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            banca.bonifico(cc.getIban(), b.getIban(), new BigDecimal("300.00"));
        }catch (IllegalStateException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        //banca.bonifico(cc.getIban(), b.getIban(), new BigDecimal("300.00"));
        System.out.println(cc.getSaldo());   // 700.00
        System.out.println(b.getSaldo());   // 300.00

    }
}
