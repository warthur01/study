import { useEffect, useState } from "react";
import api from "../services/api";

function ContactForm({
                         editing,
                         setEditing,
                         loadContacts
                     }) {

    const [contact, setContact] = useState({
        name: "",
        email: "",
        number: ""
    });

    useEffect(() => {

        if (editing) {
            setContact(editing);
        }

    }, [editing]);

    const handleChange = (e) => {

        setContact({
            ...contact,
            [e.target.name]: e.target.value
        });
    };

    const clearForm = () => {

        setContact({
            name: "",
            email: "",
            number: ""
        });

        setEditing(null);
    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            if (editing) {

                await api.put(
                    `/contacts/${contact.id}`,
                    contact
                );

            } else {

                await api.post(
                    "/contacts",
                    contact
                );
            }

            clearForm();
            loadContacts();

        } catch (error) {

            console.error(error);

            const message =
                error.response?.data?.message ||
                error.response?.data ||
                "Erro ao salvar contato";

            alert(message);
        }
    };

    return (

        <form onSubmit={handleSubmit}>

            <input
                type="text"
                name="name"
                placeholder="Nome"
                value={contact.name}
                onChange={handleChange}
                required
            />

            <input
                type="email"
                name="email"
                placeholder="Email"
                value={contact.email}
                onChange={handleChange}
                required
            />

            <input
                type="text"
                name="number"
                placeholder="Telefone"
                value={contact.number}
                onChange={handleChange}
                required
            />

            <button type="submit">
                {editing ? "Atualizar" : "Salvar"}
            </button>

            {editing && (
                <button
                    type="button"
                    onClick={clearForm}
                >
                    Cancelar
                </button>
            )}

        </form>
    );
}

export default ContactForm;