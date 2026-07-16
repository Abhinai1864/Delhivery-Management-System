import api from "../api/axios";

export const createShipment = (shipment) => {
    return api.post("/shipments", shipment);
};

export const getShipments = () => {
    return api.get("/shipments");
};

export const getShipmentById = (id) => {
    return api.get(`/shipments/${id}`);
};

export const updateShipment = (id, shipment) => {
    return api.put(`/shipments/${id}`, shipment);
};

export const deleteShipment = (id) => {
    return api.delete(`/shipments/${id}`);
};