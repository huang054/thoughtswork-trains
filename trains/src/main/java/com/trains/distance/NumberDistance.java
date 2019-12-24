package com.trains.distance;



import com.trains.model.Point;
import com.trains.model.Route;

import java.util.List;
import java.util.stream.Collectors;

public class NumberDistance extends AbstractProcess {

    private final int limitLength;

    public NumberDistance(List<Route> routes, String pointText, int limitLength) {
        super(routes, pointText);
        this.limitLength = limitLength;
    }

    @Override
    public String compute(Point[] points) {
        checkArgument(points);
        Point begin=points[0];
        Point end=points[1];
        List<Route> copyRoute=copy();
        List<Route> routes= screenBegin(copyRoute,begin);
        int number=0;
        while (routes.size()!=0){

            number+=routes.stream().filter(route -> route.getTo().getName()
                    .equals(end.getName())&&route.getLength()<limitLength)
                    .collect(Collectors.toList()).size();
            routes=screeningAvailableNumber(routes,copyRoute);
            routes=routes.stream().filter(route -> route.getLength()<limitLength)
                    .collect(Collectors.toList());

        }
        return String.valueOf(number);
    }
}
