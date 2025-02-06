package org.example.F;


public class Ex3_SanjiEtNamiJob implements Runnable{

    //used in synchro(key) , when a thread take a key , other threads can't access until it finishes
    final static String key= "FF" ;

    private Ex3_CompteBanque compte = new Ex3_CompteBanque() ;

    @Override
    public void run() {
        for (int i=0 ; i<6 ; i++){ // 6 transaction à titre d'exemple
            System.out.println("i = " + i );
            demandeRetrait(200);
            //System.out.println("name : " + Thread.currentThread().getName());
            if ( compte.getSolde() <= 0 )
                System.out.println("compte à Decouvert ! " + " => " + Thread.currentThread().getName());
        }
    }

    //we synchron the method from declaration or we synchron only apart of code or both
    public /*synchronized*/ void demandeRetrait(int somme) {
        //the two threads sanji and robin share the same object (ressource)(sanji_robin)
        //so for example robin can retirer while  sanji has 0 money and solde will be -200
        // to avoid this we used exclusion mutuelle (synchronized) to this func to be used by one thread
        //synchronized(this) { //this , of this class cuz only when we create only one object (sanji_robin)
        synchronized(key) {

            if ( somme > this.compte.getSolde() )
                System.out.println("=> Pas assez d’argent pour : " + Thread.currentThread().getName());
            else {
                System.out.println(Thread.currentThread().getName() + " est sur le point de retirer.");
                //sleep 1000ms
                try {
                    System.out.println(Thread.currentThread().getName() + " dort!");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                //reveille! ,after 1 second
                System.out.println(Thread.currentThread().getName() + " reveillé.");
                compte.retirer(somme);
                System.out.println(Thread.currentThread().getName() + " à compléter le retrait");
            }
        }

    }
}