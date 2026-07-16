import { BrowserRouter, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Dashboard from "./pages/Dashboard";
import AddShipment from "./pages/AddShipment";
import EditShipment from "./pages/EditShipment";
import Footer from "./components/Footer";

function App() {
    return (
        <BrowserRouter>
         <Navbar />

            <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/add" element={<AddShipment />} />
        <Route path="/edit/:id" element={<EditShipment />} />
    </Routes>

    <Footer />
</BrowserRouter>
    );
}

export default App;