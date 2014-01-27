package model;

import java.sql.ResultSet;

public class SearchIO extends DbAbstract {
	
	public SearchIO() {
		super();
	}
	
	public ResultSet zoek(String value){
		super.makeConnection();
		String query = "select * from event where naam like '%"+value+"%'OR contactpersoon like '%"+value+"%'";
		ResultSet rs = super.makeResultSet(query);
		super.closeConnectRst();
		return rs;
	}
	
}
