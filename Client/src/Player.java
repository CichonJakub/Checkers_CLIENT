public class Player {
    private String name;
    private int figures_amount;

    public Player(String name, int figures_amount){
        this.name = name;
        this.figures_amount = figures_amount;
    }

    public boolean have_figures(){
        return figures_amount > 0;
    }

    public void decresing_amount(){
        this.figures_amount--;
    }
}
