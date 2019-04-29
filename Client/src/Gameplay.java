import com.sun.corba.se.spi.logging.CORBALogDomains;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.HashMap;

public class Gameplay {
    protected Board board;
    protected HashMap<Color, Player> players = new HashMap<>();
    protected Color current_player_color = Color.WHITE;

    public Gameplay(String White_name, String Black_name){
        this.board = new Board();
        this.players.put(Color.WHITE, new Player(White_name, 12));
        this.players.put(Color.BLACK, new Player(Black_name, 12));

    }

    public void make_move(Position position_from, Position position_to) throws Bad_MoveException{
        if(this.board.getSquare(position_from) == null || this.board.getSquare(position_from).getFigure() == null ){
            throw new Bad_MoveException();
        }
        if(this.board.getSquare(position_from).getFigure().getColor() != current_player_color ){
            throw new NoFigureToJumpedException();
        }
        if(this.board.make_move_was_jummping(board.getSquare(position_from), board.getSquare(position_to))) {
            this.players.get(this.current_player_color).decresing_amount();
        }
        //zmiana graczy
        this.current_player_color = this.current_player_color.oppsite(); /// *(-1)

    }

    public Color isWinner(){
        if(!this.players.get(Color.WHITE).have_figures()){
            return Color.BLACK;
        }
        else if(!this.players.get(Color.BLACK).have_figures()){
            return Color.WHITE;
        }
        else if(!this.board.can_player_move(this.current_player_color)){
            return this.current_player_color.oppsite();
        }
        return null;
    }

    public Board getBoard(){
        return board;
    }

    public Color getCurrent_player_color(){
        return current_player_color;
    }

    public String toString(){
        return board.toString();
    }


}
