public class second {
    public static void main(String[] args) {
       sort sorter=new sort();
        field Field =new field();
        Array array=new Array(Field);
       huluwa[] brothers = new huluwa[7];//生成葫芦娃
        sorter.shuffle(brothers);//使葫芦娃乱序
        array.edit(arraytype.长蛇,brothers,10,13);//先使乱序的葫芦娃排成长蛇打印出来
        Field.print();
        sorter.bubble(brothers);//葫芦娃排序
        array.edit(arraytype.长蛇,brothers,10,13);
        Field.print();
            Dark[] guys=new Dark[7];//生成小喽啰
        for (int i = 0; i < guys.length; i++)
        {guys[i]=new Dark(NAME.喽啰);}//生成喽啰
        Dark snake=new Dark(NAME.蛇精);
        Dark scorpid=new Dark(NAME.蝎子);
        Grandfather grandfather=new Grandfather();
            Field.Setholder(grandfather,19,16);//给爷爷安排位置
            Field.Setholder(scorpid,10,7);//蝎子精站好，随后安排喽啰在他身后
            array.edit(arraytype.鹤翼,guys,10,0);
            Field.Setholder(snake,0,3);//给蛇精安排位置
            Field.print();
        array.edit(arraytype.锋矢,guys,10,6);//排成不同阵型
        Field.print();
        array.edit(arraytype.鱼鳞,guys,10,6);
        Field.print();
        array.edit(arraytype.冲轭,guys,10,0);
        Field.print();
        array.edit(arraytype.雁行,guys,10,0);
        Field.print();
    }
}