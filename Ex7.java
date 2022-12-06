import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Ex7 {
    public static void main(String[] args) {
        gameManager(difficulty());
    }

    static public void game(int tries) {
        int[] arrayToCheck = secretGenerator();
        for (int i = 1; i <= tries; i++) {
            if (tries == 0 && i == tries) {
                System.out.println("Лох ебаный, вот отгадка: " + Arrays.toString(secretGenerator()));
                break;
            }
            userArrayChecker(arrayToCheck, inputUser());
            System.out.println("Tries left: " + (tries - i));
        }
    }
    static public void gameManager(int diff) {
        Random rn = new Random();
        int tries;
        if (diff == 1) {
            tries = 20;
        } else if (diff == 2) {
            tries = 15;
        } else if (diff == 3) {
            tries = 10;
        } else if (diff == 4) {
            tries = rn.nextInt(20) + 5;
        } else {
            tries = 0;
        }
        game(tries);
    }
    public static int difficulty() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose difficulty: (1) - 20 tries, (2) - 15 tries, (3) - 10 tries, (4) - unexpected mode");
        int diff = sc.nextInt();
        return diff;
    }
    public static boolean corPos(int element2, int element) {
        if (element2 == element) return true;
        return false;
    }
    public static boolean notCorPos(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }
    public static boolean notExist(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != element) return true;
        }
        return false;
    }
    public static void userArrayChecker(int[] array, int[] arrayUser) {
        for (int i = 0; i < array.length; i++) {
            if (corPos(array[i], arrayUser[i])) {
                System.out.println("Number: " + arrayUser[i] + " on correct position");
            } else if (notCorPos(array, arrayUser[i])) {
                System.out.println("Number: " + arrayUser[i] + " not on the correct position");
            } else if (notExist(array, arrayUser[i])) {
                System.out.println("Number: " + arrayUser[i] + " not exist");
            }
        }
    }
    public static int[] inputUser() {
        int[] userArray = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < userArray.length; i++) {
            while (userArray[i] < 1 || userArray[i] > 7) {
                userArray[i] = sc.nextInt();
            }
        }
        return userArray;
    }
    public static boolean arrayCheck(int[] array, int index) {
        for (int i = 0; i < index; i++) {
            if (array[index] == array[i]) return true;
        }
        return false;
    }
    public static int[] secretGenerator() {
        int[] secretCode = new int[4];
        Random rn = new Random();
        for (int i = 0; i < secretCode.length; i++) {
            do {
                secretCode[i] = rn.nextInt(6) + 1;
            } while (arrayCheck(secretCode, i));
            System.out.print(secretCode[i]);
        }
        System.out.println();
        return secretCode;
    }
}
