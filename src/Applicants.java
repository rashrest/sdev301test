import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Applicants implements Runnable{

    private ApplicationQueue mySharedQueue;
    private Lock lock= new ReentrantLock();



    public Applicants(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }



    @Override
    public void run() {

        Application app = new Application(getRandomNumber(300, 850), getRandomNumber(5000, 50000));

            mySharedQueue.addApplication(app);
            Thread.currentThread().setName("P1");
        System.out.println(Thread.currentThread().getName() + "started!");
            System.out.println(Thread.currentThread().getName() + " : created application #" +app.getApplicationId());
            if(flipCoin()){
                try {
                    Thread.sleep(getRandomNumber(100,1200));
                    System.out.println(Thread.currentThread().getName() + "finished!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }





//        Application[] app = new Application[3];
//        for (int i = 1; i < 4; i++) {
//
//
//            Thread.currentThread().setName("P" + i);
//            app[i] = new Application(getRandomNumber(300, 850), getRandomNumber(5000, 50000));
//            mySharedQueue.addApplication(app[i]);
//            System.out.println(Thread.currentThread().getName() + " : created application #" + app[i].getApplicationId());
//            if (flipCoin()) {
//                try {
//                    Thread.sleep(getRandomNumber(100, 1200));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        }





    public  int getRandomNumber(int min, int max){

            return (int) ((Math.random() * (max - min)) + min);

    }

    public  boolean flipCoin() {

            if (Math.random() < 0.5) {
                // Its a head and delay is indicated
                return true;
            }
        else

            //its tail, no delay indicated
        return false;
    }
}
