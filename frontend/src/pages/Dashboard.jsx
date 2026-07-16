import { useEffect, useMemo, useState } from "react";
import { getShipments } from "../services/shipmentService";
import ShipmentList from "../components/ShipmentList";

function Dashboard() {
    const [shipments, setShipments] = useState([]);
    const [loading, setLoading] = useState(true);
    const [search, setSearch] = useState("");
    const [statusFilter, setStatusFilter] = useState("ALL");

    useEffect(() => {
        loadShipments();
    }, []);

    const loadShipments = async () => {
        setLoading(true);

        try {
            const response = await getShipments();
            setShipments(response.data);
        } catch (error) {
            console.error("Error loading shipments:", error);
        } finally {
            setLoading(false);
        }
    };

    const filteredShipments = useMemo(() => {
        return shipments.filter((shipment) => {
            const matchesSearch = shipment.customerName
                .toLowerCase()
                .includes(search.toLowerCase());

            const matchesStatus =
                statusFilter === "ALL" ||
                shipment.status === statusFilter;

            return matchesSearch && matchesStatus;
        });
    }, [shipments, search, statusFilter]);

    const total = shipments.length;
    const pending = shipments.filter(s => s.status === "PENDING").length;
    const transit = shipments.filter(s => s.status === "IN_TRANSIT").length;
    const delivered = shipments.filter(s => s.status === "DELIVERED").length;

    return (
        <div className="container mt-4">

            <h2 className="text-center mb-4">
                🚚 Delivery Management Dashboard
            </h2>

            <div className="row mb-4">

                <div className="col-md-3">
                    <div className="card shadow text-center">
                        <div className="card-body">
                            <h5>📦 Total</h5>
                            <h2>{total}</h2>
                        </div>
                    </div>
                </div>

                <div className="col-md-3">
                    <div className="card shadow border-warning text-center">
                        <div className="card-body">
                            <h5>🟡 Pending</h5>
                            <h2>{pending}</h2>
                        </div>
                    </div>
                </div>

                <div className="col-md-3">
                    <div className="card shadow border-primary text-center">
                        <div className="card-body">
                            <h5>🚚 In Transit</h5>
                            <h2>{transit}</h2>
                        </div>
                    </div>
                </div>

                <div className="col-md-3">
                    <div className="card shadow border-success text-center">
                        <div className="card-body">
                            <h5>✅ Delivered</h5>
                            <h2>{delivered}</h2>
                        </div>
                    </div>
                </div>

            </div>

            <div className="row mb-4">

                <div className="col-md-6">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="🔍 Search by Customer Name..."
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                </div>

                <div className="col-md-6">
                    <select
                        className="form-select"
                        value={statusFilter}
                        onChange={(e) => setStatusFilter(e.target.value)}
                    >
                        <option value="ALL">All Status</option>
                        <option value="PENDING">Pending</option>
                        <option value="IN_TRANSIT">In Transit</option>
                        <option value="DELIVERED">Delivered</option>
                    </select>
                </div>

            </div>

            {loading ? (
                <div className="text-center mt-5">
                    <div
                        className="spinner-border text-primary"
                        role="status"
                    >
                        <span className="visually-hidden">
                            Loading...
                        </span>
                    </div>

                    <p className="mt-3">
                        Loading shipments...
                    </p>
                </div>
            ) : (
                <ShipmentList
                    shipments={filteredShipments}
                    refreshShipments={loadShipments}
                />
            )}

        </div>
    );
}

export default Dashboard;