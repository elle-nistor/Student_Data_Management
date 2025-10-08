import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Elev implements Serializable {
    protected int nrOrdine, absenteMotivate, absenteNemotivate;
    protected String nume, prenume, purtare,gen;
    protected double notaRomana, notaMatematica, notaFizica, notaChimie, notaEngleza, notaEdFizica, notaEdCivica, notaInformatica;



    public Elev(int nrOrdine, String nume, String prenume, String gen, double notaRomana, double notaMatematica,
                double notaFizica, double  notaChimie, double notaEngleza, double notaEdFizica, double notaEdCivica, double notaInformatica,
                int absenteMotivate, int absenteNemotivate,  String purtare){

        this. nrOrdine = nrOrdine;
        this. nume = nume;
        this. prenume = prenume;
        this. notaRomana = notaRomana;
        this. notaMatematica = notaMatematica;
        this. notaFizica = notaFizica;
        this. notaChimie = notaChimie;
        this. notaEngleza = notaEngleza;
        this. notaEdFizica = notaEdFizica;
        this. notaEdCivica = notaEdCivica;
        this. notaInformatica = notaInformatica;
        this. absenteMotivate = absenteMotivate;
        this. absenteNemotivate = absenteNemotivate;
        this. gen = gen;
        this. purtare = purtare;



    }


    public String toString() {


        return "Numar de ordine: " + nrOrdine + "\n" +
                "Nume: " + nume + "\n" +
                "Prenume: " + prenume + "\n" +
                "Gen: " + gen + "\n" +
                "Nota Limba Română: " + notaRomana + "\n" +
                "Nota Matematica: " + notaMatematica + "\n" +
                "Nota Fizica: " + notaFizica + "\n" +
                "Nota Chimie: " + notaChimie + "\n" +
                "Nota Limba Engleza: " + notaEngleza + "\n" +
                "Nota Educație Fizică: " + notaEdFizica + "\n" +
                "Nota Educație Civică: " + notaEdCivica + "\n" +
                "Nota Informatica: " + notaInformatica + "\n" +
                "Absențe Motivate: " + absenteMotivate + "\n" +
                "Absențe Nemotivate: " + absenteMotivate + "\n" +
                "Purtare: " + purtare + "\n";

    }

}



class Test{

    public static Elev[] Lista = new Elev[101];
    public static final String FILENAME = "date_elevi.txt";

    public static int cnt = 0;

