public class Array {

    field battlefield;

    Array(field battlefield) {
        this.battlefield = battlefield;
    }

    public void edit(arraytype type,creature [] soldier,int x,int y) {
        free(soldier);
        switch (type) {

            case 长蛇:
                for (int i=0;i<soldier.length;i++)
                battlefield.Setholder(soldier[i],x,y+i);break;

                case 鹤翼:
                int k=1;
                battlefield.Setholder(soldier[0],x,y);
                for (int i=1;i<=soldier.length/2;i++)
            { battlefield.row[y+i].cloumn[x-i].setholder(soldier[k]);k++;
                battlefield.row[y+i].cloumn[x+i].setholder(soldier[k]);k++;}break;

                case 雁行:
                    for (int i=0;i<soldier.length;i++)
                battlefield.Setholder(soldier[i],x+i,y+i);break;

                case 冲轭:
                    for (int i=0;i<soldier.length;i=i+2){
                battlefield.Setholder(soldier[i],x,y+i);
                if (i+1<soldier.length)
                battlefield.Setholder(soldier[i+1],x+1,y+i+1);
                else break;
            }break;

            case 鱼鳞:
                for (int i=0;i<soldier.length;i++)
                { for (int j=0;j<i+1;j++)
                        if ((i*i+i)/2+j<soldier.length)
                    battlefield.Setholder(soldier[(i*i+i)/2+j],x-i+j*2,y-i);
                else break;}break;

            case 锋矢:
                for (int i=0;i<soldier.length;i++)
                { for (int j=0;j<3;j++)
                    if ((i*i+i)/2+j<soldier.length)
                        battlefield.Setholder(soldier[(i*i+i)/2+j],x-i+j*i,y-i);
                    else break;}break;
        }
    }

    public void free(creature [] soldier){
        for (int i=0;i<soldier.length;i++)
               soldier[i].freeLocation();}
}
enum arraytype {长蛇, 鹤翼, 雁行, 冲轭, 鱼鳞,  锋矢}