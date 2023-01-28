//Tam Chi Ka 210133669 SE-1D

import java.util.Scanner;
public class bingo {
    public static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        String[][] arrayP1 = {{"24", "2", "8", "1", "25"},
                {"12", "16", "7", "17", "15"},
                {"5", "6", "20", "19", "13"},
                {"14", "23", "22", "4", "3"},
                {"10", "18", "11", "21", "9"}};
        String[][] arrayP2 = {{"24", "21", "17", "15", "6"},
                {"10", "3", "8", "18", "20"},
                {"14", "7", "16", "12", "5"},
                {"25", "23", "13", "19", "11"},
                {"22", "4", "9", "1", "2"}};

        //Print Bingo at the beginning
        printBingo(arrayP1, arrayP2);
        System.out.println("\nGame Host call (0 to exit): ");

        String str = "";
        String[] inNum = new String[25];
        int n = 0;
        int count = 0;

        while (true) {
            int num = kb.nextInt();
            //Convert input number into String
            str = Integer.toString(num);


            //repeated number checker
            if (n >= 1) {
                for (int i = 0; i < count; i++) {
                    if (inNum[i].equals(str)) {
                        System.out.print("Game Host call (0 to exit):");
                        System.out.print("The number " + num + " is repeated, please call again!");
                        break;
                    } else if (inNum[i] == null) {
                        break;
                    }
                }
            }

            //Press 0 to exit
            if (num == 0) {
                break;
            } else if (num < 0 || num > 25) {
                System.out.print("The number must be between 1 to 25, please call again!");
                continue;
                //limit the input between 0-25
            }


            //Saving the inputed number into the repeated number checker
            inNum[count] = str;
            count++;
            n++;

            //check whether the input number is "XX"
            boolean isXX = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (str.equals(arrayP1[i][j])) {
                            arrayP1[i][j] = "XX";
                            isXX = true;
                    }
                    if (str.equals(arrayP2[i][j])) {
                        arrayP2[i][j] = "XX";
                        isXX = true;
                    }
                }
            }
            if (isXX){
                System.out.println("\nGame Host call (0 to exit):");
                printBingo(arrayP1, arrayP2);
            }

            //check the winner
            bingoCheck(arrayP1, arrayP2);
            }
        }





    public static void printBingo(String[][] card1, String[][] card2) {
        //print player 1 card
        System.out.println("Player1's Card:");
        for (int i = 0; i < card1.length; i++) {
            for (int j = 0; j < card1.length; j++) {
                System.out.print(card1[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");

        //print player 2 card
        System.out.println("Player2's Card:");
        for (int i = 0; i < card2.length; i++) {
            for (int j = 0; j < card2.length; j++) {
                System.out.print(card2[i][j] + "\t");
            }
            System.out.println("");
        }
    }






    public static boolean bingoCheck(String[][] card1, String[][] card2) {
        boolean player1 = checkWinner(card1);
        boolean player2 = checkWinner(card2);
        if (player1) {
            System.out.println("Bingo! Player 1 wins!");
        }
        if (player2) {
            System.out.println("Bingo! Player 2 wins!");
        }
        return true;
    }






    public static boolean checkWinner(String[][] cards) {
        boolean isAllCrossed = true;
        int row = 0, col = 0;

        // check horizontal bingo
        for (row = 0; row < cards.length; row++) {
            isAllCrossed = true;
            // check whether the whole row have XX
            for (col = 0; col < cards[0].length; col++) {
                if (!cards[row][col].equals("XX")) {
                    isAllCrossed = false;
                    break;
                }
            }
            if (isAllCrossed) return true;
        }

        // check vertical bingo
        for (col = 0; col < cards[0].length; col++) {
            isAllCrossed = true;
            // check if whole column have XX
            for (row = 0; row < cards.length; row++) {
                if (!cards[row][col].equals("XX")) {
                    isAllCrossed = false;
                    break;
                }
            }
            if (isAllCrossed) return true;
        }

        // check digonal bingo from top left to bottom right
        isAllCrossed = true;
        row = col = 0;
        while (row < cards.length) {
            if (!cards[row][col].equals("XX")) {
                isAllCrossed = false;
                break;
            }
            row++;
            col++;
        }
        if (isAllCrossed) return true;

        // check digonal bingo from top right to bottom left
        isAllCrossed = true;
        row = 0;
        col = cards[0].length - 1;
        while (row < cards.length) {
            if (!cards[row][col].equals("XX")) {
                isAllCrossed = false;
                break;
            }
            row++;
            col--;
        }
        return isAllCrossed;
    }
}


