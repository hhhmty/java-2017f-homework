import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Field extends JPanel  {
   //阵地中可以有两阵营相互对立
    public Warqueue leftqueue,rightqueue;

    public static boolean over=false;

    //将阵地布置为map形式，使得每个位置和所在的生物联系在一起

    HashMap<Pixel,Character> battle = new HashMap();

    Line[] row=new Line[20];
    private final int OFFSET = 10;
    private final int SPACE = 30;
    private Character player;
    private int w = 20*SPACE+OFFSET;
    private int h = 20*SPACE+OFFSET;
    private boolean completed = false;

    Field(Warqueue leftqueue,Warqueue rightqueue) {
        addKeyListener(new TAdapter());
        setFocusable(true);
        for (int i = 0; i < row.length; i++)
            row[i] = new Line();
        for (int i = 0; i <row.length; i++) {
            for (int j = 0; j < row[i].cloumn.length; j++) {
                row[i].cloumn[j].setX(j);
                row[i].cloumn[j].setY(i);
                battle.put(row[i].cloumn[j],null);
            }
        }
        this.leftqueue=leftqueue;
        this.rightqueue=rightqueue;
        insert(leftqueue);
        insert(rightqueue);
    }

    public int getBoardWidth() {
        return this.w;
    }

    public int getBoardHeight() {
        return this.h;
    }

    public void buildWorld(Graphics g) {

        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int j = 0; j <20 ; j++) {
            for (int i = 0; i <20 ; i++) {
            if (battle.get(getPixel(i,j))==null) {
                Thing2D item = (Thing2D) getPixel(i,j);
                g.drawImage(item.getImage(), OFFSET+item.x()*SPACE , OFFSET+item.y()*SPACE , this);
            }
            else {
                Thing2D item = (Thing2D) battle.get(getPixel(i,j));
                g.drawImage(item.getImage(), OFFSET+item.x()*SPACE, OFFSET+item.y()*SPACE, this);
            }
            }
        }

            if (completed) {
                g.setColor(new Color(0, 0, 0));
                g.drawString("Completed", 25, 20);
            }

        }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buildWorld(g);
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (completed) {
                return;
            }


            int key = e.getKeyCode();

            if (key==KeyEvent.VK_SPACE)
            {
                leftqueue.move();
                rightqueue.move();
            }


            /*if (key == KeyEvent.VK_LEFT) {


                player.move(-SPACE, 0);

            } else if (key == KeyEvent.VK_RIGHT) {


                player.move(SPACE, 0);

            } else if (key == KeyEvent.VK_UP) {


                player.move(0, -SPACE);

            } else if (key == KeyEvent.VK_DOWN) {


                player.move(0, SPACE);

            } else if (key == KeyEvent.VK_S) {

                new Thread(player).start();

            } else if (key == KeyEvent.VK_R) {
                restartLevel();
            }*/

            repaint();
        }
    }


    public void restartLevel() {

        if (completed) {
            completed = false;
        }
    }


    //将队列放入阵地中
    public void insert(Warqueue warqueue){
        for (int i=0;i<warqueue.array.size();i++)
        { battle.put(this.getPixel(warqueue.array.get(i).getX(),warqueue.array.get(i).getY()),warqueue.array.get(i));
        warqueue.array.get(i).setPixel(this.getPixel(warqueue.array.get(i).getX(),warqueue.array.get(i).getY()));
            warqueue.array.get(i).setField(this);
        }
    }


    public Pixel getPixel(int x,int y){
        return this.row[y].cloumn[x];
    }



    // 以下均为测试方法
    public void print(){
        for (int i = 0; i <leftqueue.array.size() ; i++) {
            System.out.println(leftqueue.array.get(i).name+":"+leftqueue.array.get(i).life+"位于"+leftqueue.array.get(i).getX()+","+leftqueue.array.get(i).getY());

        }
        for (int i = 0; i <rightqueue.array.size() ; i++) {
            System.out.println(rightqueue.array.get(i).name+":"+rightqueue.array.get(i).life+"位于"+rightqueue.array.get(i).getX()+","+rightqueue.array.get(i).getY());
        }
    }

    public void testenermy(){
        Iterator left = leftqueue.array.iterator();
        Iterator right = rightqueue.array.iterator();
        while (left.hasNext())
        {
            Evil c = (Evil) left.next();
            System.out.println(c.name+"的目标是"+c.enermy.name);
        }

 while (right.hasNext())
    {
        Justice c = (Justice) right.next();
        System.out.println(c.name+"的目标是"+c.enermy.name);
    }
}



}

class Line{
     Pixel[] cloumn=new Pixel[20];
     Line(){
         for (int i = 0; i <cloumn.length ; i++) {
             cloumn[i]=new Pixel();
         }
     }
}

class Pixel extends Thing2D{
    //每个点设置一个难易数值，体现这个点的畅通情况
    int hard;
    int x,y;
    private boolean judging;
    public boolean canhold;
    public boolean empty;

    Pixel(){
        URL loc = this.getClass().getClassLoader().getResource("空地.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);hard=0;
        x=y=0;
        judging=false;
        canhold=true;
        empty=true;
    }

    public void stuck(){this.hard++;}

    public int getHard() {
        return hard;
    }

    public void reset(){this.hard=0;}

    public synchronized void taken(){
        empty=false;
        notifyAll();
    }

    public synchronized void leaved(){
        empty=true;
        notifyAll();
    }

    public synchronized void waitingfortaken() throws InterruptedException {
        while (empty)
            wait();
    }

    public synchronized void waitingforleave() throws InterruptedException {
        while (!empty)
        wait();
    }

}
