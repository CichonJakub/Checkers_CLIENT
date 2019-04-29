public class Queen extends Figure{

    public Queen(Board board, Square square, Figure_Type figure_type){

        super(board, square, figure_type); /// super czyli konstruktor elementow z klasy wyzej czyli u nas abstract figure
    }

    @Override
    public boolean freely_move(Square square) {  //
        Position position_now = this.square.position; // moze sie poruszac po przekatnej wiec roznice wiersz/columny musza byc the same <3
        if(Math.abs(position_now.difference_columns(square.getPosition())) == Math.abs(position_now.difference_rows(square.getPosition()))){
           /// troche na wyrost ale tak mi lepiej te zmienne ponizej xDDD
            int difference_rows = position_now.difference_rows(square.getPosition());
            int difference_columns = position_now.difference_columns(square.getPosition());
/// 1 lub przeciwny -1
            int directionR = difference_rows/ Math.abs(difference_rows);
            int directionC = difference_columns / Math.abs(difference_columns);

            int difference_sguaresABS = Math.abs(position_now.difference_columns(square.getPosition()));
            for(int i = 1; i < difference_sguaresABS; i++){
                int row = position_now.getRow() + directionR * i;
                int column = position_now.getColumn() + directionC * i;
                if(!board.getSquare(new Position(row,column)).is_free()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Square square_overjumped(Square square_to) throws Bad_MoveException{
        Position position_now = this.square.getPosition();
        int difference_rows = position_now.difference_rows(square_to.getPosition());
        int difference_columns = position_now.difference_columns(square_to.getPosition());

        int directionR = difference_rows/ Math.abs(difference_rows);
        int directionC = difference_columns / Math.abs(difference_columns);

        Square square_jumped = board.getSquare(square_to.getPosition().add(-directionR,-directionC));

        if(square_jumped.is_free()){
            throw new NoFigureToJumpedException();
        }
        if(square_jumped.getFigure().getColor().oppsite() == this.getColor()){
            return  square_jumped;
        }
        else throw new Bad_MoveException();

    }

 //// jednak zostala nie wykrozystana
//    public boolean can_jump(Square square){
//        try {
//            if(square_overjumped(square) != null){
//                Position position_now = this.square.position;
//                if(Math.abs(position_now.difference_columns(square.getPosition())) == Math.abs(position_now.difference_rows(square.getPosition())) ){
//
//                    int difference_rows = position_now.difference_rows(square.getPosition());
//                    int difference_columns = position_now.difference_columns(square.getPosition());
///// 1 lub przeciwny -1
//                    int directionR = difference_rows/ Math.abs(difference_rows);
//                    int directionC = difference_columns / Math.abs(difference_columns);
//
//                    int difference_sguaresABS = Math.abs(position_now.difference_columns(square.getPosition()));
//
//                    for(int i = 1; i < difference_sguaresABS - 1; i++){
//                        int row = position_now.getRow() + directionR * i;
//                        int column = position_now.getColumn() + directionC * i;
//                        if(!board.getSquare(new Position(row,column)).is_free()){
//                            return false;
//                        }
//                    }
//                    return true;
//
//                }
//
//
//            }return false;
//
//
//        }catch(Bad_MoveException exception){
//            return false;
//        }
//
//
//    }

}
