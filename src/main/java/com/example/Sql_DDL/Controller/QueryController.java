//package com.fsd.RdbmsDDL.Controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fsd.RdbmsDDL.DTO.AlterTableRequest;
//import com.fsd.RdbmsDDL.DTO.CreateIndexRequest;
//import com.fsd.RdbmsDDL.DTO.CreateTableRequest;
//import com.fsd.RdbmsDDL.DTO.QueryRequest;
//import com.fsd.RdbmsDDL.DTO.SelectQueryRequest;
//import com.fsd.RdbmsDDL.Service.QueryService;
//
//@RestController
//@RequestMapping("/query/ddl")
//public class QueryController {
//
//    @Autowired
//    private QueryService queryService;
//
//    @PostMapping("/generateSelectQuery")
//    public String generateSelectQuery(@RequestBody SelectQueryRequest request) {
//        return queryService.generateSelectQuery(request);
//    }
//
//    @PostMapping("/generateDistinctQuery")
//    public String generateDistinctQuery(@RequestBody SelectQueryRequest request) {
//        return queryService.generateDistinctQuery(request);
//    }
//
//    @PostMapping("/generateJoinQuery")
//    public String generateJoinQuery(@RequestBody SelectQueryRequest request) {
//        return queryService.generateJoinQuery(request);
//    }
//
//    @PostMapping("/generateGroupByQuery")
//    public String generateGroupByQuery(@RequestBody SelectQueryRequest request) {
//        return queryService.generateGroupByQuery(request);
//    }
//
//    @PostMapping("/generateHavingQuery")
//    public String generateHavingQuery(@RequestBody SelectQueryRequest request) {
//        return queryService.generateHavingQuery(request);
//    }
//
//    @PostMapping("/generateUnionQuery")
//    public String generateUnionQuery(@RequestBody QueryRequest queryRequest) {
//        return queryService.generateUnionQuery(queryRequest.getRequest1(), queryRequest.getRequest2());
//    }
//
//    @PostMapping("/generateTruncateTableQuery")
//    public String generateTruncateTableQuery(@RequestBody String table) {
//        return queryService.generateTruncateTableQuery(table);
//    }
//
//
//    @PostMapping("/generateAlterTableQuery")
//    public String generateAlterTableQuery(@RequestBody AlterTableRequest request) {
//        return queryService.generateAlterTableQuery(request.getTableName(), request.getOperation());
//    }
//
//    @PostMapping("/generateDropTableQuery")
//    public String generateDropTableQuery(@RequestBody String table) {
//        return queryService.generateDropTableQuery(table);
//    }
//
//    @PostMapping("/generateCreateIndexQuery")
//    public String generateCreateIndexQuery(@RequestBody CreateIndexRequest request) {
//        return queryService.generateCreateIndexQuery(request.getIndexName(), request.getTableName(), request.getColumns());
//    }
//
//    @PostMapping("/generateCreateTableQuery")
//    public String generateCreateTableQuery(@RequestBody CreateTableRequest request) {
//        return queryService.generateCreateTableQuery(request.getTableName(), request.getColumns());
//    }
//    
//}
//

package com.example.Sql_DDL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Sql_DDL.DTO.*;
import com.example.Sql_DDL.Service.QueryService;

@RestController
@RequestMapping("/query/ddl")
public class QueryController {

	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService) {
		this.queryService = queryService;
	}

	@PostMapping("/select")
	public String SelectQuery(@RequestBody SelectQueryRequest request) {
		return queryService.SelectQuery(request);
	}

	@PostMapping("/truncate")
	public String TruncateQuery(@RequestBody TruncateTableRequest request) {
		return queryService.TruncateQuery(request);
	}

	@PostMapping("/alter")
	public String AlterQuery(@RequestBody AlterTableRequest request) {
		return queryService.AlterQuery(request.getTableName(), request.getOperation());
	}

	@PostMapping("/drop")
	public String generateDropTableQuery(@RequestBody DropTableRequest request) {
		return queryService.DropQuery(request);
	}

	@PostMapping("/createTable")
	public String CreateQuery(@RequestBody CreateTableRequest request) {
		return queryService.CreateQuery(request.getTableName(), request.getColumns());
	}
}
