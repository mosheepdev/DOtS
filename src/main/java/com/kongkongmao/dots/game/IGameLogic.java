package com.kongkongmao.dots.game;

import com.kongkongmao.dots.gui.window.Window;

public interface IGameLogic {

	void init() throws Exception;

	void input(Window window);

	void update(float interval);

	void getRenderer(IGameRenderer re);

}
