//package com.fsd.RdbmsDDL.DTO;
//
//public class AlterTableRequest {
//    private String tableName;
//    private String operation;
//	public String getTableName() {
//		return tableName;
//	}
//	public void setTableName(String tableName) {
//		this.tableName = tableName;
//	}
//	public String getOperation() {
//		return operation;
//	}
//	public void setOperation(String operation) {
//		this.operation = operation;
//	}
//
//    // Getters and setters
//    
//}

package com.example.Sql_DDL.DTO;

public class AlterTableRequest {
    private String tableName;
    private String operation;

    // Getters and setters
    public String getTableName() { return tableName; }
    public void setTableName(String tableName) { this.tableName = tableName; }
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
}


