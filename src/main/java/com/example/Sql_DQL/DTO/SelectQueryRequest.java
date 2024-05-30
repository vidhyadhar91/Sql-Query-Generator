package com.example.Sql_DQL.DTO;

public class SelectQueryRequest {
    private String columns;
    private String table;
    private String condition;
    private String orderBy;
    private int limit;
    private String joinTable;
    private String joinCondition;
    private String groupByColumns;
    private String havingCondition;

    // Getters and setters for all fields
    public String getColumns() { return columns; }
    public void setColumns(String columns) { this.columns = columns; }
    public String getTable() { return table; }
    public void setTable(String table) { this.table = table; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }
    public String getOrderBy() { return orderBy; }
    public void setOrderBy(String orderBy) { this.orderBy = orderBy; }
    public int getLimit() { return limit; }
    public void setLimit(int limit) { this.limit = limit; }
    public String getJoinTable() { return joinTable; }
    public void setJoinTable(String joinTable) { this.joinTable = joinTable; }
    public String getJoinCondition() { return joinCondition; }
    public void setJoinCondition(String joinCondition) { this.joinCondition = joinCondition; }
    public String getGroupByColumns() { return groupByColumns; }
    public void setGroupByColumns(String groupByColumns) { this.groupByColumns = groupByColumns; }
    public String getHavingCondition() { return havingCondition; }
    public void setHavingCondition(String havingCondition) { this.havingCondition = havingCondition; }
}
