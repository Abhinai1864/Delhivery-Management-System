function Footer() {
    return (
        <footer className="bg-dark text-white text-center py-3 mt-5">
            <div className="container">
                <p className="mb-1">
                    🚚 Delivery Management System
                </p>

                <small>
                    Developed by Abhinai © {new Date().getFullYear()}
                </small>
            </div>
        </footer>
    );
}

export default Footer;