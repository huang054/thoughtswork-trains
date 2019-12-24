package com.trains.distance;



import com.trains.model.Point;
import com.trains.model.Route;

import java.util.List;

public class FixedStopsDistance extends AbstractProcess {

    private final int fixedNumber;

    public FixedStopsDistance(List<Route> routes, String pointText, int fixedNumber) {

        super(routes, pointText);
        this.fixedNumber=fixedNumber;
    }

    @Override
    public String compute(Point[] points) {
        checkArgument(points);
        Point begin=points[0];
        Point end=points[1];
        List<Route> routes= screenBegin(begin);
        int number=0;
        while (routes.size()!=0){
            number++;
            List<Route> screen=screenEnd(routes,end);
            if (number==fixedNumber){
                return String.valueOf(screen.size());
            }
            routes=screeningAvailable(routes);

        }
        return String.valueOf(0);
    }

}
