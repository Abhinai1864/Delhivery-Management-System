import { useEffect, useState } from "react";
import {
    createShipment,
    getShipmentById,
    updateShipment,
} from "../services/shipmentService";
import { useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";

function ShipmentForm() {
    const navigate = useNavigate();
    const { id } = useParams();

    const [shipment, setShipment] = useState({
        customerName: "",
        address: "",
        status: "PENDING",
    });

    useEffect(() => {
        if (id) {
            loadShipment();
        }
    }, [id]);

    const loadShipment = async () => {
        try {
            const response = await getShipmentById(id);
            setShipment(response.data);
        } catch (error) {
            console.error("Error loading shipment:", error);
            alert("Failed to load shipment.");
        }
    };

    const handleChange = (e) => {
        setShipment({
            ...shipment,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            if (id) {
                await updateShipment(id, shipment);
                toast.success("Shipment Updated Successfully!");
            } else {
                await createShipment(shipment);
                toast.success("Shipment Added Successfully!");
            }

            navigate("/");
        } catch (error) {
            console.error("Error saving shipment:", error);
            toast.error("Failed to save shipment.");
        }
    };

    return (
        <div className="card shadow mt-4">
            <div className="card-header bg-primary text-white">
                <h4 className="mb-0">
                    {id ? "Edit Shipment" : "Add Shipment"}
                </h4>
            </div>

            <div className="card-body">
                <form onSubmit={handleSubmit}>

                    <div className="mb-3">
                        <label className="form-label">
                            Customer Name
                        </label>
                        <input
                            type="text"
                            className="form-control"
                            name="customerName"
                            value={shipment.customerName}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">
                            Address
                        </label>
                        <input
                            type="text"
                            className="form-control"
                            name="address"
                            value={shipment.address}
                            onChange={handleChange}
                            required
                        />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">
                            Status
                        </label>

                        <select
                            className="form-select"
                            name="status"
                            value={shipment.status}
                            onChange={handleChange}
                        >
                            <option value="PENDING">Pending</option>
                            <option value="IN_TRANSIT">In Transit</option>
                            <option value="DELIVERED">Delivered</option>
                        </select>
                    </div>

                    <button
                        type="submit"
                        className="btn btn-success"
                    >
                        {id ? "Update Shipment" : "Save Shipment"}
                    </button>

                    <button
                        type="button"
                        className="btn btn-secondary ms-2"
                        onClick={() => navigate("/")}
                    >
                        Cancel
                    </button>

                </form>
            </div>
        </div>
    );
}

export default ShipmentForm;