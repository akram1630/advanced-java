package org.example.C;


public class Ex2_lievre extends Thread{
    private int distance_lievre ;
    private int maxDistance ;// distance maximal � parcourir

    public Ex2_lievre(int maxDistance )
    {
        this.distance_lievre = 0 ;
        this.maxDistance = maxDistance ;
    }

    //thread lievre
    public void run()
    {
        while ( distance_lievre < maxDistance ) {
            System.out.println("=> distance Lievre : " + distance_lievre + "m !");
            distance_lievre++;
            try {
                Thread.sleep(300);
            }catch(InterruptedException e ){}

            if ( distance_lievre == (maxDistance/2) ) {
                System.out.println("===> lievre : Bon je vais dormir un petit peu ! ");
                try {
                    sleep(10000); //10 secs
                }catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println(" *****arriv� du lievre*****");

    }
}
