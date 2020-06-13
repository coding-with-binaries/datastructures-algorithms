/*
 * Author - Varun Sharma
 *
 * Question: If number divisible by 3 print Fizz, if divisible by 5 print Buzz. If divisible by both print FizzBuzz
 * */

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

class FizzBuzzRunnable implements Runnable {
    private static int i = 1;
    private static final Object lock = new Object();
    private final int N;
    private final Predicate<Integer> fizzBuzzValidator;
    private final Function<Integer, String> fizzBuzzPrinter;

    public FizzBuzzRunnable(int N, Predicate<Integer> fizzBuzzValidator, Function<Integer, String> fizzBuzzPrinter) {
        this.N = N;
        this.fizzBuzzValidator = fizzBuzzValidator;
        this.fizzBuzzPrinter = fizzBuzzPrinter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (i > N) return;
                if (fizzBuzzValidator.test(i)) {
                    System.out.print(fizzBuzzPrinter.apply(i));
                    if (i != N) {
                        System.out.print(",");
                    }
                    i++;
                }
            }
        }
    }
}

public class FizzBuzz {
    public static void printFizzBuzzSequence_SingleThread(int N) {
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.print("Fizz");
            } else if (i % 5 == 0) {
                System.out.print("Buzz");
            } else {
                System.out.print(i);
            }
            if (i != N) {
                System.out.print(",");
            }
        }
    }

    public static void printFizzBuzzSequence_MultiThreaded(int N) {
        FizzBuzzRunnable[] fizzBuzzRunnableArray = {
                new FizzBuzzRunnable(N, i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz"),
                new FizzBuzzRunnable(N, i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz"),
                new FizzBuzzRunnable(N, i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz"),
                new FizzBuzzRunnable(N, i -> i % 3 != 0 && i % 5 != 0, String::valueOf)
        };

        for (FizzBuzzRunnable fizzBuzzRunnable : fizzBuzzRunnableArray) {
            new Thread(fizzBuzzRunnable).start();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N");
        int N = scanner.nextInt();
        System.out.println("Multithreaded Fizz Buzz Sequence is:");
        printFizzBuzzSequence_MultiThreaded(N);
    }
}
