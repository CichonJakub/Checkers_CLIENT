public abstract class Figure {

    protected Board board;
    protected Square square;
    protected Figure_Type figure_type;

    public Figure(Board board, Square square,Figure_Type figure_type ){
       try {
           this.board = board; /// tu try i catch dodac --- intelij
           this.square = square;
           this.figure_type = figure_type;
           this.square.move_figure(this);
       }catch (Bad_MoveException exception){
           throw new RuntimeException(exception);
       }
    }


    public abstract boolean freely_move(Square square); // freely means without jumping

    public abstract Square square_overjumped(Square square_to) throws Bad_MoveException;

    public boolean may_move(Square square){ // ma sprawdzac czy moge sie tam ruszyc
        if(square == null){  // jak ten kwadrat jest nullem czyli poza boardem to false
            return false;
        }
        if(!square.is_free()){  // jezeli jest zajety to nie moge sie tam ruszyc
            return false;
        }
        return is_jump_possible(square) || freely_move(square); // zwraca tru jesli mozemy skoczyc nad przeciwnikiem do celu lub po prpstu sie tam ruszyc
    }

    public boolean is_jump_possible(Square square){
       try {
           return square_overjumped(square) != null;
       }catch (Bad_MoveException exception){
           return false;
       }
    }

    public Color getColor(){
        return figure_type.getColor();
    }

    public void move_on(Square square_to) throws Bad_MoveException { // throws
        if(!square_to.is_free()){
            throw new Bad_MoveException();
        }
        if(this.may_move(square_to)){
            this.square.set_empty(); // oczysztam ten z ktorego skacze, nulluje figure
            square_to.move_figure(this); // ruszam figure ktora byla na tym
            this.square = square_to; // przypisuje nowy kwadracik
        }
        else throw new Bad_MoveException();

    }

    public Figure_Type getFigure_type(){
        return figure_type;
    }

   // @Override
    public String toString(){
        return this.figure_type.toString();
    }
}
