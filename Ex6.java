import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {

        functionManager();


    }

    public static void functionManager() {
        System.out.println("Type quadratic equation: ");
        Scanner sc = new Scanner(System.in);
        String inputUserOld = sc.nextLine();
        String inputUser = inputUserOld.replaceAll(" ", "");
        boolean isCorrect = false;

        isCorrect = isCorrect(inputUser);
        int a;
        int b;
        int c;

        if (isCorrect) {
            a = aParam(inputUser);
            b = bParam(inputUser);
            c = cParam(inputUser);
            solution(a, b, c);
        } else {
            System.out.println("Your input isn't correct");
        }
    }

    public static void solution(int a, int b, int c) {
        double D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("There's not solution");
        }
    }

    public static int aParam(String inputUser) {
        int a;
        if (inputUser.startsWith("-x^2")) {
            a = -1;
        } else if (inputUser.startsWith("x^2")) {
            a = 1;
        } else if (inputUser.startsWith("-")) {
            String aParNegative = "";
            aParNegative += inputUser.substring(0, inputUser.indexOf("x^2"));
            a = Integer.parseInt(aParNegative);
        } else {
            String aParPositive = "";
            aParPositive += inputUser.substring(0, inputUser.indexOf("x^2"));
            a = Integer.parseInt(aParPositive);
        }
        return a;
    }

    //-3x^2+5x+12=0
    public static int bParam(String inputUser) {
        int b = 0;
        String bPar = "";
        if (inputUser.contains("x^2+x")) {
            b = 1;
        } else if (inputUser.contains("x^2-x")) {
            b = -1;
        } else if (inputUser.contains("x+")) {
            bPar += inputUser.substring(inputUser.indexOf("x^2") + 3, inputUser.indexOf("x+"));
            b = Integer.parseInt(bPar);
        } else if (inputUser.contains("x-")) {
            bPar += bPar.substring(inputUser.indexOf("x^2") + 3, inputUser.indexOf("x-"));
            b = Integer.parseInt(bPar);
        } else if (inputUser.contains("x=0")) {
            bPar += bPar.substring(inputUser.indexOf("x^2") + 3, inputUser.indexOf("x="));
            b = Integer.parseInt(bPar);
        }
        return b;
    }

    public static int cParam(String inputUser) {
        int c = 0;
        String cPar = "";
        if (inputUser.contains("x+")) {
            cPar += inputUser.substring(inputUser.indexOf("x+") + 1, inputUser.indexOf("="));
            c = Integer.parseInt(cPar);
        } else if (inputUser.contains("x-")) {
            cPar += inputUser.substring(inputUser.indexOf("x-") + 1, inputUser.indexOf("="));
            c = Integer.parseInt(cPar);
        }
        return c;
    }

    public static boolean isCorrect(String inputUser) {
        boolean isCorrect = false;
        String cond1 = "=0";
        String cond2 = "x^2";
        String cond3 = "x+";
        String cond4 = "x-";
        String cond5 = "+x";
        String cond6 = "-x";
        String cond7 = ",";
        String cond8 = ".";
        String cond9 = "x=";
        if (inputUser.contains(cond1) &&
                inputUser.contains(cond2) &&
                inputUser.lastIndexOf("0") == inputUser.length() - 1 &&
                (inputUser.contains(cond3) ||
                        inputUser.contains(cond4) ||
                        inputUser.contains(cond5) ||
                        inputUser.contains(cond6) ||
                        inputUser.contains(cond9))) {
            isCorrect = true;
        } else if (inputUser.contains(cond7) || inputUser.contains(cond8)) {
            return isCorrect;
        }

        return isCorrect;
    }
}
