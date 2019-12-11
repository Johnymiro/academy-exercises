import React from 'react';
import './App.css';
import Nav from './component/navbar';

function App() {
  return (
    <div className="App" >
       <div className="header">
          <Nav />
       </div>
       <div className="main">
          main
       </div>
       <div className="footer">
          footer
       </div>
    </div>
  );
}

export default App;
