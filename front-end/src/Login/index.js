import React, { useState } from 'react'
import { useLocalState } from '../util/useLocalStorage';

const Login = () => {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const [jwt, setJwt] = useLocalState("jwt", "");

    function sendLoginRequest(){
        const requestBody = {
        username: username,
        password: password
        }
    
        fetch('/api/v1/auth/login', {
        headers: {
            "Content-Type": "application/json"
        },
        method: "post",
        body: JSON.stringify(requestBody)
        })
        .then((response) => {
            if(response.status === 200){
                return Promise.all([response.json(), response.headers]);
            }
            else{
                return Promise.reject("Invalid login attempt!");
            }  
        })
        .then(([body, headers]) => {
            setJwt(headers.get("authorization"));
            window.location.href = "/dashboard";
            })
        .catch((message) => {
            alert(message);
        });
    }

    return (
        <div>
            <h1>Log in!</h1>
                <div>
                    <label htmlFor='username'>Username</label>
                    <input 
                    type='email' 
                    id='username' 
                    value={username}
                    onChange={(event) => setUsername(event.target.value)}
                    />
                </div>
                <div>
                <label htmlFor='password'>Passowrd</label>
                    <input 
                    type='password' 
                    id='password' 
                    value={password}
                    onChange={(event) => setPassword(event.target.value)}
                    />
                </div>
                <div>
                    <button
                    id='submit' 
                    type='button'
                    onClick={() => sendLoginRequest()} >Login</button>
                </div>
        </div>
  )

}

export default Login