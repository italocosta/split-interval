package eurocontrol.splitinterval.service;

import eurocontrol.splitinterval.model.Interval;

import java.util.ArrayList;
import java.util.List;

public class SplitIntervalService {

    public List<Interval> splitInterval(List<Interval> originalInterval, Interval interval) {
        List<Interval> resultInterval = new ArrayList<>();
        for(Interval currentInterval : originalInterval) {
            if(isCompleteOutOfTheInterval(interval,currentInterval)) {
                resultInterval.add(currentInterval);
            } else {
                if (isCompleteInsideOfTheInterval(interval, currentInterval)) {
                    if (!resultInterval.contains(interval)) {
                        resultInterval.add(interval);
                    }
                } else if (isCompleteInsideOfTheInterval(currentInterval, interval)) {
                    resultInterval.add(new Interval(currentInterval.getStart(), interval.getStart() - 1));
                    if (!resultInterval.contains(interval)) {
                        resultInterval.add(interval);
                    }
                    resultInterval.add(new Interval(interval.getEnd() + 1, currentInterval.getEnd()));
                } else if (currentInterval.getStart() <= interval.getStart()) {
                    resultInterval.add(new Interval(currentInterval.getStart(), interval.getStart() - 1));
                    if (!resultInterval.contains(interval)) {
                        resultInterval.add(interval);
                    }
                } else {
                    if (!resultInterval.contains(interval)) {
                        resultInterval.add(interval);
                    }
                    resultInterval.add(new Interval(interval.getEnd() + 1, currentInterval.getEnd()));
                }
            }
        }
        return resultInterval;
    }

    private boolean isCompleteOutOfTheInterval(Interval baseInterval, Interval currentInterval) {
        return (currentInterval.getStart() < baseInterval.getStart() && currentInterval.getEnd() < baseInterval.getStart())
                || (currentInterval.getStart() > baseInterval.getEnd() && currentInterval.getEnd() > baseInterval.getEnd());
    }

    private boolean isCompleteInsideOfTheInterval(Interval baseInterval, Interval currentInterval) {
        return currentInterval.getStart() >= baseInterval.getStart() && currentInterval.getEnd() <= baseInterval.getEnd();
    }
}
