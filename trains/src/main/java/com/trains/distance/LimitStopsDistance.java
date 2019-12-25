package com.trains.distance;


import com.trains.model.Point;
import com.trains.model.Route;

import java.util.List;


public class LimitStopsDistance extends AbstractProcess {

    private final int limitNumber;

    public LimitStopsDistance(List<Route> routes, String pointText, int limitNumber) {

        super(routes, pointText);
        this.limitNumber = limitNumber;
    }

    @Override
    public String compute(Point[] points) {
        checkArgument(points);
        Point begin = points[0];
        Point end = points[1];
        List<Route> routes = screenBegin(begin);
        int count = 0;
        int number = 0;
        while (routes.size() != 0 && number < limitNumber) {
            number++;
            List<Route> screen = screenEnd(routes, end);
            count += screen.size();
            routes = screeningAvailable(routes);

        }
        return String.valueOf(count);
    }


}
