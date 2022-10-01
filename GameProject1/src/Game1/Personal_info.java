package Game1;

abstract class Personal_info
{
    String name ;

    Personal_info()
    {

    }
    Personal_info(String var1)
    {
        this.name=var1;
    }
    abstract void printPlayerInfo();
}
