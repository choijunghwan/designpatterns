package org.example.combining.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
    List<Quackable> quackers = new ArrayList<Quackable>();

    public void add(Quackable quackable) {
        quackers.add(quackable);
    }

    @Override
    public void quack() {
        quackers.forEach(Quackable::quack);

//        for (Quackable quacker : quackers) {
//            quacker.quack();
//        }
    }
}
