import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//设立两个列队，分别代表双方
public class Warqueue {
    List<Character> array = new LinkedList<>();

    Warqueue(Character character[]) {
        for (int i = 0; i < character.length; i++) {
            array.add(character[i]);
        }
    }

    public void addone(Character character) {
        array.add(character);
    }

    public boolean dead() {
        Iterator it = array.iterator();
        while (it.hasNext()) {
            Character c = (Character) it.next();
            if (c.live)
                return false;
        }
        return true;
    }

    public void move(){
        for (int i = 0; i <array.size(); i++) {
            Thread t=new Thread(array.get(i));
            t.start();
        }
    }

}