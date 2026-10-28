import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Movimento m = new Movimento(1, LocalDate.of(2026,1,1),new BigDecimal("150"),"stipendio");
        System.out.println(m);
    }
}
