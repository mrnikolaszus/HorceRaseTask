import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static private  Horse winner = null;

    static public  void setWinner(Horse a) {
        if (winner == null) {
            winner = a;
        }
    }
        static public Horse getWinner() {
            return winner;
        }

    public static void main(String[] args) {


        Track track = new Track(100);

        ArrayList<Thread> racingHorses = new ArrayList<Thread>(Arrays.asList(
                new Thread(new Horse("Speedy", 10, track)),
                new Thread(new Horse("Mustang", 14, track)),
                new Thread(new Horse("Wind", 13, track)),
                new Thread(new Horse("Mooo", 5, track)),
                new Thread(new Horse("Pony", 8, track)),
                new Thread(new Horse("Steed", 12, track))
        ));

        racingHorses.forEach(Thread::start);
        racingHorses.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(Main.getWinner().getName() + " Was first at FINISH, and WON the RACE!");
    }
    }














//        racingHorses.add(new Thread(new Horse("Speedy", 10))),
//                racingHorses.add(new Thread(new Horse("Mustang", 14)));
//        racingHorses.add(new Thread(new Horse("Wind", 13)));
//        racingHorses.add(new Thread(new Horse("Mooo", 5)));
//        racingHorses.add(new Thread(new Horse("Pony", 8)));
//        racingHorses.add(new Thread(new Horse("Steed", 12)));


