package com.epam.jtc.zlobin.semaphore;

public class AudioChannel {
    private int сhannellId;

    public AudioChannel(int id) {
        super();
        this.сhannellId = id;
    }

    public int getСhannellId() {
        return сhannellId;
    }

    public void setСhannellId(int id) {
        this.сhannellId = id;
    }

    public void using() {
        try {   // использование канала
            Thread.sleep(new java.util.Random().nextInt(200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}