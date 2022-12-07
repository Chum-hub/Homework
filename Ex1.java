import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        numbers(array);
    }

    public static void numbers(int[] array) {
        int average = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = sum / array.length;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > average) {
                System.out.print(array[j]+" ");
            }
        }

    }
}