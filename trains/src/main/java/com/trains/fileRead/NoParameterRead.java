package com.trains.fileRead;

import com.trains.model.RouteInAndOut;

import java.util.List;

public class NoParameterRead implements InAndOutRead{
    @Override
    public RouteInAndOut readInAndOut(String text) {
        return new RouteInAndOut(text,0);
    }
}
