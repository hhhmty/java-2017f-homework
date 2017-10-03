public class second {
    public static void main(String[] args) {
        huluwa[] h = new huluwa[7];
        for(int i=0;i<7;i++){
            h[i]=new huluwa(i+1);
        }
        queue line=new queue();
        h[0].inline(4);line.take(4,h[0].getrank());
        h[1].inline(3);line.take(3,h[1].getrank());
        h[2].inline(1);line.take(1,h[2].getrank());
        h[3].inline(5);line.take(5,h[3].getrank());
        h[4].inline(7);line.take(7,h[4].getrank());
        h[5].inline(2);line.take(2,h[5].getrank());
        h[6].inline(6);line.take(6,h[6].getrank());
        sort s=new sort();
        System.out.print("排序前报名字:");
        for(int i=0;i<line.que.length;i++)
            System.out.print(h[line.que[i]-1].getname()+"  ");
        System.out.println(" ");
        System.out.println("开始进行冒泡排序");
        s.bubble(line.que,h);
        System.out.println("排序后所有人按顺序报名字：");
        for(int i=0;i<line.que.length;i++)
            System.out.print(h[line.que[i]-1].getname()+"  ");
        System.out.println(" ");
        System.out.println("再次随机站位");
        h[0].inline(4);line.take(4,h[0].getrank());
        h[1].inline(3);line.take(3,h[1].getrank());
        h[2].inline(1);line.take(1,h[2].getrank());
        h[3].inline(5);line.take(5,h[3].getrank());
        h[4].inline(7);line.take(7,h[4].getrank());
        h[5].inline(2);line.take(2,h[5].getrank());
        h[6].inline(6);line.take(6,h[6].getrank());
        System.out.print("排序前报颜色:");
        for(int i=0;i<line.que.length;i++)
            System.out.print(h[line.que[i]-1].getcolor()+"  ");
        System.out.println(" ");
        System.out.println("开始进行二分法排序");
        s.dichotomy(line.que,h);
        System.out.println("排序后所有人按顺序报颜色：");
        for(int i=0;i<line.que.length;i++)
            System.out.print(h[line.que[i]-1].getcolor()+"  ");
        System.out.println(" ");
    }
}
