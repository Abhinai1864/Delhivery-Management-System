import ShipmentForm from "../components/ShipmentForm";

function EditShipment() {
    return (
        <div className="container mt-4">

            <div className="text-center mb-4">
                <h2>✏ Edit Shipment</h2>
                <p className="text-muted">
                    Update the shipment information.
                </p>
            </div>

            <ShipmentForm />

        </div>
    );
}

export default EditShipment;