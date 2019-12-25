package com.trains.distance;


import com.trains.model.Point;
import com.trains.model.Route;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinLengthDistance extends AbstractProcess {


    public MinLengthDistance(List<Route> routes, String pointText) {
        super(routes, pointText);
    }

    @Override
    public String compute(Point[] points) {
        checkArgument(points);
        Point begin = points[0];
        Point end = points[1];
        List<Route> copyRoute = copy();
        List<Route> routes = screenBegin(copyRoute, begin);
        int number = -1;
        while (routes.size() != 0) {
            copyRoute.removeAll(routes);
            Route minRoute = routes.stream().filter(route -> route.getTo().getName()
                    .equals(end.getName())).min(Comparator.naturalOrder()).orElse(null);
            routes.removeAll(routes.stream().filter(route -> route.getTo().getName()
                    .equals(end.getName())).collect(Collectors.toList()));
            if (minRoute != null) {
                if (number != -1) {
                    number = number > minRoute.getLength() ? minRoute.getLength() : number;
                } else {
                    number = minRoute.getLength();
                }
            }

            routes = screeningAvailableAndLength(routes, copyRoute);

        }
        return String.valueOf(number);
    }
}
