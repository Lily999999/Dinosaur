package edu.monash.fit2099.demo.mars;

import edu.monash.fit2099.engine.Ground;


public class Floor extends Ground {

	public Floor() {
		super('.');
	}

	@Override
	public int foodToConsume() {
		return 0;
	}

	@Override
	public int drink(){
		return 0;
	}
}
