package iteratorsandcombination;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {
    private ArrayList itemMenus;
    private int position = 0;

    public PancakeHouseMenuIterator(ArrayList itemMenus) {
        this.itemMenus = itemMenus;
    }

    @Override
    public boolean hasNext() {
        return position < itemMenus.size();
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) itemMenus.get(position);
        position = position + 1;
        return menuItem;
    }
}
