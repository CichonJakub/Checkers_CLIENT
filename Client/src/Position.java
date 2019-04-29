import javafx.geometry.Pos;

import java.util.Objects;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public int difference_rows(Position possition){
        int k = possition.row - this.row;
        return k;
    }

    public int difference_columns(Position possition){
        int m = possition.column - this.column;
        return m;
    }

    public boolean equals(Object object) {   // sens1
        if (object == null || !(object instanceof Position)) {
            return false;
        }
        Position position = (Position) object;
        return difference_rows(position) == 0 && difference_columns(position) == 0;
    }

    public int hashCode(){
        return Objects.hash(row, column);
    } //sens2

    public Position add(int row, int column){ // tworzy nowa zmodyfikowana pozycje
        return new Position(this.row + row, this.column + column);
    }


}
