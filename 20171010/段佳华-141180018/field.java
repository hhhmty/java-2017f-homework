public class field {
    Line[] row=new Line[20];
    field(){
        for(int i=0;i<row.length;i++)
            row[i]=new Line();
    }
    public void print() {
        System.out.println("—————————————————————————————————————————");
        for (int i=0; i<row.length; i++) {
            System.out.print("|");
        for(int j=0;j<row[i].cloumn.length;j++) {
            if (row[i].cloumn[j].getholder()!=null)
            {if (row[i].cloumn[j].getholder().location!=row[i].cloumn[j]){row[i].cloumn[j].freeholder();}}
            row[i].cloumn[j].printname();
        }
        System.out.println("|");
        }
        System.out.println("—————————————————————————————————————————");
    }
    public void Setholder(creature single,int x,int y)
    {row[y].cloumn[x].setholder(single);}
}

