package model.human.comparators;

import model.tree.humanGroup.HumanGroupItem;

import java.util.Comparator;

public class HumanComparatorAge<E extends HumanGroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }


}
