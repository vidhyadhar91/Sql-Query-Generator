package com.example.Sql_DDL.DTO;

public class DropTableRequest {
    private String tableName;
    
    public DropTableRequest() {
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