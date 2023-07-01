package org.vaadin.example;

import com.google.gson.Gson;

public class Berry {
    private String name;
    private int id;
    private int size;

    public Berry() {
    }

    public Berry(String name, int id, int size) {
        this.name = name;
        this.id = id;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Berry{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", size=" + size +
                '}';
    }
    public String montarJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
