import java.util.HashMap;

public class Board {

    protected final int width=8;
    protected final int hight=8;

    protected HashMap<Position, Square> squaers = new HashMap<>();

    public Board(){ // wypelniamy sb nasz tablice 8 na 8 kwadracikami z pozycjami :) not clear but works
        for(int row = 0; row < hight; row++){
            for(int column = 0; column < width; column++){
                Position position = new Position(row, column);
                squaers.put(position, new Square(position));
            }
        }
        // ustawienie pionkow białych
        for(int column = 0; column < 4; column++){
            new Pawn(this, squaers.get(new Position(0,2 * column)),Figure_Type.WHITE_PAWN);
            new Pawn(this, squaers.get(new Position(1,2 * column + 1)),Figure_Type.WHITE_PAWN);
            new Pawn(this, squaers.get(new Position(2,2 * column)),Figure_Type.WHITE_PAWN);

        }

        // ustawienie pionkow czarnych
        for(int column = 0; column < 4; column++){
            new Pawn(this, squaers.get(new Position(5,2 * column + 1)),Figure_Type.BLACK_PAWN);
            new Pawn(this, squaers.get(new Position(6,2 * column )),Figure_Type.BLACK_PAWN);
            new Pawn(this, squaers.get(new Position(7,2 * column + 1)),Figure_Type.BLACK_PAWN);
        }

    }
    //// TUTAJ Z HASZ LISTY WYCIAGAM SB ZA POMOCA KLUCZA (POZYCJI) KWADRACIKI
    public Square getSquare(Position position){
        return this.squaers.get(position);
    }

    public void pawn_to_queen(Position position_pawn) { // metoda sprawdzajaca czy pionek doszedl na 2 stone i zaminienia w krolowa
        Square square_pawn = this.squaers.get(position_pawn);
        if (position_pawn.getRow() == 0 && this.squaers.get(position_pawn).getFigure().getFigure_type() == Figure_Type.BLACK_PAWN) { // czarne musza przejsc z dolu na gore biale na odwrot
            square_pawn.set_empty();
            new Queen(this, square_pawn, Figure_Type.BLACK_QUEEN);
        } else if (position_pawn.getRow() == 7 && this.squaers.get(position_pawn).getFigure().getFigure_type() == Figure_Type.WHITE_PAWN) {
            square_pawn.set_empty();
            new Queen(this, square_pawn, Figure_Type.WHITE_QUEEN);
        }

    }

    // sprawdza czy skakalismy jesli tak to czysci przy okazji ten skakany :D
    public boolean make_move_was_jummping(Square square_from , Square square_to) throws Bad_MoveException{
        if(square_to == null) throw new Bad_MoveException();
        boolean have_i_jumped = false;
        if(square_from.getFigure().is_jump_possible(square_to)){
            Square square_jumped = square_from.getFigure().square_overjumped(square_to);
            square_from.getFigure().move_on(square_to);
            square_jumped.set_empty();
            have_i_jumped = true;
        }
        else{
            square_from.getFigure().move_on(square_to);
        }
        pawn_to_queen(square_to.getPosition());
        return have_i_jumped;

    }

    public boolean can_player_move(Color color_player){ // ta metoda ma sprawdzic wszystko mozliwe ruchy. dlatego return true tak dziwnie! sluzy potem do iswinner
        for(int row = 0; row < hight; row ++){
            for (int column = 0; column < width; column ++){ // sprawdzam czy jest tam cos i czy to cos jest figura obecnego gracza
                if(this.getSquare(new Position(row,column)).getFigure() != null && this.getSquare(new Position(row, column)).getFigure().getColor() == color_player ){
                    boolean can_move = false;
                    for(int i = -1; i <= 1; i += 2){ // chce sb przejechac mozliwe rzedy wprzod i w tyl oraz kolumny prawo lewo
                        for(int j = -1; j <= 1; j += 2){
                            if(this.getSquare(new Position(row, column)).getFigure().may_move(this.getSquare(new Position(row + i, column +j)))){
                                can_move = true; // jezeli metoda make move true to zmieniam zmienna can_move na true i return true wychodzi ale poza tymi 2 forami!
                            }
                        }

                    }
                    if(can_move){
                        return true;
                    }

                }
            }
        }
        return false;
    }


    //// to string tu ma byc jeszcze chyba

    @Override
    public String toString(){
        String ret = "";
        for(int r=0;r<8;r++){
            ret+="|";
            for(int c=0;c<8;c++){
                ret+=getSquare(new Position(r,c)).toString()+"|";
            }
            ret+="\n";
        }
        return ret;
    }






}