    public static void incarcaEleviDinFisier() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Elev el;
            while ((el = (Elev) inputStream.readObject()) != null) {
                Lista[cnt] = el;
                cnt++;
            }
            System.out.println("Datele au fost incarcate cu succes.");
        } catch (EOFException e) {
            System.out.println("Datele au fost incarcate cu succes.");
        } catch (ClassNotFoundException e) {
            System.out.println("Eroare la citirea din fișierul cu studenți: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fișier: " + e.getMessage());
        }
    }





    public static void adaugaElev(Scanner in){

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";

        try {

            System.out.println(BLUE + "Introduceți date despre elevul nou:" + WHITE);

            System.out.println("Număr de ordine?");
            int nr = in.nextInt();
            in.nextLine();

            System.out.println("Nume?");
            String nume = in.next();

            System.out.println("Prenume?");
            String prenume = in.next();

            System.out.println("Gen?");
            String gen = in.next();

            System.out.println("NOTE PE SEMESTRU:");

            System.out.println("Limba Română?");
            double notaRomana = in.nextDouble();

            System.out.println("Matematica");
            double notaMatematica = in.nextDouble();

            System.out.println("Fizica");
            double notaFizica = in.nextDouble();

            System.out.println("Chimia?");
            double notaChimie = in.nextDouble();

            System.out.println("Limba Engleză?");
            double notaEngleza = in.nextDouble();

            System.out.println("Educația Fizică?");
            double notaEdFizica = in.nextDouble();

            System.out.println("Educația Civică?");
            double notaEdCivica = in.nextDouble();

            System.out.println("Informatica?");
            double notaInformatica = in.nextDouble();

            System.out.println("Absențe Motivate?");
            int absenteMotivate = in.nextInt();

            System.out.println("Absențe Nemotivate?");
            int absenteNemotivate = in.nextInt();

            System.out.println("Purtare?");
            String purtare = in.next();

            Lista[cnt] = new Elev (nr,nume, prenume, gen, notaRomana, notaMatematica,notaFizica,
                    notaChimie, notaEngleza, notaEdFizica, notaEdCivica, notaInformatica, absenteMotivate, absenteNemotivate, purtare );
            cnt++;
            System.out.println("Student adăugat cu succes!");
        }

        catch (InputMismatchException e){

            System.out.println("Introduceti date valide!");
        }
    }


    public static void afisare () {

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";
        String RED = "\u001B[31m";

        if (cnt==0)
            System.out.println(RED+"Nu există date despre elevi în fișier!"+WHITE);
        else{

            System.out.println( BLUE + "Lista elevilor     " + WHITE );
            for (int i = 0; i < cnt; i++){
                System.out.println(Lista[i]);
                System.out.println("----------------------------------");

            }}}

    public static void CelMaiDesteptElev() {

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";

        double max = Lista[0].notaChimie + Lista[0].notaEdCivica + Lista[0].notaEdFizica + Lista[0].notaFizica + Lista[0].notaInformatica + Lista[0].notaEngleza + Lista[0].notaMatematica + Lista[0].notaRomana;
        Elev mx=Lista[0];
        for (int i = 1; i < cnt; i++) {
            double sum = Lista[i].notaChimie + Lista[i].notaEdCivica + Lista[i].notaEdFizica + Lista[i].notaFizica + Lista[i].notaInformatica + Lista[i].notaEngleza + Lista[i].notaMatematica + Lista[i].notaRomana;
            if (sum > max)
                mx = Lista[i];
        }
        System.out.println( BLUE + "Cel mai deștept student este:     " + WHITE +  " \n" + mx);

    }


    public static void CeleMaiPutineAbsente(){

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";

        int mn=100000;
        for(int i=0;i<cnt;i++) {
            int aux = Lista[i].absenteMotivate + Lista[i].absenteNemotivate;
            if (aux<mn)
                mn =aux;
        }

        System.out.println( BLUE + "Lista elevilor care au cele mai putine absente" + WHITE );
        for(int i=0;i<cnt;i++) {
            int aux = Lista[i].absenteMotivate + Lista[i].absenteNemotivate;
            if (aux==mn)
                System.out.println(Lista[i]);
        }
    }

    public static void MediaGrupei(){

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";

        double suma=0;
        double media;
        for(int i = 0; i<cnt; i++) {
            double notaMedieElev = (Lista[i].notaChimie + Lista[i].notaEdCivica + Lista[i].notaEdFizica +
                    Lista[i].notaFizica + Lista[i].notaInformatica + Lista[i].notaEngleza + Lista[i].notaMatematica + Lista[i].notaRomana)/8;

            suma+=notaMedieElev;
        }
        media = suma/cnt;
        System.out.println( BLUE +"Media grupei este: "+ WHITE +media);


    }

    public static void CeaMaiMicaNotaEnglezaF() {

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";
        String RED = "\u001B[31m";

        try {
            double mn = 10000;
            Elev elevCuNotaMinima = null;

            for (int i = 0; i < cnt; i++) {
                if (Lista[i].gen.equals("F")) {
                    if (Lista[i].notaEngleza < mn) {
                        mn = Lista[i].notaEngleza;
                        elevCuNotaMinima = Lista[i];
                    }
                }
            }

            if (elevCuNotaMinima != null) {
                System.out.println( BLUE + "Eleva cu cea mai mică notă la limba engleză este:" + WHITE);
                System.out.println(elevCuNotaMinima);
            } else {
                System.out.println( RED + "Nu există elev de gen feminin înregistrat în sistem." + WHITE);
            }
        } catch (NullPointerException e) {
            System.out.println( RED + "Lista de elevi este nulă sau nu conține elevi." + WHITE );
        }
    }

    public static void alfabet() {
        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";


        for (int i = 0; i < cnt - 1; i++) {
            for (int j = i + 1; j < cnt; j++) {

                if (Lista[i].nume.compareTo(Lista[j].nume) > 0) {

                    Elev temp = Lista[i];
                    Lista[i] = Lista[j];
                    Lista[j] = temp;
                }
            }
        }


        System.out.println(BLUE + "Elevii ordonați alfabetic după nume:" + WHITE);
        for (int i = 0; i < cnt; i++) {
            System.out.println(Lista[i]);
            System.out.println("----------------------------------");
        }
    }





    public static void ElevExemplar() {

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";
        String RED = "\u001B[31m";

        try {
            /*Afișarea listei elevilor cu purtarea exemplară, număr de absențe nemotivate egal cu 0 și cu nota 10 la matematică și informatică*/

            for (int i = 0; i < cnt; i++) {
                if (Lista[i].absenteNemotivate == 0 && Lista[i].notaInformatica == 10 && Lista[i].notaMatematica == 10 && Lista[i].purtare.equals("Exemplară")) {
                    System.out.println( BLUE + "Elevii cu purtare exemplară, 0 absențe nemotivate și cu nota 10 la matematică și informatică:" + WHITE);
                    System.out.println(Lista[i]);
                }
            }
        } catch (NullPointerException e) {
            System.out.println( RED + "Lista de elevi este nulă sau nu conține elevi." + WHITE);
        }
    }

    public static void bubleSort() {
        for (int i = 0; i < cnt - 1; i++) {
            for (int j = 0; j < cnt - i - 1; j++) {

                double notaMedieElevJ = (Lista[j].notaChimie + Lista[j].notaEdCivica + Lista[j].notaEdFizica +
                        Lista[j].notaFizica + Lista[j].notaInformatica + Lista[j].notaEngleza +
                        Lista[j].notaMatematica + Lista[j].notaRomana) / 8;

                double notaMedieElevJ1 = (Lista[j+1].notaChimie + Lista[j+1].notaEdCivica + Lista[j+1].notaEdFizica +
                        Lista[j+1].notaFizica + Lista[j+1].notaInformatica + Lista[j+1].notaEngleza +
                        Lista[j+1].notaMatematica + Lista[j+1].notaRomana) / 8;

                if (notaMedieElevJ > notaMedieElevJ1) {
                    Elev aux = Lista[j];
                    Lista[j] = Lista[j+1];
                    Lista[j+1] = aux;
                }
            }
        }
    }

    public static void afisareTop5() {
        bubleSort();

        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";
        String RED = "\u001B[31m";

        if (cnt<5)
            System.out.println(RED+"În fișier sunt mai puțin de 5 elevi!"+WHITE);

        System.out.println(BLUE + "Top 5 elevi cu cea mai mare medie generală:" + WHITE);
        for (int i = cnt - 1; i >= (cnt - 5); i--) {
            System.out.println(Lista[i]);
            System.out.println("----------------------------------");
        }
    }




    public static void inserareFisier(){

        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";
        String WHITE = "\u001B[37m";
        String RED = "\u001B[31m";

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))){

            for (int i = 0; i<cnt; i++) {
                out.writeObject(Lista[i]);
            }
            System.out.println( GREEN + "Datele au fost salvate cu succes în fișier" + WHITE );
        } catch (FileNotFoundException e) {
            System.out.println( RED + "Fișierul nu a putut fi găsit" + WHITE);
        } catch (IOException e) {
            System.out.println( RED + "Eroare la cititre din fișier"+ WHITE);
        }




    }


    public static void main(String [] args) {
        incarcaEleviDinFisier();

        String GREEN = "\u001B[32m";
        String WHITE = "\u001B[37m";
        String RED = "\u001B[31m";
        String WHITE_BG = "\u001B[47m";
        String RESET = "\u001B[0m";

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println(RESET);
            System.out.println(WHITE_BG+"          Meniu           "+RESET);

            System.out.println("1. Adăugare student.");
            System.out.println("2. Afișare studenți.");
            System.out.println("3. Afișarea celui mai deștept elev.");
            System.out.println("4. Afișarea detaliilor elevilor cu cel mai mic număr de absențe.");
            System.out.println("5. Afișarea mediei grupei de elevi");
            System.out.println("6. Afișarea elevului de gen femenin cu cea mai mică notă la limba engleză");
            System.out.println("7. Afișarea listei elevilor cu purtarea exemplară, număr de absențe nemotivate egal cu 0 și cu nota 10 la matematică și informatică");
            System.out.println("8. Afișarea studenților în ordine alfabetică");
            System.out.println("9. Afișarea a TOP 5 studenți cu cea mai mare medie generală");
            System.out.println("0. Ieșire și "+GREEN+"Salvare"+RESET);

            int x = in.nextInt();
            in.nextLine();

            switch (x) {
                case 1:
                    adaugaElev(in);
                    break;

                case 2:
                    afisare();
                    break;

                case 3:
                    CelMaiDesteptElev();
                    break;

                case 4:
                    CeleMaiPutineAbsente();
                    break;

                case 5:
                    MediaGrupei();
                    break;

                case 6:
                    CeaMaiMicaNotaEnglezaF();
                    break;

                case 7:
                    ElevExemplar();
                    break;

                case 8: alfabet();

                case 9: afisareTop5();

                case 0:
                    inserareFisier();
                    return;


                default:
                    System.out.println( RED + "Opțiune invalidă!"+ WHITE);
            }
        }
    }
}
