package com.sdabyd2.watki;

public class Waiter implements Runnable {

    //referencja
    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                System.out.println("Wątek o nazwie " + name + " zostal powiadomiony o godzinie " +
                        System.currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Wątek waiter otrzymal modyfikacje " +
                    System.currentTimeMillis());
        }

    }


}
