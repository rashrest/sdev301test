import java.util.concurrent.locks.ReentrantLock;

public class Application {
    private static int nextId = 10000;//should have minimum of 5 digits which means minimum value is 10000
    private static ReentrantLock counterLock = new ReentrantLock();
    private int applicationId; //increment value by 1
    private int creditScore;
    private int requestLimit;
    private boolean approved;
    private int approvedLimit;


    public Application(int creditScore, int requestLimit) {
        this.creditScore = creditScore;
        this.requestLimit = requestLimit;
        applicationId=getNextId();
    }

    public static int getNextId(){

        counterLock.lock();

        //enclosing locks in a try-finally block
        try{
           return nextId++;
        }finally{
            counterLock.unlock();
        }
    }

    public int getApplicationId() {
        return applicationId;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public int getRequestLimit() {
        return requestLimit;
    }

    public boolean isApproved() {
        return approved;
    }

    public int getApprovedLimit() {
        return approvedLimit;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setRequestLimit(int requestLimit) {
        this.requestLimit = requestLimit;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
