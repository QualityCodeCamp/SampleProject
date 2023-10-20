package com.Helper;

public enum GestureDirection {

    LEFT("left"),
    RIGHT("right"),
    UP("up"),
    DOWN("down");

    private final String action;

    private GestureDirection(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

}
