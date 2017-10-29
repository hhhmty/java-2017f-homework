import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class sort {
    public void shuffle(huluwa[] c) {
        Random rnd = ThreadLocalRandom.current();
        for (int i =0; i <c.length; i++)
        c[i] = new huluwa(NAME.values()[i], COLOR.values()[i]);
        for (int i =c.length - 1; i >= 0; i--) {
                         int index = rnd.nextInt(i + 1);
                         NAME name=c[index].getname();COLOR color=c[index].getColor();
            c[index]=new huluwa(c[i].getname(), c[i].getColor());
            c[i]=new huluwa(name, color);
                   }
            }

    public void bubble(huluwa[] man){
    for (int i=0;i<man.length-1;i++){
        for (int j=0;j<man.length-1-i;j++){
            if(man[j].getname().ordinal() >man[j + 1].getname().ordinal()){
                NAME name=man[j].getname();COLOR color=man[j].getColor();
                man[j]=new huluwa(man[j+1].getname(), man[j+1].getColor());
                man[j+1]=new huluwa(name, color);
            }
        }
    }
}
}
