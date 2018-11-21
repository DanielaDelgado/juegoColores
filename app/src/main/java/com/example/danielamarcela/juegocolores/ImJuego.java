package com.example.danielamarcela.juegocolores;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class ImJuego {
    private Bitmap icono;
    private   float x, y;
    private    Boolean visible;
    int incrementoenx, incrementoeny;

    public ImJuego(int resourse, float _x, float _y, LienzoJuego l) {
        icono = BitmapFactory.decodeResource(l.getResources(), resourse);
        x = _x;
        y = _y;
        visible=true;
        incrementoenx=10;
        incrementoeny=10;

    }

    public void pintar(Canvas c, Paint p) {
        if (visible)  c.drawBitmap(icono, x, y, p);
    }

    public void hacerVisible(boolean v)
    {
        visible=v;
    }



    public boolean estaEnArea(float xp, float yp)
    {
        if(!visible) return false;

        float x2,y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<=x2)
        {
            if(yp>=y && yp<=y2)
            {
                return true;
            }
        }


        return false;
    }

    public void mover(float xp, float yp)
    {
        x=xp-(icono.getWidth()/2);
        y=yp-(icono.getHeight()/2);
    }

    public boolean colision(ImJuego objB)
    {
        float x2=x+icono.getWidth();
        float y2=y+icono.getHeight();

        if(objB.estaEnArea(x2,y))
        {
            //caso 1
            return true;
        }
        if(objB.estaEnArea(x2,y2))
        {
            //caso 3
            return true;
        }
        if(objB.estaEnArea(x,y))
        {
            //caso 2
            return true;
        }
        if(objB.estaEnArea(x,y2))
        {
            //caso 4
            return true;
        }

        return false;
    }
}
