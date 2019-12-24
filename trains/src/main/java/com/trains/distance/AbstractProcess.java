package com.trains.distance;



import com.trains.model.Point;
import com.trains.model.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractProcess implements DistanceInterface{

    private final List<Route> routes;

    private final String pointText;

    protected AbstractProcess(List<Route> routes, String pointText) {
        this.routes = routes;
        this.pointText = pointText;
    }


    @Override
    public Point[] pointProcess() {
        String[] pointName=pointText.split("-");
        Point[] points=new Point[pointName.length];
        for (int i=0;i<pointName.length;i++){
            points[i]=new Point(pointName[i]);
        }
        return points;
    }

    public List<Route> screeningAvailable(List<Route> target){
        List<Route> available = new ArrayList<>();
        target.stream().forEach(route -> {
            List<Route> routeList=routes.stream().filter(route1 -> route1.getFrom().getName()
                    .equals(route.getTo().getName())).collect(Collectors.toList());
            available.addAll(routeList);
        });
        return available;

    }

    public void checkArgument(Point[] points){
        if (points==null||points.length!=2){
            throw new IllegalArgumentException("参数不合法");
        }
    }

    public List<Route> screenBegin(Point begin){
        return screenBegin(routes,begin);
    }
    public List<Route> screenBegin(List<Route> copyRoute,Point begin){
        return copyRoute.stream().filter(route ->
                route.getFrom().getName().equals(begin.getName()))
                .collect(Collectors.toList());
    }


    public List<Route> screenEnd(List<Route> routesList,Point end){
        return routesList.stream().filter(route ->
                route.getTo().getName().equals(end.getName()))
                .collect(Collectors.toList());
    }

    public List<Route> copy(){
        List<Route> copyRoute=new ArrayList<>(routes.size());
        routes.forEach(route -> {
            copyRoute.add(new Route(route.getFrom(),route.getTo(),route.getLength()));
        });
        return copyRoute;
    }
    public List<Route> screeningAvailableAndLength(List<Route> target,List<Route> copyRoutes){
        List<Route> available = new ArrayList<>();
        target.stream().forEach(route -> {
            List<Route> routeList=copyRoutes.stream().filter(route1 -> route1.getFrom().getName()
                    .equals(route.getTo().getName())).collect(Collectors.toList());
            routeList.forEach(route1 -> route1.setLength(route.getLength()+route1.getLength()));
            available.addAll(routeList);
        });
        return available;
    }

    public List<Route> screeningAvailableNumber(List<Route> target,List<Route> copyRoutes){
        List<Route> available = new ArrayList<>();
        target.stream().forEach(route -> {
            List<Route> routeList=copyRoutes.stream().filter(route1 -> route1.getFrom().getName()
                    .equals(route.getTo().getName())).collect(Collectors.toList());
            routeList.forEach(route1 ->{
                available.add(new Route(route1.getFrom(),route1.getTo(),route.getLength()+route1.getLength()));
            });

        });
        return available;
    }

    public Optional<Route> findMatchRoute(Point pointLeft, Point pointRight){
       return routes.stream().filter(address2 -> address2.getFrom().getName().equals(pointLeft.getName())
                &&address2.getTo().getName().equals(pointRight.getName())).findFirst();
    }

}
