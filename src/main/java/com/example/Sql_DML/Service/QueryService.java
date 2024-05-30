

package com.example.Sql_DML.Service;

import org.springframework.stereotype.Service;

import com.example.Sql_DML.DTO.*;

import java.util.List;
import java.util.StringJoiner;

@Service
public class QueryService {

	public String InsertQuery(InsertQueryRequest request) {
		return new StringJoiner(" ").add("INSERT INTO").add(request.getTable()).add("(" + request.getColumns() + ")")
				.add("VALUES").add("(" + request.getValues() + ")").toString();
	}

	public String UpdateQuery(UpdateQueryRequest request) {
		return new StringJoiner(" ").add("UPDATE").add(request.getTable()).add("SET").add(request.getSetValues())
				.add("WHERE").add(request.getCondition()).toString();
	}

	public String DeleteQuery(DeleteQueryRequest request) {
		return new StringJoiner(" ").add("DELETE FROM").add(request.getTable()).add("WHERE").add(request.getCondition())
				.toString();
	}

}
