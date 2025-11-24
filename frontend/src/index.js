import React from "react";
import ReactDOM from "react-dom/client";

// Example component for Students Page
function StudentsPage() {
    const [students, setStudents] = React.useState([]);

    React.useEffect(() => {
        // Replace with your Spring Boot API call
        fetch("/api/students")
            .then(res => res.json())
            .then(data => setStudents(data))
            .catch(() => setStudents([
                {id: 1, name: "John Doe"},
                {id: 2, name: "Jane Smith"}
            ]));
    }, []);

    return (
        <div>
            <h2>Student List</h2>
            <ul>
                {students.map(s => <li key={s.id}>{s.name}</li>)}
            </ul>
        </div>
    );
}

// Mount React only where needed
const rootStudents = document.getElementById("students-root");
if (rootStudents) {
    ReactDOM.createRoot(rootStudents).render(<StudentsPage />);
}
