package project;

import java.awt.Graphics;
import java.util.ArrayList;


public class TowerManager
{
    private ArrayList<Sprite> towers;

    private ArrayList<Sprite> shooting;


    public TowerManager()
    {
        towers = new ArrayList<Sprite>();
    }


    public void add( Tower t )
    {
        towers.add( t );
        Main.gh.addMoney( -t.getCost() );
    }


    public void update()
    {
        shooting = new ArrayList<Sprite>();

        for ( Sprite s : towers )
        {
            s.update();

            if ( ( (Tower)s ).shooting() )
            {
                shooting.add( s );
            }
        }

    }


    public ArrayList<Sprite> getShooting()
    {
        return shooting;
    }


    public void draw( Graphics g )
    {
        for ( Sprite s : towers )
        {
            s.draw( g );
        }
    }

}
