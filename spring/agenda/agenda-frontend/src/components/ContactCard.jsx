function ContactCard({
                         contact,
                         onEdit,
                         onDelete
                     }) {

    const isAdmin =
        onEdit && onDelete;

    return (

        <div className="card">

            <h3>
                {contact.name}
            </h3>

            <p>
                <strong>Email:</strong>
                {" "}
                {contact.email}
            </p>

            <p>
                <strong>Telefone:</strong>
                {" "}
                {contact.number}
            </p>

            {isAdmin && (

                <div className="actions">

                    <button
                        onClick={() =>
                            onEdit(contact)
                        }
                    >
                        Editar
                    </button>

                    <button
                        className="danger"
                        onClick={() =>
                            onDelete(
                                contact.id
                            )
                        }
                    >
                        Excluir
                    </button>

                </div>

            )}

        </div>
    );
}

export default ContactCard;