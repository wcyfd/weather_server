package com.aim.game.weather_server;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class WeatherServerApp {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		currentTime = System.currentTimeMillis();
		lastTime = currentTime;

		ScheduledExecutorService weatherTimer = new ScheduledThreadPoolExecutor(1);
		weatherTimer.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				currentTime++;
				refreshWeather();
				refreshLife();
			}
		}, 0, 1, TimeUnit.SECONDS);
	}
	public static void refreshWeather(){
		if ((int) (currentTime - lastTime) >= changeDeltaTime) {
			lastTime = currentTime;
			changeDeltaTime = rand.nextInt(10);
			weatherType = weatherType == WeatherType.SUNNY ? WeatherType.RAIN : WeatherType.SUNNY;
			System.out.println(weatherType);
		}
	}
	
	public static void refreshLife(){		
		if(weatherType == WeatherType.RAIN){
			
			return ;
		}
	}

	public static int width = 1000;
	public static int height = 1000;
	public static int cavePositionX = 10;
	public static int cavePositionY = 20;
	public static int caveWidth = 20;
	public static int caveHeight = 20;
	public static enum WeatherType{
		RAIN,SUNNY;
	}
	public static Random rand = new Random();
	public static int changeDeltaTime = rand.nextInt(10);
	public static long currentTime =0;
	public static long lastTime = 0;
	public static WeatherType weatherType = WeatherType.SUNNY;
	public static int life_positionX = width / 2;
	public static int life_positionY = height / 2;
}
