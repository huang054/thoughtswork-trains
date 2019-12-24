package com.trains.model;

public class RouteInAndOut {

    private final String Input;

    private final int controlParameter;



    public RouteInAndOut(String input, int controlParameter) {
        Input = input;
        this.controlParameter = controlParameter;

    }

    public RouteInAndOut(String input){
        this(input,0);
    }

    public String getInput() {
        return Input;
    }

    public int getControlParameter() {
        return controlParameter;
    }


}
