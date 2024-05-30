package com.example.Sql_DDL.DTO;

public class TruncateTableRequest {
    private String tableName;
    
    public TruncateTableRequest() {
		// TODO Auto-generated constructor stub
	}
 
    // Getters and Setters
    public String getTableName() {
        return tableName;
    }
 
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
