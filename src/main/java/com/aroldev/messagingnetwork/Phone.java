package com.aroldev.messagingnetwork;

import com.aroldev.messagingnetwork.Enum.MessageType;
import com.aroldev.messagingnetwork.Interfaces.Exportable;

import java.util.List;
import java.util.ArrayList;

public class Phone extends Device implements Exportable<List<String>> {
    private Message[] historial;
    private int capacity;
    private int indice = 0;

    public Phone(String name, int id, int capacity) {
        super(name, id);
        this.capacity = capacity;
        this.historial = new Message[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void sendMessage(Message msg) {
        try {
            validateMessage(msg);
            System.out.println("Enviando mensaje: " + msg.getContent());
            addMessage(msg);
        } catch (InvalidMessageException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void receiveMessage(Message msg) {
        if (msg.getContent() == null || msg.getContent().trim().isEmpty()) return; //No almacenar msg vacios
        if (msg.getType() == MessageType.SYSTEM && !"SYSTEM".equals(getName())) return;//Ignorar mensajes que no vienen de "SYSTEM"
        addMessage(msg);
    }

    private void addMessage(Message msg) {
        historial[indice] = msg;
        indice = (indice + 1) % capacity;
    }

    public Message[] getMessages() {
        return historial;
    }

    @Override
    public List<String> export() {
        List<String> exported = new ArrayList<>();
        for (Message msg : historial) {
            if (msg != null) {
                exported.add(msg.formatDate() + " - " + msg.getContent());
            }
        }
        return exported;
    }

    public <T extends Message> List<T> filterTextMessages() {
        List<T> filtered = new ArrayList<>();
        for (Message msg : historial) {
            if (msg != null && msg.getType() == MessageType.TEXT) {
                filtered.add((T) msg);
            }
        }
        return filtered;
    }

    private void validateMessage(Message msg) throws InvalidMessageException {
        if (msg.getContent() == null || msg.getContent().trim().length() < 2
                || (msg.getType() == MessageType.SYSTEM && !"SYSTEM".equals(getName()))) {
            throw new InvalidMessageException("Mensaje inválido: contenido nulo o demasiado corto.");
        }
    }
}




