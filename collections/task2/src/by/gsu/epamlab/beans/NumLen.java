package by.gsu.epamlab.beans;

public class NumLen implements Comparable<NumLen> {
    private final int len;
    private int num;

    public NumLen(int len) {
        this.len = len;
        this.num = 1;
    }

    public void increaseNum() {
        this.num++;
    }

    public int getLen() { return len; }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return String.format("%d;%d", len, num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final NumLen numLen = (NumLen) o;
        if (len != numLen.len) return false;
        numLen.num++;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = len;
        result = PRIME * result + num;
        return result;
    }

    @Override
    public int compareTo(NumLen numLen) {
        int diff = len - numLen.len;
        /*if(diff == 0) {
            numLen.num++;
        }*/
        return diff;
    }
}
