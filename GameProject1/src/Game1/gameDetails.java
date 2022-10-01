package Game1;


import Interface.Game_info;

class gameDetails extends Game_info {
    public String gameName;
    public String gameInvention;
    public String gameOrigin;

    gameDetails() {
    }

    gameDetails(String var1, String var2, String var3) {
        this.gameName = var1;
        this.gameInvention = var2;
        this.gameOrigin = var3;
    }

    public void setgameName(String var1) {
        this.gameName = var1;
    }

    public void setgameInvention(String var1) {
        this.gameInvention = var1;
    }

    public void setgameOrigin(String var1) {
        this.gameOrigin = var1;
    }

    public String getgameName() {
        return this.gameName;
    }

    public String getgameInvention() {
        return this.gameInvention;
    }

    public String getgameOrigin() {
        return this.gameOrigin;
    }

    public void printInfo() {
        System.out.println("The name of the game is: " + this.gameName);
        System.out.println("The game was invented in: " + this.gameInvention);
        System.out.println("The origin of the game is: " + this.gameOrigin);
        System.out.println();
    }
}
