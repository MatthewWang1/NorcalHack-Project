package project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class CollisionsManager
{
    private TowerManager tm;

    private EnemyManager em;

    private ArrayList<Laser> lasers;


    public CollisionsManager( TowerManager t, EnemyManager e )
    {
        tm = t;
        em = e;
        lasers = new ArrayList<Laser>();
    }


    public void update()
    {
        ArrayList<Sprite> shooting = tm.getShooting();
        for ( Sprite s : shooting )
        {
            Sprite enemy = em.isHit( s.getLoc(), ( (Tower)s ).getRange(), s );
            if ( enemy != null )
            {
                lasers.add( new Laser( s.getLoc(), enemy.getLoc() ) );
                ( (Tower)s ).shot();
            }

        }

        ArrayList<Laser> removing = new ArrayList<Laser>();
        for ( Laser l : lasers )
        {
            l.update();
            if ( l.remove() )
            {
                removing.add( l );
            }
        }

        for ( Laser l : removing )
        {
            lasers.remove( l );
        }
    }


    public void draw( Graphics g )
    {
        for ( Laser l : lasers )
        {
            l.draw( g );
        }
    }
}
