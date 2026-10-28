import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimento {
    private final int id;
    private final LocalDate data;
    private final BigDecimal importo;
    private final String descrizione;

    public Movimento(int id, LocalDate data, BigDecimal importo, String descrizione) {
        this.id = id;
        this.data = data;
        this.importo = importo;
        this.descrizione = descrizione;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return data + " | " + importo + " | " + descrizione;
    }
}
