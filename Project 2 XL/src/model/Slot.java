package model;

import java.util.Observable;
import java.util.Observer;

import expr.ExprParser;

public class Slot extends Observable implements Observer {
	private String expr, name;
	
	
	public Slot(String name, ExprParser exprPars){
		this.name = name;
		expr = "";
	}
	
	public void setExpr(String s){
		expr = s;
		notifyObservers();
	}
	
	public void extendExpr(String s){
		//TODO
		notifyObservers();
	}
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}
