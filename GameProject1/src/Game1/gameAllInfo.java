package Game1;

import Interface.Game_info;

public class gameAllInfo extends gameDetails {
    public String basicInfo;
    public gameDetails[] Info = new gameDetails[2];

    public gameAllInfo() {
    }

    public gameAllInfo(String var1, String var2, String var3, String var4) {
        super(var1, var2, var3);
        this.basicInfo = var4;
    }

    public void setbasicInfo(String var1) {
        this.basicInfo = var1;
    }

    public String getbasicInfo() {
        return this.basicInfo;
    }

    public void printInfo() {
        System.out.println("The name of the game is: " + this.gameName);
        System.out.println("The game was invented in: " + this.gameInvention);
        System.out.println("The origin of the game is: " + this.gameOrigin);
        System.out.println("More information about this game: " + this.basicInfo);
        System.out.println();
    }
}
