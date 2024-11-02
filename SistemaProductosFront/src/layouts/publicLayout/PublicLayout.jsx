import React from "react";
import { Outlet } from 'react-router-dom';


const PublicLayout = ({ children }) => {
    return (
        <>
            <div>
                <Outlet />
            </div>
        </>
    );
};

export default PublicLayout;