package Game1;

public class Player_info extends Personal_info
{
    public int age;
    public String gender;

    public Player_info()
    {

    }

    public Player_info(String var1,int var2,String var3)
    {
        super(var1);
        this.age=var2;
        this.gender=var3;
    }

    public void setAge(int var1)
    {
        this.age=var1;
    }
    public void setGender(String var1)
    {
        this.gender=var1;
    }

    public int getAge()
    {
        return this.age;
    }
    public String getGender()
    {
        return this.gender;
    }

    public void printPlayerInfo()
    {
        System.out.println("PLAYER: "+this.name+"\nAGE: "+this.age+"\nGENDER: "+this.gender);
    }
}
