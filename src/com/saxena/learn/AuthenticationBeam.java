package com.saxena.learn;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Timeout;
import javax.ejb.Timer;


@Remote (AuthenticationRemote.class)
public class AuthenticationBeam {
	
	

	@Resource (mappedName = "java:MySqlIDS")
	private DataSource dataSource;
	
	@Timeout
	public void execute(Timer timer)
	{
	System.out.println("timer timed out");
	}

	@PostConstruct
	public void initialized()
	{
	System.out.println("@Postconstructed");
	}

	public void authenticate(String username, String password)
	{
		Connection connection = null;
		try{
			
			connection = dataSource.getConnection();
			
			System.out.println(connection.getMetaData().getJDBCMajorVersion());
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		} finally{
			try{
				if (connection != null && !connection.isClosed()){
					connection.close();
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}

	}

	


	@PreDestroy
	public void destroying()
	{
	System.out.println("preDestroy");
	}
}
