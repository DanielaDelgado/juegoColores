package com.example.danielamarcela.juegocolores;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class LienzoJuego extends View {
    ImJuego imagenRojo,imagenAzul,imagenVerde, letrasRojo,letrasAzul,letrasVerde, puntero;
    public LienzoJuego(Context context) {
        super(context);
        imagenRojo=new ImJuego(R.drawable.red,150,120,this);
        imagenAzul=new ImJuego(R.drawable.azul,150, 475,this);
        imagenVerde=new ImJuego(R.drawable.verde,150,870,this);

        letrasRojo=new ImJuego(R.drawable.palabrasrojo,650,900,this);
        letrasAzul=new ImJuego(R.drawable.palabrasazul,650,150,this);
        letrasVerde=new ImJuego(R.drawable.palabrasverde,650,505,this);


        puntero=null;
    }
    public void onDraw (Canvas c)
    {
        super.onDraw(c);
        Paint p=new Paint();

        imagenRojo.pintar(c,p);
        imagenAzul.pintar(c,p);
        imagenVerde.pintar(c,p);

        letrasRojo.pintar(c,p);
        letrasAzul.pintar(c,p);
        letrasVerde.pintar(c,p);
    }
    public boolean onTouchEvent(MotionEvent e)
    {
        float xp= e.getX();
        float yp= e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(letrasRojo.estaEnArea(xp,yp))
                {
                  puntero=letrasRojo;
                }

                if(letrasAzul.estaEnArea(xp,yp))
                {
                    puntero=letrasAzul;
                }

                if(letrasVerde.estaEnArea(xp,yp))
                {
                    puntero=letrasVerde;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero!=null)
                {
                    puntero.mover(xp,yp);
                    if(letrasRojo.colision(imagenRojo))
                    {

                        imagenRojo.hacerVisible(false);
                        letrasRojo.hacerVisible(false);
                    }

                    if(puntero.colision(imagenAzul)&&puntero==letrasAzul)
                    {
                        imagenAzul.hacerVisible(false);
                        letrasAzul.hacerVisible(false);

                    }

                    if(puntero.colision(imagenVerde)&&puntero==letrasVerde)
                    {
                        imagenVerde.hacerVisible(false);
                        letrasVerde.hacerVisible(false);
                    }

                }
                break;
            case MotionEvent.ACTION_UP:
                puntero=null;
                break;
        }

        invalidate();

        return true;
    }
}
