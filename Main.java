import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        boolean cond = true;
        ArrayList <Contatti> rubrica = new ArrayList<Contatti>();

        do{
            
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Leggi tutti i contatti salvati");
            System.out.println("3. Cerca contatto");
            System.out.println("4. Svuota rubrica");
            System.out.println("5. Esci");
            int scelta = in.nextInt();
            
            switch (scelta) {
                case 1:
                    System.out.println("inserisci il nome");
                    String nome = in.nextLine();
                    in.nextLine();
                    System.out.println("inserisci il numero di telefono");
                    String numTel = in.nextLine();
                    System.out.println("inserisci l'email");
                    String email = in.nextLine();
                    

                    Contatti p1 = new Contatti(nome, numTel, email);
                    

                    try {
                        FileOutputStream fileOut = new FileOutputStream ("rubrica.dat",true);
                        ObjectOutputStream objectOut = new ObjectOutputStream (fileOut);
                        
                        objectOut.writeObject(p1);
            
                        objectOut.flush();
                        fileOut.close();
                    } catch (Exception e) {
                        System.out.println("Eccezione: " + e.getMessage());
                    }
                    break;
                
                case 2:
                    try {
                        try {
                            FileInputStream fileInput = new FileInputStream("rubrica.dat");
                            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                            boolean continua = true;
                            while(continua){
                                try {
                                    Contatti p = (Contatti) objectInput.readObject();
                                    p.toString();
                                } catch (Exception e) {
                                    System.out.println("Eccezione: " + e);
                                    continua = false;
                                }
                            }
                            fileInput.close();
                        } catch (Exception e) {
                            System.out.println("Eccezione: " + e);
                        }
                    } catch (Exception e) {
                        System.out.println("Eccezione: " + e.getMessage());
                    }
                    break;
                
                case 3:
                    System.out.println("inserisci il nome del contatto da cercare");
                    String nomeCerca = in.nextLine();
                    boolean continua = true;
                    int i = 0;
                    do{
                        if(nomeCerca == rubrica.get(i).getNome()){
                            System.out.println(rubrica.get(i).toString());
                        }
                        if(rubrica.get(i+1) == null){
                            continua = false;
                        }

                        i++;
                    }while(continua = true);

                    break;


                case 4:
                    rubrica.clear();
                    try {
                        FileOutputStream fileOut = new FileOutputStream ("rubrica.dat");
                        ObjectOutputStream objectOut = new ObjectOutputStream (fileOut);
                        
                        objectOut.writeObject("");
            
                        objectOut.flush();
                        fileOut.close();
                    } catch (Exception e) {
                        System.out.println("Eccezione: "+e.getMessage());
                    }

                    break;
                
                case 5:
                    System.out.println("uscita dal menù di scelta");
                    cond = false;
                default:
                    break;
            }

        }while(cond==true);
        
        
        
    }
}
