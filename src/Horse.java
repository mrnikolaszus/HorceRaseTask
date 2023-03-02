import java.util.concurrent.CountDownLatch;

public class Horse implements Runnable {
    protected String name;
    protected int speed;
    protected int distance;

    protected int trackDistance;
    protected CountDownLatch countDownLatch;
    protected final Integer HORSE_DELAY = 200;


    public Horse(String name, int speed, Track track, CountDownLatch countDownLatch){
        this.name = name;
        this.speed = speed;
        this.distance = 0;
        this.trackDistance = track.getDistance();
        this.countDownLatch = countDownLatch;

    }
    public String getName() {
        return this.name;
    }


    public int getSpeed() {
        return this.speed;
    }

    @SuppressWarnings("BusyWait")
    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(Main.getWinner()==null){

            if(this.distance >= trackDistance ){
                if(this.distance > trackDistance){
                    Main.setWinner(this);
                    System.out.println(Main.getWinner().getName() + " was the first who cross finish and "+ Main.getWinner().getName() +" is RACE WINNER ");}
                break;
            }

            try {
                Thread.sleep(HORSE_DELAY);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception ignored");
            }
            this.distance += this.getSpeed();
            System.out.println(this.getName() + " passed meters: " + this.distance);

        }

    }
}
