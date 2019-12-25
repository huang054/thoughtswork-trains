package com.trains.distance;


import com.trains.model.Point;
import com.trains.model.Route;

import java.util.List;
import java.util.Optional;

public class FixedDistance extends AbstractProcess {

    public FixedDistance(List<Route> routes, String pointText) {
        super(routes, pointText);
    }

    @Override
    public String compute(Point[] points) {

        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("参数不合法");
        }
        int sum = 0;
        Route currRoute = new Route(null, null, 0);
        int i = 0;
        while (currRoute != null && i < points.length - 1) {
            Point pointLeft = points[i];
            Point pointRight = points[i + 1];
            Route route = findMatchRoute(pointLeft, pointRight);
            if (route != null) {
                i++;
                sum += route.getLength();
            }
            currRoute = route;

        }
        if (i == points.length - 1) {
            return String.valueOf(sum);
        } else {
            return "NO SUCH ROUTE";
        }

    }


}
