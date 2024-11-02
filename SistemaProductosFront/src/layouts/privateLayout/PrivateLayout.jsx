import React from "react";
import { Outlet } from 'react-router-dom';


const PrivateLayout = ({ children }) => {
    return (
        <div>
            <main>
                <Outlet />
            </main>
        </div>
    );
};

export default PrivateLayout;