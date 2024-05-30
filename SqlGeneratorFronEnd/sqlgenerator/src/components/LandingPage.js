import React from 'react';
import { Link } from 'react-router-dom';
import './LandingPage.css';

const LandingPage = () => {
  return (
    <div className="landing-page">
      <h1>Make Your Query Easy</h1>
      <Link to="/query-form">
        <button>Get Started</button>
      </Link>
    </div>
  );
};

export default LandingPage;
