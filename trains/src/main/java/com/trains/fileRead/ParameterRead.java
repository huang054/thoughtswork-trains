package com.trains.fileRead;

import com.trains.model.RouteInAndOut;

public class ParameterRead implements InAndOutRead{
    @Override
    public RouteInAndOut readInAndOut(String text) {
        String[] strings=text.split(",");
        return new RouteInAndOut(strings[0],Integer.parseInt(strings[1]));
    }
}
