package com.tryitout.joda;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.List;

public class PeriodParser {


    public static List<Interval> parsePeriod(Interval period, Interval newPeriod){
        DateTime start =  period.getStart();
        DateTime end =  period.getEnd();
        DateTime thisStart = newPeriod.getStart();
        DateTime thisEnd = newPeriod.getEnd();
        List<Interval> result = new ArrayList<Interval>();
        if(period.contains(newPeriod)){
            Interval overlap =  period.overlap(newPeriod);
            if(overlap!=null){
                DateTime overlStart = overlap.getStart();
                DateTime overlEnd = overlap.getEnd();
                if(thisStart.isAfter(start) && end.isAfter(thisEnd)){
                    result.add(new Interval(start,thisStart.minusDays(1)));
                    result.add(new Interval(thisStart,thisEnd));
                    result.add(new Interval(thisEnd.plusDays(1),end));
                }
            }
        } else if(thisStart.isBefore(start) && thisEnd.isBefore(end)){
            result.add(new Interval(thisStart,thisEnd));
            result.add(new Interval(thisEnd.plusDays(1),end));
        }
        return result;
    }
}
