import { useNavigate } from "react-router-dom";
import { deleteShipment } from "../services/shipmentService";
import { toast } from "react-toastify";

function ShipmentList({ shipments, refreshShipments }) {
    const navigate = useNavigate();

    const handleDelete = async (id) => {
        const confirmDelete = window.confirm(
            "Are you sure you want to delete this shipment?"
        );

        if (!confirmDelete) return;

        try {
            await deleteShipment(id);
            toast.success("Shipment deleted successfully!");
            refreshShipments();
        } catch (error) {
            console.error("Error deleting shipment:", error);
            toast.error("Failed to delete shipment.");
        }
    };

    const getStatusBadge = (status) => {
        switch (status) {
            case "PENDING":
                return <span className="badge bg-warning text-dark">Pending</span>;

            case "IN_TRANSIT":
                return <span className="badge bg-primary">In Transit</span>;

            case "DELIVERED":
                return <span className="badge bg-success">Delivered</span>;

            default:
                return <span className="badge bg-secondary">{status}</span>;
        }
    };

    if (shipments.length === 0) {
        return (
            <div className="alert alert-info text-center">
                No shipments found.
            </div>
        );
    }

    return (
        <div className="card shadow">
            <div className="card-header bg-dark text-white">
                <h5 className="mb-0">Shipment List</h5>
            </div>

            <div className="card-body">

                <div className="table-responsive">

                    <table className="table table-hover align-middle">

                        <thead className="table-dark">

                            <tr>
                                <th>ID</th>
                                <th>Customer</th>
                                <th>Address</th>
                                <th>Status</th>
                                <th width="180">Actions</th>
                            </tr>

                        </thead>

                        <tbody>

                            {shipments.map((shipment) => (

                                <tr key={shipment.id}>

                                    <td>{shipment.id}</td>

                                    <td>{shipment.customerName}</td>

                                    <td>{shipment.address}</td>

                                    <td>{getStatusBadge(shipment.status)}</td>

                                    <td>

                                        <button
                                            className="btn btn-warning btn-sm me-2"
                                            onClick={() =>
                                                navigate(`/edit/${shipment.id}`)
                                            }
                                        >
                                            ✏ Edit
                                        </button>

                                        <button
                                            className="btn btn-danger btn-sm"
                                            onClick={() =>
                                                handleDelete(shipment.id)
                                            }
                                        >
                                            🗑 Delete
                                        </button>

                                    </td>

                                </tr>

                            ))}

                        </tbody>

                    </table>

                </div>

            </div>
        </div>
    );
}

export default ShipmentList;