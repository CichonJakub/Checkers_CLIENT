public enum Figure_Type {
    WHITE_QUEEN,
    WHITE_PAWN,
    BLACK_QUEEN,
    BLACK_PAWN;

    public Color getColor(){
        switch (this){
            case BLACK_PAWN:
                return Color.BLACK;
            case WHITE_PAWN:
                return Color.WHITE;
            case BLACK_QUEEN:
                return Color.BLACK;
            case WHITE_QUEEN:
                return Color.WHITE;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        switch (this){
            case BLACK_PAWN:
                return "b";
            case WHITE_PAWN:
                return "w";
            case BLACK_QUEEN:
                return "B";
            case WHITE_QUEEN:
                return "W";
            default:
                throw new IllegalArgumentException();
        }
    }




}
