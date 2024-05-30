import React, { useState } from 'react';
import './Form.css';

const QueryForm = ({ endpoint, fields, requiredFields, queryService }) => {
  const [formData, setFormData] = useState({});
  const [response, setResponse] = useState('');
  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validate = () => {
    let formIsValid = true;
    let errors = {};

    requiredFields.forEach((field) => {
      if (!formData[field]) {
        formIsValid = false;
        errors[field] = 'This field is required';
      }
    });

    setErrors(errors);
    return formIsValid;
  };

  

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (validate()) {
      try {
        const dataToSubmit = { ...formData };
 
        // Convert privileges to array if the endpoint requires it
        if (endpoint === 'grant' || endpoint === 'revoke' || endpoint === 'deny') {
          if (formData.privileges) {
            dataToSubmit.privileges = formData.privileges.split(',').map(privilege => privilege.trim());
          }
        }

        if (endpoint === 'generateCreateTableQuery' && formData.columns) {
          try {
            dataToSubmit.columns = JSON.parse(formData.columns);
          } catch (err) {
            setResponse('Invalid columns JSON format');
            return;
          }
        }
 
       
        const response = await queryService[endpoint](dataToSubmit);
        setResponse(response.data);
      } catch (error) {
        setResponse(error.message);
      }
    }
  };

  return (
    <div className="query-form">
      <div className="form-left">
        {fields.map((field, index) => (
          <div key={index} className="form-group">
            <label htmlFor={field}>{field}</label>
            <input
              type="text"
              id={field}
              name={field}
              value={formData[field] || ''}
              onChange={handleChange}
              className={errors[field] ? 'error' : ''}
            />
            {errors[field] && <span className="error">{errors[field]}</span>}
          </div>
        ))}
      </div>
      <div className="form-right">
        <div className="button-container">
          <button className="submit-button" type="submit" onClick={handleSubmit}>
            Generate Query
          </button>
        </div>
        <div className="response">{response}</div>
      </div>
    </div>
  );
};

export default QueryForm;
