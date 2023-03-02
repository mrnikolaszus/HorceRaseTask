public class Horse implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while(!current.isInterrupted()){
            if(Main.getWinner()!=null){current.interrupt();}
            if(distance>=trackDistance){Main.setWinner(this);}
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }
            this.distance = this.distance + this.getSpeed();
            System.out.println(this.getName() + " passed meters: " + this.distance);

        }

       }
    String name;
    int speed;
    int distance;

    int trackDistance;


    public Horse(String name, int speed, Track a){
        this.name = name;
        this.speed = speed;
        this.distance =0;
        this.trackDistance = a.getDistance();


    }
    public String getName() {
        return this.name;
    }


    public int getSpeed() {
        return this.speed;
    }


}
