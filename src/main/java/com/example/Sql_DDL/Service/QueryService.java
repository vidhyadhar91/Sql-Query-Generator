//package com.fsd.RdbmsDDL.Service;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//import com.fsd.RdbmsDDL.DTO.SelectQueryRequest;
//
//
//@Service
//public class QueryService {
//
//    public String generateSelectQuery(SelectQueryRequest request) {
//        String query = "SELECT " + request.getColumns() + " FROM " + request.getTable();
//        if (request.getCondition() != null && !request.getCondition().isEmpty()) {
//            query += " WHERE " + request.getCondition();
//        }
//        if (request.getOrderBy() != null && !request.getOrderBy().isEmpty()) {
//            query += " ORDER BY " + request.getOrderBy();
//        }
//        query += " LIMIT " + request.getLimit();
//        return query;
//    }
//    
//    public String generateDistinctQuery(SelectQueryRequest request) {
//        return "SELECT DISTINCT " + request.getColumns() + " FROM " + request.getTable();
//    }
//    
//    public String generateJoinQuery(SelectQueryRequest request) {
//        // Assuming joinCondition is provided in the request
//        return "SELECT " + request.getColumns() + " FROM " + request.getTable() +
//               " INNER JOIN " + request.getJoinTable() + " ON " + request.getJoinCondition();
//    }
//
//    public String generateGroupByQuery(SelectQueryRequest request) {
//        // Assuming groupByColumns are provided in the request
//        return "SELECT " + request.getColumns() + " FROM " + request.getTable() +
//               " GROUP BY " + request.getGroupByColumns();
//    }
//    
//    public String generateHavingQuery(SelectQueryRequest request) {
//        // Assuming havingCondition is provided in the request
//        return "SELECT " + request.getColumns() + " FROM " + request.getTable() +
//               " GROUP BY " + request.getGroupByColumns() +
//               " HAVING " + request.getHavingCondition();
//    }
//    
//    public String generateUnionQuery(SelectQueryRequest request1, SelectQueryRequest request2) {
//        return generateSelectQuery(request1) + " UNION " + generateSelectQuery(request2);
//    }
//    
//    public String generateTruncateTableQuery(String table) {
//        return "TRUNCATE TABLE " + table;
//    }
//    
//    public String generateCreateTableQuery(String tableName, Map<String, String> map) {
//        return "CREATE TABLE " + tableName + " (" + map + ")";
//    }
//    
//    public String generateAlterTableQuery(String tableName, String operation) {
//        return "ALTER TABLE " + tableName + " " + operation;
//    }
//
//    public String generateDropTableQuery(String table) {
//        return "DROP TABLE " + table;
//    }
//    
//    public String generateCreateIndexQuery(String indexName, String tableName, List<String> list) {
//        return "CREATE INDEX " + indexName + " ON " + tableName + " (" + list + ")";
//    }
//
//
//
//
//}

package com.example.Sql_DDL.Service;

import org.springframework.stereotype.Service;

import com.example.Sql_DDL.DTO.DropTableRequest;
import com.example.Sql_DDL.DTO.SelectQueryRequest;
import com.example.Sql_DDL.DTO.TruncateTableRequest;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class QueryService {

	public String SelectQuery(SelectQueryRequest request) {
		StringBuilder query = new StringBuilder("SELECT ").append(request.getColumns()).append(" FROM ")
				.append(request.getTable());

		appendCondition(query, request.getCondition(), " WHERE ");
		appendCondition(query, request.getOrderBy(), " ORDER BY ");
		query.append(" LIMIT ").append(request.getLimit());

		return query.toString();
	}

	public String HavingQuery(SelectQueryRequest request) {
		return new StringJoiner(" ").add("SELECT").add(request.getColumns()).add("FROM").add(request.getTable())
				.add("GROUP BY").add(request.getGroupByColumns()).add("HAVING").add(request.getHavingCondition())
				.toString();
	}

	public String TruncateQuery(TruncateTableRequest request) {
		return "TRUNCATE TABLE " + request.getTableName();
	}

	public String CreateQuery(String tableName, Map<String, String> columns) {
		String columnDefinitions = columns.entrySet().stream().map(entry -> entry.getKey() + " " + entry.getValue())
				.reduce((col1, col2) -> col1 + ", " + col2).orElse("");
		return "CREATE TABLE " + tableName + " (" + columnDefinitions + ")";
	}

	public String AlterQuery(String tableName, String operation) {
		return "ALTER TABLE " + tableName + " " + operation;
	}

	public String DropQuery(DropTableRequest request) {
		return "DROP TABLE " + request.getTableName();
	}

	private void appendCondition(StringBuilder query, String condition, String clause) {
		if (condition != null && !condition.isEmpty()) {
			query.append(clause).append(condition);
		}
	}
}
