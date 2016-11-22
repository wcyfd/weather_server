package com.aim.game.weather_server;

public interface ICommand {
	public void execute();
	public void undo();
}
