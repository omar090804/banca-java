import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Conto {
    private final String iban;
    private final String tipo;
    private final Cliente cliente;
    private final ArrayList<Movimento> movimenti = new ArrayList<>();
    private int prossimoId = 1;

    public Conto(String iban, String tipo, Cliente cliente) {
        this.iban = iban;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public String getIban() {
        return iban;
    }

    public String getTipo() {
        return tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Movimento> getMovimenti() {
        return movimenti;
    }

    public void deposita(BigDecimal importo, String descrizione) {
        if (importo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Importo non valido");
        }
        Movimento m = new Movimento(prossimoId, LocalDate.now(), importo, descrizione);
        movimenti.add(m);
        prossimoId++;

    }

    public void preleva(BigDecimal importo, String descrizione) {
        if (importo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Importo non valido");
        }
        if (getSaldo().compareTo(importo) < 0) {
            throw new IllegalStateException("Saldo insufficiente");

        }
        Movimento movimento = new Movimento(prossimoId, LocalDate.now(), importo.negate(), descrizione);
        movimenti.add(movimento);
        prossimoId++;
    }

    public BigDecimal getSaldo() {
        BigDecimal saldo = BigDecimal.ZERO;
        for (Movimento m : movimenti) {
            saldo = saldo.add(m.getImporto());
        }
        return saldo;
    }

    @Override
    public String toString() {
        return iban + " (" + tipo + ") - " + cliente;
    }
}
