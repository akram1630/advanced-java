package org.example.G;


//efficace than yield cuz it doesn't specify which thread but join does
public class Join_Test implements Runnable{

    public static void main(String[] args)
    {

        Thread th = new Thread(new Join_Test()) ;

        th.start();
        //concurrency between th.start() and printing instru 1 , 2
        System.out.println(">> Main thread instruction .. 1 ");
        System.out.println(">> Main thread instruction .. 2 ");

        try {         //== wont let the instru 3(end) of main thread work until th finishes
            th.join(); //it does the Sync between 2 threads & it waits the thread until he finishes
        } catch (InterruptedException e) {} /**/
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
        System.out.println(">> Main thread -- end");
    }

    public void run()
    {
        System.out.println("----TH---- BEGIN");
        for(int i=0 ; i<5 ; i++)
        {
            System.out.println(" <"+i+"> ");
            try{Thread.sleep(100);}catch(Exception e){}

        }
        System.out.println("----TH---- END");

    }
}
