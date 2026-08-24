import { useState } from "react";

function Login({ onLogin }) {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [showPassword, setShowPassword] = useState(false);

    const handleSubmit = (e) => {

        e.preventDefault();

        const token = btoa(
            `${username}:${password}`
        );

        localStorage.setItem(
            "authToken",
            token
        );

        localStorage.setItem(
            "username",
            username
        );

        onLogin();
    };

    return (
        <div className="login-container">

            <form
                className="login-card"
                onSubmit={handleSubmit}
            >

                <h2>🔐 Login</h2>

                <input
                    type="text"
                    placeholder="Usuário"
                    value={username}
                    onChange={(e) =>
                        setUsername(e.target.value)
                    }
                    required
                />

                <div className="password-container">

                    <input
                        type={
                            showPassword
                                ? "text"
                                : "password"
                        }
                        placeholder="Senha"
                        value={password}
                        onChange={(e) =>
                            setPassword(e.target.value)
                        }
                        required
                    />

                    <button
                        type="button"
                        className="show-password"
                        onClick={() =>
                            setShowPassword(
                                !showPassword
                            )
                        }
                    >
                        {showPassword
                            ? "Ocultar"
                            : "Mostrar"}
                    </button>

                </div>

                <button type="submit">
                    Entrar
                </button>

                <hr />

                <p>
                    <strong>Admin:</strong>
                    {" "}admin / admin123
                </p>

                <p>
                    <strong>User:</strong>
                    {" "}user / user123
                </p>

            </form>

        </div>
    );
}

export default Login;