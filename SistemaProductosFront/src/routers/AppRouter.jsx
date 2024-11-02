import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import {PublicLayout, PrivateLayout} from '../layouts';
import {LoginPage, HomePage, CatProductoPage} from '../pages';
import PrivateRoute from './PrivateRoute';

const AppRouter = () => {
    return (
        <Router>
            <Routes>

                {/* Rutas Públicas */}
                <Route path="/" element={<PublicLayout/>}>
                    <Route index element={<LoginPage />}/>
                </Route>

                {/* Rutas Privadas */}
                <Route element={<PrivateRoute><PrivateLayout /></PrivateRoute>}>

                    <Route path="home" element={<HomePage />}/>
                    <Route path="categoria_producto" element={<CatProductoPage />}/>
                </Route>
            </Routes>
        </Router>
    );
};

export default AppRouter;