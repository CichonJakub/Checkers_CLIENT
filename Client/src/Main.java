import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // Client
        //deklaracja socet klienta
        ////*********************************

        try{

            Scanner scanner = new Scanner(System.in);
            Gameplay gameplay = new Gameplay("Kuba", "Marcin");
            System.out.println("Zaczyna gracz biały");
            while(gameplay.isWinner() == null){
                if(gameplay.current_player_color == Color.WHITE) {
                    // wysylanie danych do klienta i deklaracja narzedzia do tego
                  ////*********************************

                    try{
                        System.out.println(gameplay);
                        System.out.println("Podaj rzad pionka do ruszenia: ");
                        int row_from = scanner.nextInt() - 1;
                        //Println tej wartosci
                        ////*********************************
                        //Zrzucenie tej wartości
                        ////*********************************

                        System.out.println("Podaj kolumne pionka do ruszenia: ");
                        int column_from = scanner.nextInt() - 1;
                        //Println tej wartosci
                        ////*********************************
                        //Zrzucenie tej wartości
                        ////*********************************

                        System.out.println("Podaj rzad gdzie chesz zeby pionek sie znalazl: ");
                        int row_to = scanner.nextInt() - 1;
                        //Println tej wartosci
                        ////*********************************
                        //Zrzucenie tej wartości
                        ////*********************************

                        System.out.println("Podaj kolumne gdzie chesz zeby pionek sie znalazl: ");
                        int column_to = scanner.nextInt() - 1;
                        //Println tej wartosci
                        ////*********************************
                        //Zrzucenie tej wartości
                        ////*********************************

                        gameplay.make_move(new Position(row_from,column_from), new Position(row_to,column_to));


                    }catch (Bad_MoveException exception){
                        System.out.println("Wprowazaj dobre wspolrzedne bo udusze!!!!!");
                    }
                }

                System.out.println(gameplay);
                if(gameplay.current_player_color == Color.BLACK){
                    // odbieranie danych z serwera
                    //deklaracja potrzebnych narzedzi do odbierania
                    ////*********************************
                    ////*********************************
                    //odczytanie z buforu
                    ////*********************************
                    System.out.println("Blacks row_from: " + /**/);
                    //zrzutowanie tej wartosci na int (wysylamy string). Odejmijcie 1 aby algorytm dzial (z implementacji tablic)
                    ////*********************************

                    //odczytanie z buforu
                    ////*********************************
                    System.out.println("Blacks column_from: " + /**/);
                    //zrzutowanie tej wartosci na int (wysylamy string). Odejmijcie 1 aby algorytm dzial (z implementacji tablic)
                    ////*********************************

                    //odczytanie z buforu
                    ////*********************************
                    System.out.println("Blacks row_to: " + /**/);
                    //zrzutowanie tej wartosci na int (wysylamy string). Odejmijcie 1 aby algorytm dzial (z implementacji tablic)
                    ////*********************************

                    //odczytanie z buforu
                    ////*********************************
                    System.out.println("Blacks column_to: " + /**/);
                    //zrzutowanie tej wartosci na int (wysylamy string). Odejmijcie 1 aby algorytm dzial (z implementacji tablic)
                    ////*********************************

                    try{
                        gameplay.make_move(new Position(row_from_opposite,column_from_opposite), new Position(row_to_opposite,column_to_opposite));


                    }catch (Bad_MoveException exception){
                        System.out.println("BLACK made illegal move, take care!!!!!");
                    }
                }
            }
        }catch (RuntimeException exception){
            exception.printStackTrace();
        }
    }
}
