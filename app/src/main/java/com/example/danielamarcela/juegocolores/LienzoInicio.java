package com.example.danielamarcela.juegocolores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class LienzoInicio extends View {

    ImInicio rojo,azul, verde, negro, amarillo,rosa;
    ImInicio flecha;
    Main2Activity obj;
    MediaPlayer mp;

    public LienzoInicio(Context context) {
        super(context);

        rojo=new ImInicio(R.drawable.red,90,100,this);
        azul=new ImInicio(R.drawable.azul,420,100,this);
        verde=new ImInicio(R.drawable.verde,740,100,this);

        negro=new ImInicio(R.drawable.negro,90,550,this);
        amarillo=new ImInicio(R.drawable.amarillo,420,550,this);
        rosa=new ImInicio(R.drawable.rosa,740,550,this);

       flecha=new ImInicio(R.drawable.back,420,1050,this);
        obj=(Main2Activity)context;
    }
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p=new Paint();

        c.drawColor(Color.WHITE);

        rojo.pintar(c,p);
        azul.pintar(c,p);
        verde.pintar(c,p);

        negro.pintar(c,p);
        amarillo.pintar(c,p);
        rosa.pintar(c,p);

        flecha.pintar(c,p);

    }
   public boolean onTouchEvent(MotionEvent e)
    {
        float xp= e.getX();
        float yp= e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(rojo.estaEnArea(xp,yp))
                {
                    mp=MediaPlayer.create(obj, R.raw.rojo);
                    mp.start();
                }
                if(azul.estaEnArea(xp,yp))
                {
                    mp=MediaPlayer.create(obj, R.raw.azul);
                    mp.start();
                }
                if(verde.estaEnArea(xp,yp))
                {
                    mp=MediaPlayer.create(obj, R.raw.verde);
                    mp.start();
                }

                if (negro.estaEnArea(xp,yp))
                {
                    mp=MediaPlayer.create(obj, R.raw.negro);
                    mp.start();
                }
                if(amarillo.estaEnArea(xp,yp))
                {
                    mp=MediaPlayer.create(obj, R.raw.amarillo);
                    mp.start();
                }
                if (rosa.estaEnArea(xp,yp))
                {
                    mp=MediaPlayer.create(obj, R.raw.rosa);
                    mp.start();
                }
                if (flecha.estaEnArea(xp,yp))
                {
                    Intent otraventana=new Intent(obj, MainActivity.class);
                    obj.startActivity(otraventana);
                }

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        invalidate();
        return true;
    }
}
