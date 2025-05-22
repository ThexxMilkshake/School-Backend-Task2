import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class Bonus {

    public static void main(String[] args) {

        HashSet<Integer> secretnumber = randomnumbergenerator();
        String stringnumber = setToStringConverter(secretnumber);
        System.out.println(stringnumber);
        feedback(stringnumber);
    }

    public static HashSet<Integer> randomnumbergenerator() {

        Random rand = new Random();
        HashSet<Integer> secretnumber = new HashSet<>();
        while (secretnumber.size() < 4) {
            int randomnumber = rand.nextInt(9) + 1;
            secretnumber.add(randomnumber);
        }
        return secretnumber;
    }

    public static String setToStringConverter(HashSet<Integer> secretnumber) {

        StringBuilder stringnumber = new StringBuilder();
        for (Integer element : secretnumber) {
            stringnumber.append(element.toString());
        }
        return stringnumber.toString();
    }

    public static void feedback(String stringnumber) {
        boolean play = true;
        Scanner scanner = new Scanner(System.in);
        StringBuilder feedback = new StringBuilder();
        System.out.println("+ = juiste nummer op de juiste plek, O = juiste nummer verkeerde plek, X = verkeerde nummer");
        System.out.println("Doe een gok, Let op vul 4 getallen in. Voer x in om te sluiten.");
        while (play == true) {
            String guess = scanner.nextLine();
            if (Objects.equals(guess, stringnumber)) {
                System.out.println("gefeliciteerd je hebt het goed");
                play = false;
            } else if (guess.equals("x")) {
                play = false;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (guess.substring(i, i + 1).equals(stringnumber.substring(i, i + 1))) {
                        feedback.append("+");
                    } else if (stringnumber.contains(guess.substring(i, i + 1))) {
                        feedback.append("0");
                    } else {
                        feedback.append("X");
                    }
                }
            }
            System.out.println(feedback.toString());
            feedback.delete(0, feedback.length());
        }
    }
}
/* Because we are using a HashSet, we can't reuse a number that already has been used in the randomnumbergenerator.
* This is because HashSets don't allow that functionality. If you want all numbers 1 to 9 to be able to be chosen
* more than once, you'd want to use a ArrayList. */