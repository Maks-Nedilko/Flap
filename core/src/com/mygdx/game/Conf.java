package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Conf {

    class ConfPair{

        Vector2 pos;
        float speed;
        int offset;
        Rectangle emptySpace;

        public ConfPair(Vector2 pos){

        this.pos = pos;
        speed = 2;
        offset = new Random().nextInt(100);

        emptySpace = new Rectangle(pos.x, pos.y - offset + 200, 38, betweenDistance);

        }

        public void update(){

            pos.x -= speed;


            if(pos.x < -38){
                pos.x = 640;
                offset = new Random().nextInt(100);

            }
            emptySpace.x = pos.x;

        }

    }

    static ConfPair[] conf;
    Texture tx;
    int startPosX = 200;
    int betweenDistance;

    public Conf(){

        tx = new Texture("conf.png");
        conf = new ConfPair[4];
        betweenDistance = 100;
        for(int i = 0;i<conf.length;i++){

            conf[i] = new ConfPair(new Vector2(startPosX, 0));
            startPosX += 170;

        }

    }

    public void render(SpriteBatch batch){
        for (int i = 0; i <conf.length ; i++) {

            batch.draw(tx, conf[i].pos.x, conf[i].pos.y - conf[i].offset);
            batch.draw(tx, conf[i].pos.x, conf[i].pos.y + betweenDistance + tx.getHeight() - conf[i].offset );

        }
    }

    public void update(){

        for (int i = 0; i <conf.length ; i++) {

            conf[i].update();

        }

    }

    public void recreate(){

        startPosX = 200;
        for(int i = 0;i<conf.length;i++){

            conf[i] = new ConfPair(new Vector2(startPosX, 0));
            startPosX += 170;

        }

    }






}
