package com.trains.process;


import com.trains.distance.DistanceInterface;

public class DistanceProcess {

    private final DistanceInterface distanceInterface;

    public DistanceProcess(DistanceInterface distanceInterface) {
        this.distanceInterface = distanceInterface;
    }

    public String compute(){
        return distanceInterface.compute(distanceInterface.pointProcess());
    }
}
