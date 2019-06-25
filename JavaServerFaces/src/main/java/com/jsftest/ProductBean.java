package com.jsftest;


import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

import com.jsftest.model.Product;
import java.sql.Statement;

@ManagedBean( name = "productBean" )
@SessionScoped
public class ProductBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	//resource injection
	@Resource(name="jdbc/mkyongdb")
	private DataSource ds;
	private Connection con = null;
	private List< Product > list = null;
	
	private int nProducts = 0;
	
	//if resource inject is not support, you still can get it manually.
//	public ProductBean(){
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mkyongdb");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public List< Product > initList()
	{
		List< Product > alp = populateProductList();
		

		if( this.list == null || alp.size() != nProducts ) 
		{
			this.list = alp;
			nProducts = alp.size();
		}
		
		return this.list;
	}
	
	public List< Product > getList(){ return this.list; }
	
	public String sortByID() { return SortUtil.sortByID( this.list ); }
	public String sortByName() { return SortUtil.sortByName( this.list ); }
	public String sortByQuantity() { return SortUtil.sortByQuantity( this.list ); }
	public String sortByPrice() { return SortUtil.sortByPrice( this.list ); }
	
	private void initConn() throws SQLException
	{
		if( ds == null ) throw new SQLException( "Can't get data source" );
		
		//get database connection
		if( con == null ) con = ds.getConnection();
		if( con == null ) throw new SQLException( "Can't get database connection" );
	}

	private List< Product > populateProductList() 
	{
		List< Product > list = new ArrayList< Product >();
		
		try
		{
			initConn();
		
			PreparedStatement ps = con.prepareStatement( "select id, name, quantity, price from test2" ); 
			ResultSet result =  ps.executeQuery();

			while( result.next() )
			{
				Product prod = new Product();
				
				prod.setID( result.getInt( "id" ) );
				prod.setName( result.getString( "name" ) );
				prod.setQuantity( result.getInt( "quantity" ) );
				prod.setPrice( result.getFloat( "price" ) );
				
				//store all data into a List
				list.add( prod );
			}
		}
		catch( SQLException e ){}
			
		//this.list = list;
		return list;
	}
	
	public String add( Product p ) throws SQLException
	{
		initConn();
		
        String query = "INSERT INTO test2 "
				   + "( ID,Name,Quantity,Price )"
				   + "values ( '" + p.getID() + "', '" + p.getName() + "', '" + p.getQuantity() + "',  '" + p.getPrice() + "' )";
        
        Statement myStmt = con.createStatement();
        myStmt.executeUpdate( query );
         
        return "default";
	}
	
	public String delete( int id ) throws SQLException
	{
		initConn();
			
        String query = "delete from test2 where ID=" + id;
        
        Statement myStmt = con.createStatement();
        myStmt.executeUpdate( query );
         
        return "default";
	}
	
	public float totalPrice() throws SQLException
	{
		initConn();
		
		float totalPrice = 0;
		
		List< Product > alp = this.list; //getProductList();
		
		for( Product p : alp )
		{
			totalPrice += p.getPrice() * p.getQuantity();
		}
		
		return totalPrice;
	}
	
}
