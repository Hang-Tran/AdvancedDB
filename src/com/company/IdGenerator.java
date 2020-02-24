package com.company;

public class IdGenerator {

    public static String makeNewId() {
        String id = "";
        for (int i = 0; i < 5; i++) {
            id = id.concat(String.valueOf(new java.util.Random().nextInt(9)));
        }
        return id;
    }
}
