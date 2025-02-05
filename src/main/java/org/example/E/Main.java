package org.example.E;

/**
 * @author
Thread.yield
This static method is essentially used to notify the system that the current thread is willing to "give up the CPU" for a while.
The general idea is that:
The thread scheduler will select a different thread to run instead of the current one.
 *
 *javamex
 */

/*ordonnanceur(scheduler)  --->  JVM ----> threads*/

public class Main {

    public static void main(String[] args) {
        Thread producer, consumer ;

        producer = new Thread() {
            public void run()
            {
                for (int i = 0 ; i < 4 ; i++ )
                {
                    System.out.println("producer" + i);

                }

            }
        };

        consumer = new Thread( new Runnable() {

            @Override
            public void run() {
                for (int i = 0 ; i < 4 ; i++ )
                {
                    //yield = i gime my place to another thread after me (ysma7 fi 79o)
                    Thread.yield();
                    System.out.println("consumer " + i);
                }
            }
        }) ;

        //the results of priority + yield is randomly unfortunately
        producer.setPriority(Thread.MIN_PRIORITY);
        consumer.setPriority(Thread.MAX_PRIORITY);

       // producer.start();
        consumer.start();

		System.out.println("====MAIN===1");
		System.out.println("====MAIN===2");
		System.out.println("====MAIN===3");


    }

}