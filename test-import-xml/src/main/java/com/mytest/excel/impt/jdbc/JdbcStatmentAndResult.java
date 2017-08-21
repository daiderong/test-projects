package com.mytest.excel.impt.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcStatmentAndResult {
	
	private Statement  statement;
	
	private ResultSet  resultSet;

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	
	public void close(){
		try {
			if(resultSet!=null && !resultSet.isClosed()){
				resultSet.close();
			}
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public JdbcStatmentAndResult(Statement statement, ResultSet resultSet) {
		super();
		this.statement = statement;
		this.resultSet = resultSet;
	}

	@Override
	protected void finalize() throws Throwable {
		close();
	}
	
	
	
	
	
	
	
	
	
	
}
