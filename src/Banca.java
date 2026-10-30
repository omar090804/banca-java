import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Gestisce i clienti e i conti della banca.
 * I conti sono indicizzati per IBAN.
 */

public class Banca {
    private ArrayList<Cliente>clienti = new ArrayList<>();
    private HashMap<String,Conto> conti = new HashMap<>();
    private int prossimoIdCliente=1;
    private int prossimoNumeroConto=1;

    /**
     * creaCliente
     * crea un nuovo cliente e lo aggiunge alla lista di clienti con i seguenti parametri :
     *
     * @param nome nome del cliente
     * @param cognome cognome del cliente
     * @param citta citta del cliente
     * @return
     */
   public Cliente creaCliente(String nome, String cognome, String citta){
       Cliente c=new Cliente(prossimoIdCliente,nome,cognome,citta);
       clienti.add(c);
       System.out.println("il tuo id è : "+prossimoIdCliente);
       prossimoIdCliente++;
       return c;

   }

    /**
     * crea un nuovo conto
     * genera un iban e lo assegna al cliente
     * @param cliente titolare del nuovo conto
     * @param tipo tipo di conto (CORRENTE o RISPARMIO)
     * @return
     */
   public Conto apriConto(Cliente cliente,String tipo){
       String iban= String.format("IT60X0542811101%012d", prossimoNumeroConto);
       Conto c=new Conto(iban,tipo,cliente);
       conti.put(iban,c);
       System.out.println("conto aperto con sucesso ");
       System.out.println("il tuo iban e "+iban);
       prossimoNumeroConto++;
       return c;
   }
    /**
     * Cerca un conto per IBAN.
     * @throws IllegalArgumentException se il conto non esiste
     */
    public Conto trovaConto(String iban) {
        Conto c = conti.get(iban);
        if(c==null){
            throw new IllegalArgumentException("Conto non trovato");
        } else return c;

    }

    /**
     * fare bonifici da un conto ad unaltro perima si cercano i conti per vedere se esistono poi si preleva
     * dal conto che fa il bonifico e si deposita al conto che lo riceve
     * @param ibanDa
     * @param ibanA
     * @param importo
     */
    public void bonifico(String ibanDa, String ibanA, BigDecimal importo) {
        if (ibanDa.equals(ibanA)) {
            throw new IllegalArgumentException("Conti uguali");
        }
        Conto da =trovaConto(ibanDa);
        Conto a =trovaConto(ibanA);
        da.preleva(importo,"Bonifico a :"+ibanA);
        a.deposita(importo,"Bonifico da " + ibanDa);
    }

    /**
     * cercare un cliente dal suo id
     * @param id
     * @return il clente se trovato
     * @throws IllegalArgumentException se il cliente non esiste
     */
    public Cliente trovaCliente(int id) {
        for (Cliente c : clienti) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cliente non trovato");
    }
}
