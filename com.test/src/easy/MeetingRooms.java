package easy;

import common.Interval;

import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt((Interval a) -> a.start));
        Interval[] intervalsarray = (Interval[]) intervals.toArray();
        for (int i = 1; i < intervalsarray.length; i++) {
            if (intervalsarray[i - 1].end > intervalsarray[i].end) {
                return false;
            }
        }
        return true;
    }
}
