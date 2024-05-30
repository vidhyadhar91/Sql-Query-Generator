package com.example.Sql_DCL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sql_DCL.DTO.DenyRequest;
import com.example.Sql_DCL.DTO.GrantRequest;
import com.example.Sql_DCL.DTO.RevokeRequest;
import com.example.Sql_DCL.service.QueryService;

@RestController
@RequestMapping("/query/dcl")
public class QueryController {

	private final QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService) {
		this.queryService = queryService;
	}

	@PostMapping("/grant")
	public String GrantQuery(@RequestBody GrantRequest request) {
		return queryService.GrantQuery(request);
	}

	@PostMapping("/revoke")
	public String RevokeQuery(@RequestBody RevokeRequest request) {
		return queryService.RevokeQuery(request);
	}

	@PostMapping("/deny")
	public String DenyQuery(@RequestBody DenyRequest request) {
		return queryService.DenyQuery(request);
	}

}
