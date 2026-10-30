import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void menu(){
        Scanner scanner =new Scanner(System.in);
        Banca banca=new Banca();
        int scelta;
        do {

            System.out.println("1.Crea cliente");
            System.out.println("2.Apri conto");
            System.out.println("3.Deposita");
            System.out.println("4.Preleva");
            System.out.println("5.Saldo conto");
            System.out.println("6.Fai un bonifico");
            System.out.println("7.Esci");
            System.out.print("quale operazione vuoi fare ?");
            scelta = scanner.nextInt();
            scanner.nextLine();
            switch (scelta) {
                case 1 -> {
                    System.out.print("Qual è il tuo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Qual è il tuo cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Qual è la tua città: ");
                    String citta = scanner.nextLine();
                    banca.creaCliente(nome, cognome, citta);
                }
                case 2 ->{
                    System.out.print("Qual e il tuo id: ");
                    int id =scanner.nextInt();
                    scanner.nextLine();
                    try {
                        System.out.print("Che tipo di conto vuoi aprire ");
                        String tipo=scanner.nextLine();
                        banca.apriConto(banca.trovaCliente(id),tipo);

                    }catch (IllegalArgumentException e){
                        System.out.println("Errore :"+e.getMessage());

                    }


                }
                case 3->{
                    try {
                        System.out.print("Qual è il tuo iban :");
                        String iban=scanner.nextLine();
                        Conto conto=banca.trovaConto(iban);
                        System.out.print("Descrivi l'operazione :");
                        String descrizione=scanner.nextLine();
                        System.out.print("Quanto vuoi depositare: ");
                        BigDecimal importo=scanner.nextBigDecimal();
                        conto.deposita(importo,descrizione);
                    }catch (IllegalArgumentException e){
                        System.out.println("Errore :"+e.getMessage());
                    }

                }
                case 4->{
                    try {
                        System.out.print("Qual è il tuo iban :");
                        String iban=scanner.nextLine();
                        Conto conto=banca.trovaConto(iban);
                        System.out.print("Descrivi l'operazione :");
                        String descrizione=scanner.nextLine();
                        System.out.print("Quanto vuoi prelevare: ");
                        BigDecimal importo=scanner.nextBigDecimal();

                        conto.preleva(importo,descrizione);
                    }catch (IllegalArgumentException | IllegalStateException e){
                        System.out.println("Errore :"+e.getMessage());
                    }
                }
                case 5->{
                    try {
                        System.out.print("Qual è il tuo iban :");
                        String iban=scanner.nextLine();
                        Conto conto=banca.trovaConto(iban);
                        System.out.println("Saldo: " + conto.getSaldo());
                    }catch (IllegalArgumentException e){
                        System.out.println("Errore :"+e.getMessage());
                    }

                }
                case 6->{
                    try {
                        System.out.print("Qual è il tuo iban :");
                        String ibanDa=scanner.nextLine();
                        System.out.print("Qual è l'iban a cui vuoi fare il bonifico :");
                        String ibanA=scanner.nextLine();
                        System.out.print("Quanto vuoi mandare :");
                        BigDecimal importo=scanner.nextBigDecimal();
                        banca.bonifico(ibanDa,ibanA,importo);
                    }catch (IllegalArgumentException |IllegalStateException e ){
                        System.out.println("Errore :"+e.getMessage());
                    }

                }
                case 7-> {
                    System.out.println("Arrivederci");
                    return;
                }
                default -> System.out.println("selta non valida");
            }
        }while (scelta != 7) ;
    }
    public static void main(String[] args) {
        menu();


    }
}
