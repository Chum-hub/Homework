import java.util.Random;

public class Ex7 {
    public static void main(String[] args) {
        secretGenerator();
    }

    //1111
    //i = 0 ; [i] = 1
    //j = 0 ; [j] = 1
    public static int[] secretGenerator() {
        int[] secretCode = new int[4];
        Random rn = new Random();

        for (int i = 0; i < secretCode.length; i++) {
            secretCode[i] = rn.nextInt(6) + 1;

            for (int j = 0; j < secretCode.length; j++) {
                if (secretCode[i] == secretCode[j] && i != j) {
                    if (secretCode[i] >= 1 && secretCode[i] < 6) {
                        secretCode[i] += 1;
                    } else if (secretCode[i] <= 6 && secretCode[i] > 1) {
                        secretCode[i] -= 1;
                    }
                }
            }
            System.out.println(secretCode[i]);
        }
        return secretCode;
    }
}
