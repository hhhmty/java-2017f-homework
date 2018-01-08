
import javax.swing.JFrame;


 final class Ground extends JFrame {

    private final int OFFSET = 10;


    public Ground() {
        InitUI();
    }

    public void InitUI() {
        Huluwa[] brothers = new Huluwa[7];
        for (int i = 0; i <7 ; i++) {
            brothers[i]=new Huluwa(NAME.values()[i], COLOR.values()[i],100);

        }
        Littlesoldier[] soldiers=new Littlesoldier[8];
        for (int i = 0; i <8 ; i++) {
            soldiers[i]=new Littlesoldier(20);
        }
        Scorpion scorpion=new Scorpion(60);
        Snake snake=new Snake(200);
        Grandpa grandpa=new Grandpa(70);
        Warqueue justice=new Warqueue(brothers);
        justice.addone(grandpa);
        Warqueue evil=new Warqueue(soldiers);
        evil.addone(scorpion);evil.addone(snake);
        Yanxing changshe=new Yanxing(10,5);
        changshe.arraystart(justice);
        Yanxing yanxing=new Yanxing(0,3);
        yanxing.arraystart(evil);
        Field field = new Field(evil,justice);
        add(field);
        field.insert(evil);
        field.insert(justice);
        Paint paint=new Paint(field);
        new Thread(paint).start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(field.getBoardWidth() + OFFSET,
                field.getBoardHeight() + 2 * OFFSET);
        setLocationRelativeTo(null);
        setTitle("Ground");
    }
}

class Paint implements Runnable{
    Field field;
     Paint(Field field){this.field=field;}
     public void run(){
try {
while (!Thread.interrupted())
{
       field.repaint();
    Thread.sleep(400);}
    }
    catch (Exception e){}
}
 }

public class Main {
    public static void main(String[] args) {


        Ground ground = new Ground();
        ground.setVisible(true);

    }
}


