package ru.iFellow.model;

import lombok.Data;

@Data
public class Location {
    public String name;
    public String url;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
