import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import LandingPage from './components/LandingPage';
import QueryForm from './components/Form';
import QueryService from './components/Service';

const App = () => {
  const [selectedForm, setSelectedForm] = useState('');
  const [formKey, setFormKey] = useState(0); // Unique key for resetting the form

  const handleFormChange = (event) => {
    setSelectedForm(event.target.value);
    setFormKey((prevKey) => prevKey + 1); // Change key to reset form state
  };

  const forms = [
    { value: 'select', label: 'Select Query', fields: ['table', 'columns', 'condition', 'orderBy', 'limit'], requiredFields: ['table', 'columns'] },
    { value: 'distinct', label: 'Distinct Query', fields: ['table', 'columns'], requiredFields: ['table', 'columns'] },
    { value: 'join', label: 'Join Query', fields: ['table', 'columns', 'joinTable', 'joinCondition'], requiredFields: ['table', 'columns', 'joinTable', 'joinCondition'] },
    { value: 'groupBy', label: 'Group By Query', fields: ['table', 'columns', 'groupByColumns'], requiredFields: ['table', 'columns', 'groupByColumns'] },
    { value: 'having', label: 'Having Query', fields: ['table', 'columns', 'groupByColumns', 'havingCondition'], requiredFields: ['table', 'columns', 'groupByColumns', 'havingCondition'] },
    { value: 'insert', label: 'Insert Query', fields: ['table', 'columns', 'values'], requiredFields: ['table', 'columns', 'values'] },
    { value: 'update', label: 'Update Query', fields: ['table', 'setValues', 'condition'], requiredFields: ['table', 'setValues', 'condition'] },
    { value: 'delete', label: 'Delete Query', fields: ['table', 'condition'], requiredFields: ['table', 'condition'] },
    { value: 'truncate', label: 'Truncate Table Query', fields: ['tableName'], requiredFields: ['tableName'] },
    { value: 'drop', label: 'Drop Table Query', fields: ['tableName'], requiredFields: ['tableName'] },
    { value: 'alter', label: 'Alter Table Query', fields: ['table', 'operation'], requiredFields: ['table', 'operation'] },
    { value: 'grant', label: 'Grant Query', fields: ['privileges', 'tableName', 'user'], requiredFields: ['privileges', 'tableName', 'user'] },
    { value: 'revoke', label: 'Revoke Query', fields: ['privileges', 'tableName', 'user'], requiredFields: ['privileges', 'tableName', 'user'] },
    { value: 'deny', label: 'Deny Query', fields: ['privileges', 'tableName', 'user'], requiredFields: ['privileges', 'tableName', 'user'] },
    { value: 'createTable', label: 'Create Table Query', fields: ['tableName', 'columns'], requiredFields: ['tableName', 'columns'] },
  
  ];

  const QueryFormPage = () => (
    <div className="query-form-page">
      <h1 style={{ textAlign: 'center' }}>Query Generator</h1>

      <div className="form-control">
        <label htmlFor="select-form">Select Form</label>
        <select id="select-form" value={selectedForm} onChange={handleFormChange}>
          <option value="" disabled>Select a form</option>
          {forms.map((form, index) => (
            <option key={index} value={form.value}>{form.label}</option>
          ))}
        </select>
      </div>

      {selectedForm && (
        <QueryForm
          key={formKey} // Use key to reset form
          endpoint={selectedForm}
          fields={forms.find((form) => form.value === selectedForm).fields}
          requiredFields={forms.find((form) => form.value === selectedForm).requiredFields}
          queryService={QueryService}
        />
      )}
    </div>
  );

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<LandingPage />} />
          <Route path="/query-form" element={<QueryFormPage />} />
        </Routes>
      </div>
    </Router>
  );
};

export { App };


