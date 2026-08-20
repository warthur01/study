import ContactCard from "./ContactCard";

function ContactList({
                         contacts,
                         onEdit,
                         onDelete
                     }) {

    if (contacts.length === 0) {
        return (
            <h3>Nenhum contato encontrado.</h3>
        );
    }

    return (
        <div className="contacts">

            {contacts.map(contact => (
                <ContactCard
                    key={contact.id}
                    contact={contact}
                    onEdit={onEdit}
                    onDelete={onDelete}
                />
            ))}

        </div>
    );
}

export default ContactList;