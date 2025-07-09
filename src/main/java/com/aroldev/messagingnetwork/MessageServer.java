package com.aroldev.messagingnetwork;

import java.util.Queue;

public class MessageServer implements Runnable {
    public Queue<Message> queue;

    public MessageServer(Queue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    Message msg = queue.poll();
                    System.out.println("Procesando mensaje: " + msg.getContent());
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Servidor interrumpido.");
                break;
            }
        }
    }
}
