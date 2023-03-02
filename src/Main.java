import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {
    static private volatile Horse winner = null;

    static public  void setWinner(Horse a) {
        if (winner == null) {
            synchronized (Main.class) {
                if (winner == null) {
                    winner = a;
                }
            }
        } else {
            System.out.println("Winner is: " + Main.getWinner().getName());
        }
    }
        static public Horse getWinner() {
            return winner;
        }

    public static void main(String[] args) {
        Track track = new Track(100);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList<Thread> racingHorses= new ArrayList<>(Arrays.asList(
                new Thread(new Horse("Speedy", 10, track, countDownLatch)),
                new Thread(new Horse("Mustang", 14, track, countDownLatch)),
                new Thread(new Horse("Wind", 13, track, countDownLatch)),
                new Thread(new Horse("Mooo", 5, track, countDownLatch)),
                new Thread(new Horse("Pony", 8, track, countDownLatch)),
                new Thread(new Horse("Steed", 12, track, countDownLatch))
                ));

        racingHorses.forEach(Thread::start);
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to start the race: ");
        scanner.nextLine();
        countDownLatch.countDown();
        }


    }














//        racingHorses.add(new Thread(new Horse("Speedy", 10))),
//                racingHorses.add(new Thread(new Horse("Mustang", 14)));
//        racingHorses.add(new Thread(new Horse("Wind", 13)));
//        racingHorses.add(new Thread(new Horse("Mooo", 5)));
//        racingHorses.add(new Thread(new Horse("Pony", 8)));
//        racingHorses.add(new Thread(new Horse("Steed", 12)));


