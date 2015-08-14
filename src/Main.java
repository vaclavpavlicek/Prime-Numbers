import java.io.*;

/**
 * Created by vaclav on 8/14/15.
 */
public class Main {

    private static final String INPUT_FILE = "/home/vaclav/Downloads/4.in";
    private static final String OUTPUT_FILE = "/home/vaclav/Documents/output-jungle-4.txt";

    public static void main(String[] args) {
        int[] numbers = setNumbers();
        generateOutputForNumbers(numbers);
    }

    private static int[] setNumbers() {
        int[] result = new int[0];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
            result = new int[Integer.parseInt(reader.readLine())];
            for (int i = 0; i < result.length; i++) {
                result[i] = Integer.parseInt(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void generateOutputForNumbers(int[] numbers) {
        try {
            PrintWriter writer = new PrintWriter(OUTPUT_FILE);
            for (int i = 0; i < numbers.length; i++) {
                if (isPrimeNumber(numbers[i])) {
                    writer.println("Prime number");
                } else {
                    writer.println("Composite number");
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrimeNumber(int number) {
        int countOfFactors = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                countOfFactors++;
            }
        }
        return countOfFactors == 0;
    }

}
