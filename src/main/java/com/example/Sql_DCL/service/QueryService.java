package com.example.Sql_DCL.service;

import java.util.StringJoiner;

import org.springframework.stereotype.Service;

import com.example.Sql_DCL.DTO.DenyRequest;
import com.example.Sql_DCL.DTO.GrantRequest;
import com.example.Sql_DCL.DTO.RevokeRequest;

@Service

public class QueryService {

	public String RevokeQuery(RevokeRequest request) {
		return new StringJoiner(" ").add("REVOKE").add(String.join(", ", request.getPrivileges())).add("ON")
				.add(request.getTableName()).add("FROM").add(request.getUser()).toString();
	}

	public String GrantQuery(GrantRequest request) {
		return "GRANT " + request.getPrivileges() + " ON " + request.getTableName() + " TO " + request.getUser();
	}

	public String DenyQuery(DenyRequest request) {
		return new StringJoiner(" ").add("DENY").add(String.join(", ", request.getPrivileges())).add("ON")
				.add(request.getTableName()).add("TO").add(request.getUser()).toString();
	}

}
