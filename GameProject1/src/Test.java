
import Game1.GameFrame;
import Game1.gameAllInfo;
import Game1.Player_info;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class test {
    static ArrayList<Integer> playerPositions = new ArrayList();
    static ArrayList<Integer> cpuPositions = new ArrayList();

    test() {
    }

    public static void main(String[] var0) {
        gameAllInfo var1 = new gameAllInfo("tic tac toe ", "1300 BC", "Some ascribe the origin of Tic-Tac-Toe to the ancient Egyptians,but the most concrete ancient record we have of the game is from the Romans,and the game they referred to as terni lapilli, or three pebbles at a time.", "Tic-tac-toe, noughts and crosses, or Xs and Os  is a paper-and-pencil game for two players who take turns marking the spaces in a three-by-three grid with X or O. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner. It is a solved game, with a forced draw assuming best play from both players.");
        gameAllInfo var2 = new gameAllInfo("Snake", "1997", "Taneli Armanto", "Snake is a video game genre where the player manoeuvres a growing line that becomes a primary obstacle to itself.");
        Scanner var3 = new Scanner(System.in);
        (new test()).welcome();
        System.out.println("Enter your name please: ");
        String var4 = var3.next();
        System.out.println("Enter your age please: ");
        int var5 = var3.nextInt();
        System.out.println("Enter your gender please: ");
        String var6 = var3.next();
        Player_info var7 = new Player_info(var4, var5, var6);
        var7.printPlayerInfo();

        try {
            File var8 = new File("info.txt");
            if (var8.createNewFile()) {
                System.out.println("File created: " + var8.getName());
            } else {
                System.out.println("File Exists.");
            }

            FileWriter var9 = new FileWriter(var8, true);
            var9.write(var7.getGender() + "\n");
            var9.flush();
            var9.close();
            System.out.println("Your gender has been written to the file!");
        } catch (IOException var17) {
            System.out.println("An error occurred.");
            var17.printStackTrace();
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("information about our games!");
        System.out.println("choose a game for its information");
        System.out.println("1. tic-tac-toe\n2. Snake\n");
        Scanner var18 = new Scanner(System.in);
        int var19 = var18.nextInt();
        if (var19 != 1 || var19 != 2) {
            switch (var19) {
                case 1:
                    var1.printInfo();
                    break;
                case 2:
                    var2.printInfo();
                    break;
                default:
                    System.out.println("You did not choose the correct NUMBER!");
            }
        }

        System.out.println("\n");
        System.out.println("\n");
        System.out.println("--------------------------------------------------------------");
        System.out.println("choose a game!");
        System.out.println("1. tic-tac-toe\n2. Snake\n3.Exit\n");
        int var10 = var3.nextInt();
        switch (var10) {
            case 1:
                char[][] var11 = new char[][]{{' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}, {' ', '|', ' ', '|', ' '}};
                printGameBoard(var11);

                String var14;
                do {
                    Scanner var12 = new Scanner(System.in);
                    System.out.println("Enter your placement (1-9) :");

                    int var13;
                    for(var13 = var12.nextInt(); playerPositions.contains(var13) || cpuPositions.contains(playerPositions); var13 = var12.nextInt()) {
                        System.out.println("Position Taken!!! Enter a valid position");
                    }

                    placePiece(var11, var13, "player");
                    var14 = checkWinner();
                    if (var14.length() > 0) {
                        System.out.println(var14);
                        return;
                    }

                    Random var15 = new Random();

                    int var16;
                    for(var16 = var15.nextInt(9) + 1; playerPositions.contains(var16) || cpuPositions.contains(var16); var16 = var15.nextInt(9) + 1) {
                    }

                    placePiece(var11, var16, "cpu");
                    printGameBoard(var11);
                    var14 = checkWinner();
                } while(var14.length() <= 0);

                System.out.println(var14);
                break;
            case 2:
                new GameFrame();
                break;
            default:
                System.out.println("----------------------------Thanks---------------------------------");
        }

    }

    public static void printGameBoard(char[][] var0) {
        char[][] var1 = var0;
        int var2 = var0.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            char[] var4 = var1[var3];
            char[] var5 = var4;
            int var6 = var4.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                char var8 = var5[var7];
                System.out.print(var8);
            }

            System.out.println();
        }

    }

    public static void placePiece(char[][] var0, int var1, String var2) {
        byte var3 = 32;
        if (var2.equals("player")) {
            var3 = 88;
            playerPositions.add(var1);
        } else if (var2.equals("cpu")) {
            var3 = 48;
            cpuPositions.add(var1);
        }

        switch (var1) {
            case 1:
                var0[0][0] = (char)var3;
                break;
            case 2:
                var0[0][2] = (char)var3;
                break;
            case 3:
                var0[0][4] = (char)var3;
                break;
            case 4:
                var0[2][0] = (char)var3;
                break;
            case 5:
                var0[2][2] = (char)var3;
                break;
            case 6:
                var0[2][4] = (char)var3;
                break;
            case 7:
                var0[4][0] = (char)var3;
                break;
            case 8:
                var0[4][2] = (char)var3;
                break;
            case 9:
                var0[4][4] = (char)var3;
        }

    }

    public static String checkWinner() {
        List var0 = Arrays.asList(1, 2, 3);
        List var1 = Arrays.asList(4, 5, 6);
        List var2 = Arrays.asList(7, 8, 9);
        List var3 = Arrays.asList(1, 4, 7);
        List var4 = Arrays.asList(2, 5, 8);
        List var5 = Arrays.asList(3, 6, 9);
        List var6 = Arrays.asList(1, 5, 9);
        List var7 = Arrays.asList(3, 5, 7);
        ArrayList var8 = new ArrayList();
        var8.add(var0);
        var8.add(var1);
        var8.add(var2);
        var8.add(var3);
        var8.add(var4);
        var8.add(var5);
        var8.add(var6);
        var8.add(var7);
        Iterator var9 = var8.iterator();

        do {
            if (!var9.hasNext()) {
                return "";
            }

            List var10 = (List)var9.next();
            if (playerPositions.containsAll(var10)) {
                return "Congratulation you Won!!!";
            }

            if (cpuPositions.containsAll(var10)) {
                return "CPU wins!!! Sorry !!! Try Again";
            }
        } while(playerPositions.size() + cpuPositions.size() != 9);

        return "OOPS!!! Try Again !!!";
    }

    public final void welcome() {
        System.out.println("--------------------------------welcome--------------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
    }
}
