import axios from 'axios';

const API_BASE_URL = 'http://localhost:8081/query'; // Adjust the base URL according to your backend

const generateQuery = (endpoint, data) => {
  return axios.post(`${API_BASE_URL}/${endpoint}`, data);
};

const QueryService = {
  select: (data) => generateQuery('ddl/select', data),
  distinct: (data) => generateQuery('dql/distinct', data),
  join: (data) => generateQuery('dql/join', data),
  groupBy: (data) => generateQuery('dql/groupBy', data),
  having: (data) => generateQuery('dql/having', data),
  insert: (data) => generateQuery('dml/insert', data),
  update: (data) => generateQuery('dml/update', data),
  delete: (data) => generateQuery('dml/delete', data),
  truncate: (data) => generateQuery('ddl/truncate', data),
  drop: (data) => generateQuery('ddl/drop', data),
  alter: (data) => generateQuery('ddl/alter', data),

  grant: (data) => generateQuery('dcl/grant', data),
  revoke: (data) => generateQuery('dcl/revoke', data),
  deny: (data) => generateQuery('dcl/deny', data),
  createTable: (data) => generateQuery('ddl/createTable', data),

};

export default QueryService;
