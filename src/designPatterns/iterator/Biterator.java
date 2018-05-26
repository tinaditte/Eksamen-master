package designPatterns.iterator;

import java.util.Iterator;

public class Biterator implements Iterator<Boolean>{
    private int current;

    public Biterator(int current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        //Tjekker om vi har flere bits tilbage
        return (current != 0);
    }

    @Override
    public Boolean next() {
        //Finder mindste bit, og fjerner den
        if (current % 2 == 0) {
            current = current / 2;
            return false;
        }
        current = current / 2;
        return true;
    }
}
