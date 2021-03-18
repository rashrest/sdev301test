import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CreditCompany implements Runnable{

    private  ApplicationQueue mySharedQueue;
    //create a lock
    private Lock lock = new ReentrantLock();
    //create condition
//    private Condition condition = lock.newCondition();

    public CreditCompany(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    @Override
    public void run(){
        Application app=mySharedQueue.removeApplication();

        Thread.currentThread().setName("C1");
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        app.setApprovedLimit(approvedLimit(app.getCreditScore()));


            if (app.getApprovedLimit() != 0){
                app.setApproved(true);
                System.out.println(Thread.currentThread().getName() + ": Application " + app.getApplicationId() + " with credit" +
                        " score " + app.getCreditScore() + " is " + "approved" + " for " + app.getApprovedLimit() + " (requested : " +
                        app.getRequestLimit() + ")");

            }
            else if(app.getApprovedLimit() == 0) {
                app.setApproved(false);
                System.out.println(Thread.currentThread().getName() + ": Application " + app.getApplicationId() + " with credit" +
                        " score " + app.getCreditScore() + " is " + "not approved.");

            }
        }



    public synchronized int approvedLimit(int creditScore) {

            if (creditScore >= 580 && creditScore <= 669) {
                return 5000;
            } else if (creditScore >= 670 && creditScore <= 739) {
                return 10000;
            } else if (creditScore >= 740 && creditScore <= 799) {
                return 25000;
            } else if (creditScore >= 800) {
                return 50000;
            }
            else return 0;

    }


}
