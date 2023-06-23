import React from 'react'
import { useLocalState } from '../util/useLocalStorage';

const Dashboard = () => {

  const [jwt, setJwt] = useLocalState("jwt", "");

  function createAssignment(){
  
    fetch("/api/v1/assignments", {
      method: "post",
      headers:{
        "Content-Type": "application/json",
        Authentication: `Bearer ${jwt}`
      }
    })
    .then(response => {
      if(response.status === 200) return response.json();
    })
    .then((data) => {
      console.log(data);
    });
  }

  return (
    <div>
        <button onClick={() => createAssignment()}>Submit a new Assignment</button>
    </div>
  )
}

export default Dashboard;