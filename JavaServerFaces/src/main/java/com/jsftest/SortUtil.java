package com.jsftest;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jsftest.model.Product;

public class SortUtil 
{
	private static boolean sortIDAscending = true;
	private static boolean sortNameAscending = true;
	private static boolean sortQuantityAscending = true;
	private static boolean sortPriceAscending = true;
	
	public static String sortByID( List< Product > list ) 
	{
		if( sortIDAscending )
		{
			Collections.sort( list,new Comparator< Product >() {

				@Override
				public int compare( Product p1,Product p2 ) {	
					return ( new Integer( p1.getID() ) ).compareTo( new Integer( p2.getID() ) );	
				}
			});
			sortIDAscending = false;	
		}
		else
		{
			Collections.sort( list,new Comparator< Product >() {
				@Override
				public int compare( Product p1,Product p2 ) {
					return ( new Integer( p2.getID() ) ).compareTo( new Integer( p1.getID() ) );
				}
			});
			sortIDAscending = true;
		}

		return null;
    }
	
	public static String sortByName( List< Product > list ) 
	{
		if( sortNameAscending )
		{
			Collections.sort( list,new Comparator< Product >() {

				@Override
				public int compare( Product p1,Product p2 ) {	
					return ( new String( p1.getName() ) ).compareTo( new String( p2.getName() ) );	
				}
			});
			sortNameAscending = false;	
		}
		else
		{
			Collections.sort( list,new Comparator< Product >() {
				@Override
				public int compare( Product p1,Product p2 ) {
					return ( new String( p2.getName() ) ).compareTo( new String( p1.getName() ) );
				}
			});
			sortNameAscending = true;
		}

		return null;
    }
	
	public static String sortByQuantity( List< Product > list ) 
	{
		if( sortQuantityAscending )
		{
			Collections.sort( list,new Comparator< Product >() {

				@Override
				public int compare( Product p1,Product p2 ) {	
					return ( new Integer( p1.getQuantity() ) ).compareTo( new Integer( p2.getQuantity() ) );	
				}
			});
			sortQuantityAscending = false;	
		}
		else
		{
			Collections.sort( list,new Comparator< Product >() {
				@Override
				public int compare( Product p1,Product p2 ) {
					return ( new Integer( p2.getQuantity() ) ).compareTo( new Integer( p1.getQuantity() ) );
				}
			});
			sortQuantityAscending = true;
		}

		return null;
    }
	
	public static String sortByPrice( List< Product > list ) 
	{
		if( sortPriceAscending )
		{
			Collections.sort( list,new Comparator< Product >() {

				@Override
				public int compare( Product p1,Product p2 ) {	
					return ( new Float( p1.getPrice() ) ).compareTo( new Float( p2.getPrice() ) );	
				}
			});
			sortPriceAscending = false;	
		}
		else
		{
			Collections.sort( list,new Comparator< Product >() {
				@Override
				public int compare( Product p1,Product p2 ) {
					return ( new Float( p2.getPrice() ) ).compareTo( new Float( p1.getPrice() ) );
				}
			});
			sortPriceAscending = true;
		}

		return null;
    }
}
