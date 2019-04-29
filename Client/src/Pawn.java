import javafx.geometry.Pos;

public class Pawn extends Figure{


    @Override
    public boolean freely_move(Square square) { // po prostu ruch po przekatnej o 1 bez bicia i nic
        Position position = this.square.getPosition(); // chodzi o to zeby roznica midzy teraz i zadanym byla 1 lub -1 i dla gracza white bedzie -1 / black 1
        if(position.difference_rows(square.getPosition()) == figure_type.getColor().getValue() && Math.abs(position.difference_columns(square.getPosition())) == 1 ){
            return true;
        }
        return false;
    }

    @Override
    public Square square_overjumped(Square square_to) throws  NoFigureToJumpedException{ // metoda ma zwrocic nam kwadrat nad ktorym skaczemy
        Position position = this.square.getPosition();
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){   // analogicznie do wyzej ale razy 2 bo mamy miec roznice 2
                if (position.difference_rows(square_to.getPosition()) == 2 * i && position.difference_columns(square_to.getPosition()) == 2 * j) {
                   // tutaj tworzymy sb tego squera nad ktorym skaczemy
                    Square square_overjumped = this.board.getSquare(new Position(position.getRow() + i, position.getColumn() + j));
                    if(square_overjumped.getFigure() == null){
                        throw new NoFigureToJumpedException();
                    }

                    if(square_overjumped.getFigure().getColor() == this.getColor().oppsite() ) { // bo przeskakujemy przeciwnika a nie sb
                        return square_overjumped; // zwracamy sb tego przeskakiwanego kwadracika
                    }

                }
            }
        }

        return null;
    }


    public Pawn(Board board, Square square, Figure_Type figure_type){
        super(board,square,figure_type);
    }




}
