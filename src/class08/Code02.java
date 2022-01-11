package class08;

import java.util.Arrays;
import java.util.Comparator;

public class Code02 {
    // 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
    // 给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个个具体的项目），你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
    // 返回这个最多的宣讲次数。

    class Program{
        public int start;
        public int end;

        public Program() {
        }

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end; // 小到大
        }
    }

    public int bestArrange(Program[] programs,int timePoint){
        int result = 0;
        Arrays.sort(programs,new ProgramComparator());
        for (int i = 0; i < programs.length ; i++) {
            if (programs[i].start >= timePoint){
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;

    }

}
