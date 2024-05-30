
package com.example.Sql_DML.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Sql_DML.DTO.*;
import com.example.Sql_DML.Service.QueryService;

@RestController
@RequestMapping("/query/dml")
public class QueryController {

	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService) {
		this.queryService = queryService;
	}

	@PostMapping("/insert")
	public String InsertQuery(@RequestBody InsertQueryRequest request) {
		return queryService.InsertQuery(request);
	}

	@PostMapping("/update")
	public String UpdateQuery(@RequestBody UpdateQueryRequest request) {
		return queryService.UpdateQuery(request);
	}

	@PostMapping("/delete")
	public String DeleteQuery(@RequestBody DeleteQueryRequest request) {
		return queryService.DeleteQuery(request);
	}

}
