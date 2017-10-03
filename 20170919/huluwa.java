public class huluwa {
    enum COLOR{red,orange,yellow,green,cyan,blue,purple}
    enum NAME{first,second,third,fourth,fifth,sixth,seventh}
    private int rank,location;
    private COLOR color;
    private NAME name;
    huluwa(int k){
        rank=k;
        location=0;
        switch(k) {
            case 1:
                color = COLOR.red;
                name = NAME.first;
                break;
            case 2:
                color = COLOR.orange;
                name = NAME.second;
                break;
            case 3:
                color = COLOR.yellow;
                name = NAME.third;
                break;
            case 4:
                color = COLOR.green;
                name = NAME.fourth;
                break;
            case 5:
                color = COLOR.cyan;
                name = NAME.fifth;
                break;
            case 6:
                color = COLOR.blue;
                name = NAME.sixth;
                break;
            case 7:
                color = COLOR.purple;
                name = NAME.seventh;
                break;
        }
    }
    COLOR getcolor(){return this.color;}
    int getrank(){return this.rank;}
    void swapbyname(int k){
        System.out.println(name+": jump from "+location+"th to "+k+"th");
        location=k;
    }
    void swapbycolor(int k){
        System.out.println(color+": jump from "+location+"th to "+k+"th");
        location=k;
    }
    void inline(int k){location=k;}
    NAME getname(){return this.name;}
}

