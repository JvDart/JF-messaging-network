package com.aroldev.messagingnetwork;

import com.aroldev.messagingnetwork.Exceptions.InvalidMessageException;

abstract public class Device {
    private String name;
    private int id;
    private boolean darkMode;


    abstract public void sendMessage(Message msg) throws InvalidMessageException;
    abstract public void receiveMessage(Message msg);

    public Device(String name, int id) {
        this.name = name;
        this.id = id;
        this.darkMode = false;
    }

    public boolean getDarkMode() {return darkMode; }

    public void setDarkMode(boolean darkmode) {
        this.darkMode = darkmode;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }


}
