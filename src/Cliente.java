public class Cliente {
    private final int id;
    private final String nome;
    private final String cognome;
    private final String citta;

    public Cliente(int id, String nome, String cognome, String citta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCitta() {
        return citta;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + citta + ")";
    }
}
