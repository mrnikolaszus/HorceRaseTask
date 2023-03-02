public class Horse implements Runnable {
    @Override
    public void run() {

        while(Main.getWinner()==null){

            if(this.distance >= trackDistance ){
                if(this.distance > trackDistance){

                Main.setWinner(this);
                    System.out.println(Main.getWinner().getName() + " was the first who cross finish and "+ Main.getWinner().getName() +" is RACE WINNER ");}
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception ignored");
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
