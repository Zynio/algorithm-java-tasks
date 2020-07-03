package pl.zynis.algorithmtasks.services;

import pl.zynis.algorithmtasks.exeptions.InvalidInputException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputService {

    static Scanner keyboard = new Scanner(System.in);

    public static Stream<Integer> validAndGetInputStream(String[] args) {

        if (args.length == 0) {
            throw new InvalidInputException("Input is empty");
        }

        return Arrays.stream(args).map(s -> {
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Wrong number: " + s);
            }
        });
    }

    public static int getInputInt() {
        int value = keyboard.nextInt();
        keyboard.nextLine();
        return  value;
    }

    public static String[] getInputInts() {
        return keyboard.nextLine().split(" ");
    }

}
