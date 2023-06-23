import './App.css';
import { useLocalState } from './util/useLocalStorage'
import { Routes, Route } from 'react-router-dom';
import Dashboard from './Dashboard';
import Home from './Home';
import Login from './Login';
import PrivateRoute from './PrivateRoute';

function App() {

  const [jwt, setJwt] = useLocalState("jwt", "");

  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/dashboard" element={
        <PrivateRoute>
          <Dashboard />
        </PrivateRoute>
      } />
      <Route path='/login' element={<Login />} />
    </Routes>
  );
}

export default App;
