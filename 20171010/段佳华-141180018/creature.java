public class creature {
    NAME name;
    position location;
    public NAME getname(){return this.name;}
    public position getLocation(){return location;}
    public void setLocation(position location){this.location=location;
    }
    public void freeLocation(){this.location=null;}
}
enum NAME{大娃,二娃,三娃,四娃,五娃,六娃,七娃,爷爷,蝎子,蛇精,喽啰}