public class Square {

    protected Figure figure = null;
    protected Position position;

    public Square(Position possition){
        this.position = possition;
    }


    public boolean is_free() {
        return figure == null; //  true dla figury pustej
    }

    public void set_empty() {
        this.figure = null; // nullowanie obecnej figury
    }



    public void move_figure(Figure figure) throws Bad_MoveException  { // throws
        if(this.is_free()) {
            this.figure = figure; // pdomianka figur tej co byla na ta w nawiasie
        }
        else{
            throw new Bad_MoveException();
        }
    }

    public Figure getFigure(){
        return figure;
    }

    public Position getPosition(){
        return position;
    }

    @Override
    public String toString(){
        if(figure == null)
            return " ";
        return figure.toString();
    }

}
