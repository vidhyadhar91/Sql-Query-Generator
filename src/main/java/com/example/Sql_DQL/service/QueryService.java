package com.example.Sql_DQL.service;

import java.util.StringJoiner;

import org.springframework.stereotype.Service;

import com.example.Sql_DQL.DTO.SelectQueryRequest;

@Service
public class QueryService {

	public String DistinctQuery(SelectQueryRequest request) {
		return new StringJoiner(" ").add("SELECT DISTINCT").add(request.getColumns()).add("FROM")
				.add(request.getTable()).toString();
	}

	public String JoinQuery(SelectQueryRequest request) {
		return new StringJoiner(" ").add("SELECT").add(request.getTable() + "." + request.getColumns()).add("FROM")
				.add(request.getTable()).add("INNER JOIN").add(request.getJoinTable()).add("ON")
				.add(request.getJoinCondition()).toString();
	}

	public String GroupByQuery(SelectQueryRequest request) {
		return new StringJoiner(" ").add("SELECT").add(request.getColumns()).add("FROM").add(request.getTable())
				.add("GROUP BY").add(request.getGroupByColumns()).toString();
	}

	public String HavingQuery(SelectQueryRequest request) {
		return new StringJoiner(" ").add("SELECT").add(request.getColumns()).add("FROM").add(request.getTable())
				.add("GROUP BY").add(request.getGroupByColumns()).add("HAVING").add(request.getHavingCondition())
				.toString();
	}

}
