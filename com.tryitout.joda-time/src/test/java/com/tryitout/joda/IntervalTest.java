package com.tryitout.joda;

import org.hamcrest.Matcher;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.*;


public class IntervalTest {

    private static DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
         @Ignore
    @Test
    public void shouldDevideWhenRageContainedWithin() {
        //given
        DateTime start = fmt.parseDateTime("2012-10-07");
        DateTime end = fmt.parseDateTime("2012-12-27");

        DateTime thisStart = fmt.parseDateTime("2012-11-01");
        DateTime thisEnd = fmt.parseDateTime("2012-11-30");

        //when
        List<Interval> shouldBe = new ArrayList<Interval>();
        shouldBe.add(new Interval(fmt.parseDateTime("2012-10-07"),fmt.parseDateTime("2012-10-31")));
        shouldBe.add(new Interval(fmt.parseDateTime("2012-11-01"),fmt.parseDateTime("2012-11-30")));
        shouldBe.add(new Interval(fmt.parseDateTime("2012-12-01"),fmt.parseDateTime("2012-12-27")));

        List<Interval> result = PeriodParser.parsePeriod(new Interval(start,end),new Interval(thisStart,thisEnd));

        //then
        for(Iterator<Interval> i = result.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        assertTrue(result.containsAll(shouldBe));
        assertTrue(shouldBe.containsAll(result));
    }
    @Test
    public void shouldDevideWhenThisStartBeforeStart() {
        //given
        DateTime start = fmt.parseDateTime("2012-10-07");
        DateTime end = fmt.parseDateTime("2012-12-27");

        DateTime thisStart = fmt.parseDateTime("2012-10-01");
        DateTime thisEnd = fmt.parseDateTime("2012-10-31");

        //when
        List<Interval> shouldBe = new ArrayList<Interval>();
        shouldBe.add(new Interval(fmt.parseDateTime("2012-10-01"),fmt.parseDateTime("2012-10-31")));
        shouldBe.add(new Interval(fmt.parseDateTime("2012-11-01"),fmt.parseDateTime("2012-12-27")));

        List<Interval> result = PeriodParser.parsePeriod(new Interval(start,end),new Interval(thisStart,thisEnd));

        //then
        for(Iterator<Interval> i = result.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        assertTrue(result.containsAll(shouldBe));
        assertTrue(shouldBe.containsAll(result));
    }

     @Ignore
    @Test
    public void testInterval() {

        DateTime startDate = fmt.parseDateTime("2012-10-07");
        DateTime endDate = fmt.parseDateTime("2012-11-23");
        System.out.println(startDate);
        System.out.println(endDate);
        Interval interval = new Interval(startDate, endDate);

        Interval interval2 = new Interval(fmt.parseDateTime("2012-11-01"), fmt.parseDateTime("2012-11-30"));
        Interval interval3 = new Interval(fmt.parseDateTime("2012-11-01"), fmt.parseDateTime("2012-11-30"));
        System.out.println(interval2.equals(interval3));

        Interval overlap = interval.overlap(interval2);
        System.out.println(overlap);
        System.out.println(interval.gap(interval2));
        System.out.println(overlap.overlap(interval2));
        System.out.println(overlap.gap(interval2));

    }
}
