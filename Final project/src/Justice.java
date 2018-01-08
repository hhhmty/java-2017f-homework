//定义两大阵营,阵营内设置各自的敌人，每个人只能有一个攻击目标，每次攻击造成相应目标的生命减少


import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Justice extends Character {

    Justice(){
        super();
        URL loc = this.getClass().getClassLoader().getResource("葫芦娃.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.enermy=null;
        this.home=HOME.正方;
    }


}

class Evil extends Character {

    Evil(){super();
        URL loc = this.getClass().getClassLoader().getResource("喽啰.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.enermy=null;
        this.home=HOME.反方;
    }
}

//葫芦娃和爷爷属于正义阵营，其他属于邪恶阵营
class Huluwa extends Justice {
    private COLOR color;
    Huluwa(NAME name,COLOR color,int life){
        super();
        this.color=color;
        this.name=name;
        this.life=life;
        this.battlenumber=middle;
        this.enermy=null;
    }

}

class Littlesoldier extends Evil {
    Littlesoldier(int life){
        super();
        this.life=life;
        this.battlenumber=small;
        this.name=NAME.喽啰;
    }
}

class Scorpion extends  Evil {

    Scorpion(int life) {
        super();
        URL loc = this.getClass().getClassLoader().getResource("蝎子.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.life = life;
        this.battlenumber = big;
        this.name=NAME.蝎子;
    }

}

class Snake extends Evil {
    Snake(int life){
        super();
        URL loc = this.getClass().getClassLoader().getResource("蛇.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.life=life;
        this.battlenumber=big;
        this.name=NAME.蛇精;
    }
}

class Grandpa extends Justice {
    Grandpa(int life){
        super();
        URL loc = this.getClass().getClassLoader().getResource("爷爷.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
        this.life=life;
        this.battlenumber=small;
        this.name=NAME.爷爷;
    }
}

//定义一个武器接口，使得人物具有攻击力并且在此设置受到攻击的方法

interface Weapon{
    int small=20;
    int middle=50;
    int big=70;
    void attack();
    void attacked(Character attacker);
}

interface actionmethod{
    public void seekenermy();
    //产生下一次要移动的位置点
    public  void nextto(int x,int y);

    public  void randomnnext(int i);
    //判断是否能移动
    public  boolean canmove();

    public boolean stay();

    public void move();



    //定义行动方法，里面包含着移动，进攻等一系列动作
    public void action();}
