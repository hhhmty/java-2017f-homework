enum ARRAYTYPE{长蛇, 鹤翼, 雁行, 冲轭, 鱼鳞,  锋矢}


public abstract  class Arraymethod {
    //设置初始位置
    protected int x,y;
    Arraymethod(int x,int y)
    {
        this.x=x;
        this.y=y;

    }
public abstract void arraystart(Warqueue warqueue);

}

class Changshe extends Arraymethod{
    Changshe(int x,int y){
        super(x,y);
    }
    @Override
    public void arraystart(Warqueue warqueue){
        for (int i=0;i<warqueue.array.size();i++)
        { warqueue.array.get(i).setX(x+i);
        warqueue.array.get(i).setY(y);}

    }
}

class Yanxing extends Arraymethod{
    Yanxing(int x,int y) {
        super(x,y);
    }
    @Override
    public void arraystart(Warqueue warqueue){
        for (int i=0;i<warqueue.array.size();i++)
        { warqueue.array.get(i).setX(x+i);
        warqueue.array.get(i).setY(y+i);}
    }
}