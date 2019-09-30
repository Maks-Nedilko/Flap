package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background bg;
	Ze ze;
	Conf conf;
	boolean gameOver;
	Texture rs;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Background();
		ze = new Ze();
		conf = new Conf();
		gameOver = false;
		rs = new Texture("res.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		bg.render(batch);

		conf.render(batch);
		if(!gameOver){
			ze.render(batch);
		}else{
			batch.draw(rs, 200, 100);
		}

		batch.end();
	}

	public void update(){

	bg.update();
	ze.update();
	conf.update();
		for (int i = 0; i < Conf.conf.length; i++) {


			if(ze.pos.x > Conf.conf[i].pos.x && ze.pos.x < Conf.conf[i].pos.x + 38 ){

				if(! Conf.conf[i].emptySpace.contains(ze.pos)){

					gameOver =true;
				}
			}


		}

		if(ze.pos.y<0 || ze.pos.y>397){
			gameOver = true;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER) && gameOver){

			recreate();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

	public void recreate(){
		ze.recreate();
		conf.recreate();
		gameOver = false;
	}





}
