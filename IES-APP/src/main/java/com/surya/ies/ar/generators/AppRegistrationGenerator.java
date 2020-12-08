package com.surya.ies.ar.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AppRegistrationGenerator implements IdentifierGenerator
{

		private final String GET_AR_Sequence="select APP_REG_SEQ.nextval from dual";
		//private final String PREFIX="AR";
		
		private final String prefix="AR";
		String suffix=null;

		@Override
		public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
			try {
			Connection con=session.connection();
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_AR_Sequence);
			
			if(rs.next())
			{
			long sssno = rs.getLong(1);	
			suffix = String.valueOf(sssno);
			}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return prefix+suffix;
		}

	}


