package com.aroldev.messagingnetwork;

import java.util.LinkedList;
import java.util.Queue;

public class MessageServer implements Runnable {
    private final Queue<Message> messageQueue;


    // Constructor sin argumentos requerido por el test
    public MessageServer() {
        this.messageQueue = new LinkedList<>();
    }

    public MessageServer(Queue<Message> queue) {
        this.messageQueue = queue;
    }


    // Metodo requerido por el test
    public synchronized void addMessage(Message msg) {
        synchronized (messageQueue) {
            messageQueue.add(msg);
        }
    }


    @Override
    public void run() {
        while (true) {
            synchronized (messageQueue) {
                if (!messageQueue.isEmpty()) {
                    Message msg = messageQueue.poll();
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
