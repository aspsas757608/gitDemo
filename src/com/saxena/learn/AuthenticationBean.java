package com.saxena.learn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.jws.WebService;
import javax.sql.DataSource;

@Stateless
@Local(Authentication.class)
@Remote(AuthenticationRemote.class)
@RolesAllowed({ "X", "Y", "Z" })
@DeclareRoles({ "", "", "" })
public class AuthenticationBean {

	@Resource
	private SessionContext sessionContext;

	@Resource(mappedName = "java:MySqlXADS")
	private DataSource dataSource;

	@Timeout
	public void execute(Timer timer) {
		System.out.println("timer Timed Out...........");
	}

	@PostConstruct
	public void initialized() {
		System.out.println("@Postconstructed");
	}

	public void authenticate(String username, String password) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection.getMetaData().getJDBCMajorVersion());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		TimerService service = sessionContext.getTimerService();
		service.createTimer(5000, null);
	}

	@PreDestroy
	public void destroying() {
		System.out.println("preDestroy");
	}
}