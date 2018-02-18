package com.sdabyd2.watki;

public class Notifier implements Runnable {

    private Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        try {
            Thread.sleep(1000);
            synchronized (message) {
                message.setMessage(name + " skonczyl prace");
                message.notifyAll();
            }
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
