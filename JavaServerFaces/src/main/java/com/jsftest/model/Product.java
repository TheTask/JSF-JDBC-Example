package com.jsftest.model;

import java.util.Iterator;

import javax.faces.bean.ManagedBean;

@ManagedBean( name = "p" )
public class Product implements Iterable< Product >
{
	private int ID;
	private String name;
	private int quantity;
	private float price;
	
	public int getID() { return ID; }
	public void setID( int ID ) { this.ID = ID; }
	public String getName() { return name; }
	public void setName( String name ) { this.name = name; }
	public int getQuantity() { return quantity; }
	public void setQuantity( int quantity ) { this.quantity = quantity; }
	public float getPrice() { return price; }
	public void setPrice( float price ) { this.price = price; }
	
	public String toString(){ return this.ID + " " + this.name + " " + this.quantity + " " + this.price; }
	@Override
	public Iterator< Product > iterator() { return this.iterator(); }
}