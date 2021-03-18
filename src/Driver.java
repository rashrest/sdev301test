public class Driver {


    public static void main(String[] args) throws InterruptedException {

        ApplicationQueue queue = new ApplicationQueue();
        final int APPLICANT_THREADS =3;
        final int CREDIT_THREADS=2;




        Thread [] addThreadsApply = new Thread[APPLICANT_THREADS];
        for (int i = 0; i < addThreadsApply.length; i++) {

            addThreadsApply[i] = new Thread(new Applicants(queue));
            addThreadsApply[i].start();
            addThreadsApply[i].join();
        }

        Thread [] removeThread = new Thread[CREDIT_THREADS];
        for (int i = 0; i < removeThread.length; i++) {

            removeThread[i] = new Thread(new CreditCompany(queue));
            removeThread[i].start();
            removeThread[i].join();
        }



    }
}
