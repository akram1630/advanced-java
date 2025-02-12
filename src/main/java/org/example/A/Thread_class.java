package org.example.A;


public class Thread_class {

    public static void main (String args[]) {

        //creating threads :
        Ecrit e1 = new Ecrit (" <1>","A", 4, 200) ;
        Ecrit e2 = new Ecrit (" <2>","B", 4, 200) ;
        Ecrit e3 = new Ecrit (" <3>","C", 10, 200) ;


        //MultiThreading : (pseudo parallilism)
        e1.start() ;
        e2.start() ;
        e3.start() ;

       // new java.util.Scanner(System.in).nextLine() ;

         //as we see in theory , .run execute in principal Pile
         //sequencial , no multiThreading
//         e1.run() ;
//         e2.run() ;
//         e3.run() ;
    }
}





class Ecrit extends Thread {

    private String texte ;
    private String texte2 ;
    private int nbrIteration ; //nombre de fois à executer (boucle)
    private long attenteTemps ;

    public Ecrit (String texte , String texte2, int nbrIteration, long attenteTemps) {
        this.texte = texte ;
        this.texte2 = texte2 ;
        this.nbrIteration = nbrIteration ;
        this.attenteTemps = attenteTemps ;
    }

    public void run () {
        try {
            for (int i=0 ; i<nbrIteration ; i++) {
                System.out.print (texte+texte2) ;
                Thread.sleep (attenteTemps) ; // temorary
            }
        }catch (InterruptedException e) {} //imposed by "sleep"
    }
}

