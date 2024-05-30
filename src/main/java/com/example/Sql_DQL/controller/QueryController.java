package com.example.Sql_DQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sql_DQL.DTO.SelectQueryRequest;
import com.example.Sql_DQL.service.QueryService;



@RestController
@RequestMapping("/query/dql")
public class QueryController {
	
    private final QueryService queryService;
    
    @Autowired
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }
	
  @PostMapping("/distinct")
  public String DistinctQuery(@RequestBody SelectQueryRequest request) {
      return queryService.DistinctQuery(request);
  }

  @PostMapping("/join")
  public String JoinQuery(@RequestBody SelectQueryRequest request) {
      return queryService.JoinQuery(request);
  }

  @PostMapping("/groupBy")
  public String GroupByQuery(@RequestBody SelectQueryRequest request) {
      return queryService.GroupByQuery(request);
  }

  @PostMapping("/having")
  public String HavingQuery(@RequestBody SelectQueryRequest request) {
      return queryService.HavingQuery(request);
  }

}
