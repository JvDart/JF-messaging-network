package com.aroldev.messagingnetwork;

abstract public class Device {
    private String name;
    private int id;
    private boolean darkmode;


    abstract public void sendMessage(Message msg);
    abstract public void receiveMessage(Message msg);

    public Device(String name, int id) {
        this.name = name;
        this.id = id;
        this.darkmode = darkmode;
    }

    public boolean isDarkmode() {return darkmode; }

    public void setDarkmode(boolean darkmode) {
        this.darkmode = darkmode;
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
