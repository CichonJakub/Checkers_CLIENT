public enum Color {
    WHITE,
    BLACK;
    public int getValue(){
        switch (this){
            case WHITE:
                return 1;
            case BLACK:
                return -1;
           default:
                throw new IllegalArgumentException();
        }
    }

    public Color oppsite() {
        switch (this) {
            case WHITE:
                return BLACK;
            case BLACK:
                return WHITE;
            default:
                 throw new IllegalArgumentException();
        }
    }
}
