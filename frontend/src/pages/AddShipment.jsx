import ShipmentForm from "../components/ShipmentForm";

function AddShipment() {
    return (
        <div className="container mt-4">

            <div className="text-center mb-4">
                <h2>📦 Add New Shipment</h2>
                <p className="text-muted">
                    Fill in the shipment details below.
                </p>
            </div>

            <ShipmentForm />

        </div>
    );
}

export default AddShipment;