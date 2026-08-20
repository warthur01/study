import { useEffect, useState } from "react";

import api from "../services/api";

import ContactForm from "../components/ContactForm";
import ContactList from "../components/ContactList";

function Dashboard({ onLogout }) {

    const [contacts, setContacts] = useState([]);
    const [editing, setEditing] = useState(null);

    const username =
        localStorage.getItem("username");

    const isAdmin =
        username === "admin";

    const loadContacts = async () => {

        try {

            const response =
                await api.get("/contacts");

            setContacts(response.data);

        } catch (error) {

            console.error(error);

            if (
                error.response?.status === 401
            ) {

                localStorage.clear();
                onLogout();
            }
        }
    };

    useEffect(() => {
        loadContacts();
    }, []);

    const deleteContact =
        async (id) => {

            if (!isAdmin) return;

            try {

                await api.delete(
                    `/contacts/${id}`
                );

                loadContacts();

            } catch (error) {

                console.error(error);
            }
        };

    return (
        <div className="container">

            <div className="topbar">

                <h1>
                    📒 Agenda de Contatos
                </h1>

                <button
                    onClick={onLogout}
                >
                    Sair
                </button>

            </div>

            {isAdmin && (
                <ContactForm
                    editing={editing}
                    setEditing={setEditing}
                    loadContacts={loadContacts}
                />
            )}

            <ContactList
                contacts={contacts}
                onEdit={
                    isAdmin
                        ? setEditing
                        : null
                }
                onDelete={
                    isAdmin
                        ? deleteContact
                        : null
                }
            />

        </div>
    );
}

export default Dashboard;