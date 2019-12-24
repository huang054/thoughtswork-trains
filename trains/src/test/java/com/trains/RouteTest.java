package com.trains;


import com.trains.distance.*;
import com.trains.fileRead.InAndOutRead;
import com.trains.fileRead.NoParameterRead;
import com.trains.fileRead.ParameterRead;
import com.trains.model.Route;
import com.trains.model.RouteInAndOut;
import com.trains.process.DistanceProcess;
import com.trains.utils.FileUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class RouteTest
{
    private static List<Route> routeList;

    static {
        routeList= FileUtil.readFileContent("data.txt");

    }

    @Test
    public void fixedDistanceTest(){
        Assert.assertEquals(new DistanceProcess(new FixedDistance(routeList, "A-B-C")).compute(),"9");
        Assert.assertEquals(new DistanceProcess(new FixedDistance(routeList, "A-D")).compute(),"5");
        Assert.assertEquals(new DistanceProcess(new FixedDistance(routeList, "A-D-C")).compute(),"13");
        Assert.assertEquals(new DistanceProcess(new FixedDistance(routeList, "A-E-B-C-D")).compute(),"22");
        Assert.assertEquals(new DistanceProcess(new FixedDistance(routeList, "A-E-D")).compute(),"NO SUCH ROUTE");

    }

    @Test
    public void limitStopsDistanceTest(){
        Assert.assertEquals(new DistanceProcess(new LimitStopsDistance(routeList, "C-C",3)).compute(),"2");
    }
    @Test
    public void fixedStopsDistanceTest(){
        Assert.assertEquals(new DistanceProcess(new FixedStopsDistance(routeList, "A-C",4)).compute(),"3");
    }

    @Test
    public void minLengthDistanceTest(){
        Assert.assertEquals(new DistanceProcess(new MinLengthDistance(routeList, "A-C")).compute(),"9");
        Assert.assertEquals(new DistanceProcess(new MinLengthDistance(routeList, "B-B")).compute(),"9");
    }
    @Test
    public void numberDistanceTest(){
        Assert.assertEquals(new DistanceProcess(new NumberDistance(routeList, "C-C",30)).compute(),"7");
    }

    @Test
    public void outPut(){
        InAndOutRead noParameter=new NoParameterRead();
        InAndOutRead parameter=new ParameterRead();
        List<RouteInAndOut> fixedDistance=FileUtil.readFileContent("fixedDistance.txt",noParameter);
        List<RouteInAndOut> limitStopsDistance=FileUtil.readFileContent("limitStopsDistance.txt",parameter);
        List<RouteInAndOut> fixedStopsDistance=FileUtil.readFileContent("fixedStopsDistance.txt",parameter);
        List<RouteInAndOut> minLengthDistance=FileUtil.readFileContent("minLengthDistance.txt",noParameter);
        List<RouteInAndOut> numberDistance=FileUtil.readFileContent("numberDistance.txt",parameter);
        fixedDistance.forEach(distance->{
            System.out.println(new DistanceProcess(new FixedDistance(routeList, distance.getInput())).compute());
        });
        limitStopsDistance.forEach(distance->{
            System.out.println(new DistanceProcess(new LimitStopsDistance(routeList, distance.getInput(),distance.getControlParameter())).compute());
        });
        fixedStopsDistance.forEach(distance->{
            System.out.println(new DistanceProcess(new FixedStopsDistance(routeList, distance.getInput(),distance.getControlParameter())).compute());
        });
        minLengthDistance.forEach(distance->{
            System.out.println(new DistanceProcess(new MinLengthDistance(routeList, distance.getInput())).compute());
        });
        numberDistance.forEach(distance->{
            System.out.println(new DistanceProcess(new NumberDistance(routeList, distance.getInput(),distance.getControlParameter())).compute());
        });

    }


}
