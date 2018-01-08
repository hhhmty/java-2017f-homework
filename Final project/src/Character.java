
import java.lang.Math.*;
import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
enum COLOR{红,橙,黄,绿,青,蓝,紫}
enum NAME{大娃,二娃,三娃,四娃,五娃,六娃,七娃,爷爷,蝎子,蛇精,喽啰}
enum HOME{正方,反方}
public class Character extends Thing2D implements Runnable,actionmethod,Weapon {
    public NAME name;
    protected int life;
    public HOME home;
    public boolean live;
    public boolean attack;
    protected int battlenumber;
    protected int nextX, nextY;
    protected Field field;
    protected Character enermy;


    Character() {
        live = true;
        attack = false;
        field = null;
        enermy = null;
    }

    public void setPixel(Pixel pixel) {
        this.setX(pixel.getX());
        this.setY(pixel.getY());
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void death() {
        this.live = false;
        field.getPixel(x, y).canhold = false;
        URL lo = this.getClass().getClassLoader().getResource("player.png");
        ImageIcon iia = new ImageIcon(lo);
        Image image = iia.getImage();
        this.setImage(image);
    }


    public void Setenermy(Character enermy) {
        if (enermy.live)
            this.enermy = enermy;
    }


    //以下为两种确定敌人的方法
    public void seekenermy() {
        if (enermy == null) {
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 20; i++) {
                    if (field.battle.get(field.getPixel((getX() + i) % 20, (getY() + j) % 20)) != null)
                        if (field.battle.get(field.getPixel((getX() + i) % 20, (getY() + j) % 20)).home != this.home)
                            Setenermy(field.battle.get(field.getPixel((getX() + i) % 20, (getY() + j) % 20)));
                    if (enermy != null)
                        break;
                }
                if (enermy != null)
                    break;
            }
        }
    }

    public boolean canmove() {
        Character c = field.battle.get(field.getPixel(nextX, nextY));
        if (stay())
            return true;
        else {
            if (c != null) {
                if (c.home != this.home) {
                    if (c.live) {
                        this.Setenermy(c);
                        nextX = x;
                        nextY = y;
                        return true;
                    }
                    return false;
                } else {
                    if (c.stay())
                        return false;
                    return true;
                }
            }
            return true;
        }
    }

    //攻击与被攻击
    public void attack() {
        if (this.live)
            enermy.attacked(this);
        if (!enermy.live) {
            this.attack = false;
            this.enermy = null;
        }
    }

    public void attacked(Character attacker) {
        this.life = this.life - attacker.battlenumber;
        if (!this.attack) {
            this.Setenermy(attacker);
            this.attack = true;
        }
        if (this.life <= 0) {
            this.live = false;
            this.attack = false;
            this.death();
        }
    }


    public void judge() {
        Pixel p1 = field.getPixel(x, y);
        while (!canmove()) {
            int i = 1;
            randomnnext(i);
            p1.stuck();
            i++;
        }
    }

    public void action() {
        if (stay())
            attack();
        else
            move();
    }


    @Override

//产生下一次要移动的位置点
    public void nextto(int x, int y) {
        int nextx;
        nextx = this.x;
        int nexty;
        nexty = this.y;
        if (this.live) {
            if (this.x != x) {
                nextx = this.x + (x - this.x) / Math.abs(x - this.x);
                nextx = 19 - Math.abs(nextx - 19);
            } else if (this.x == x && this.y != y) {
                nexty = this.y + (y - this.y) / Math.abs(y - this.y);
                nexty = 19 - Math.abs(nexty - 19);
            }
        }
        this.nextX = nextx;
        this.nextY = nexty;

    }

    public void randomnnext(int i) {
        Com com = new Com(field.getPixel(19 - Math.abs(x - 18), y), field.getPixel(Math.abs(x - 1), y), field.getPixel(x, Math.abs(y - 1)), field.getPixel(x, 19 - Math.abs(y - 18)));
        this.nextX = com.getbynum(i).getX();
        this.nextY = com.getbynum(i).getY();
    }

    //判断是否留在原地
    public boolean stay() {
        if (this.nextX == this.x && this.nextY == this.y)
            return true;
        return false;

    }

    public void move() {
        Pixel p1=field.getPixel(x,y);
        Pixel p2=field.getPixel(nextX,nextY);
       try {synchronized (p2){
           p2.waitingforleave();
           if (field.battle.get(p2)!=null)
           {
               this.nextX=x;
           this.nextY=y;
           judge();
           return ;
           }
           else
           {
               x=nextX;
               y=nextY;
               field.battle.put(p2,this);
               field.battle.put(p1,null);
           }
           p2.taken();
           p2.waitingfortaken();
           Thread.sleep(1000);
       }

       } catch(InterruptedException e){
           e.printStackTrace();
       }

       }

    //定义行动方法，里面包含着移动，进攻等一系列动作

    public void run() {
        try {
            while (!field.over) {
                if (enermy == null)
                    seekenermy();
                nextto(enermy.getX(), enermy.getY());
                judge();
                action();

                }
            }
                catch(NullPointerException e){
                    System.out.println("战斗结束");
                }
                }





        }

