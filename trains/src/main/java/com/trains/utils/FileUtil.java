package com.trains.utils;

import com.trains.fileRead.InAndOutRead;

import com.trains.model.Point;
import com.trains.model.Route;
import com.trains.model.RouteInAndOut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<Route> readFileContent(String fileName) {
        File file = new File(FileUtil.class.getResource(System.getProperty("file.separator")+fileName).getFile());
        BufferedReader reader = null;
        List<Route> routes = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            Route route=null;
            while ((tempStr = reader.readLine()) != null) {
               String[] strings= tempStr.split("");
                route = new Route(new Point(strings[0]),new Point(strings[1]),Integer.parseInt(strings[2]));
                routes.add(route);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return routes;
    }

    public static List<RouteInAndOut> readFileContent(String fileName, InAndOutRead inAndOutRead) {
        File file = new File(FileUtil.class.getResource(System.getProperty("file.separator")+fileName).getFile());
        BufferedReader reader = null;
        List<RouteInAndOut> routes = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            RouteInAndOut route=null;
            while ((tempStr = reader.readLine()) != null) {
                route=inAndOutRead.readInAndOut(tempStr);
                routes.add(route);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return routes;
    }


}
