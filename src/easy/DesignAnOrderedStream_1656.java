package easy;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream_1656 {
//    https://leetcode.com/problems/design-an-ordered-stream/description/
    private final String[] stream;
    private final List<String> orderedStream;
    private int pointer = 0;

    public DesignAnOrderedStream_1656(int n) {
        stream = new String[n];
        orderedStream = new ArrayList<>();
    }

    public List<String> insert(int idKey, String value) {
        orderedStream.clear();
        stream[idKey - 1] = value;
        while (pointer < stream.length && stream[pointer] !=null) {
            orderedStream.add(stream[pointer]);
            pointer++;
        }
        return orderedStream;
    }
}
