package project;

public class Location
{
    private int x;

    private int y;

    private boolean removed = true;


    public Location( int x, int y )
    {
        this.x = x;
        this.y = y;
    }


    public Location( boolean coordinates, int x, int y )
    {
        this.x = x * GameHandler.SQUAREDIM;
        this.y = y * GameHandler.SQUAREDIM;
    }


    public int getX()
    {
        return x;
    }


    public boolean equals( Object other )
    {

        return ( (Location)other ).getX() == x
            && ( (Location)other ).getY() == y;

    }


    public int getY()
    {
        return y;
    }


    public void setX( int x )
    {
        this.x = x;
    }


    public void setY( int y )
    {
        this.y = y;
    }


    public boolean removed()
    {
        return removed;
    }


    public void setRemoved( boolean r )
    {
        removed = r;
    }
}
