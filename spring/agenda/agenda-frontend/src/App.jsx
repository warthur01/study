import { useState } from "react";

import "./App.css";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";

function App() {

    const [authenticated, setAuthenticated] = useState(
        !!localStorage.getItem("authToken")
    );

    if (!authenticated) {
        return (
            <Login
                onLogin={() => setAuthenticated(true)}
            />
        );
    }

    return (
        <Dashboard
            onLogout={() => {
                localStorage.clear();
                setAuthenticated(false);
            }}
        />
    );
}

export default App;