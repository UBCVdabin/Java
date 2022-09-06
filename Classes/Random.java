package Classes;

import Commons.Util;

public class Random {
    private int seed;
    public Random(int _seed) {
        this.seed = _seed;
    }

    public int getSeed() {
        return seed;
    }
    public void setSeed(int seed) {
        this.seed = seed;
    }

    public int nextInt(int high) {
        if (seed == 0) {
            return -1;
        }
        else {
            seed--;
            return Util.RandInt(0, high);
        }   
    }
    
}
