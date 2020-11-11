package View;

public enum colors {
   // Color source: https://coolors.co/palettes
    MAPBACKGROUND("#9B9B7A"),
    MAPGRIDLINES("#797D62"),
    ORGANISM("#D08C60"),
    PANEL("#F7EACA"),
    TUMBLEWEED("#D9AE94"),
    MAXIMUMYELLOWRED("#FFCB69"),
    BEAVER("#997B66"),
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    public String hexCode;
    

    private colors(String hexcode) {
                this.hexCode = hexcode;
             
    }
    
}
