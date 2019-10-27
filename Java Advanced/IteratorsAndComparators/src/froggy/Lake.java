package froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lake implements Iterable {
    private List<Integer> lakeNumbers;
    private List<Integer> result;
    private int startIndex = 0;

    public Lake(List<Integer> nums) {
        this.lakeNumbers = nums;
        this.result = new LinkedList<>();
    }

    private List<Integer> getFrogJumps() {
        List<Integer> frogJumps = new LinkedList<>();
        for (int i = startIndex; i < this.lakeNumbers.size(); i += 2) {
            frogJumps.add(lakeNumbers.get(i));
        }
        return frogJumps;
    }

    private List<Integer> getLakeNumber() {
        List<Integer> lakeNumber = new LinkedList<>();
        for (int i = startIndex + 1; i < this.lakeNumbers.size(); i += 2) {
            lakeNumber.add(lakeNumbers.get(i));
        }
        return lakeNumber;
    }

    public List<Integer> getResult() {
        this.result.addAll(getFrogJumps());
        this.result.addAll(getLakeNumber());
        return this.result;
    }

    @Override
    public Iterator iterator() {
        return new LakeIterator();
    }

    private class LakeIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index >= 0 && index < result.size();
        }

        @Override
        public Integer next() {
            return result.get(index++);
        }
    }
}
