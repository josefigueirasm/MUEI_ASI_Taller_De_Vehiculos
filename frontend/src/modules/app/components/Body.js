import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {Container} from 'react-bootstrap';
import User from '../../user/components/User';
import Home from './Home';
import Registrar from '../../user/components/Registrar';
import LogIn from '../../user/components/LogIn';
import ChanguePassword from '../../user/components/ChanguePassword';
import ChangueProfileData from '../../user/components/ChangueProfileData';
import RecoverUser from '../../user/components/RecoverUser';
import ResetPassword from '../../user/components/ResetPassword';
import PaginaHorario from '../../horario/components/PaginaHorario';
import Reparacion from '../../reparacion/components/Reparacion';
import RegistrarMecanico from "../../user/components/RegistrarMecanico";
import RegistrarCliente from "../../user/components/RegistrarCliente";
import RegistrarAdministrativo from "../../user/components/RegistrarAdministrativo";
import AnadirTrabajo from "../../reparacion/components/AnadirTrabajo";
import BuscarTrabajos from "../../reparacion/components/BuscarTrabajos";
import Trabajo from "../../reparacion/components/Trabajo";
import AnadirAtraso from "../../reparacion/components/AnadirAtraso";
import BuscarReparacionesAtrasadas from "../../reparacion/components/BuscarReparacionesAtrasadas";
import ActualizarReparacion from "../../reparacion/components/ActualizarReparacion";

const Body = () => {

    return (

        <Container>
            <br/>
            <Switch>
                <Route exact path="/"><Home/></Route>
                <Route exact path="/trabajos"><BuscarTrabajos/></Route>
                <Route exact path="/trabajos/nuevo"><AnadirTrabajo/></Route>
                <Route exact path="/trabajos/:idTrabajo"><Trabajo/></Route>
                <Route exact path="/usuarios/registrar"><Registrar/></Route>
                <Route exact path="/usuarios/registrar/mec"><RegistrarMecanico/></Route>
                <Route exact path="/usuarios/registrar/cli"><RegistrarCliente/></Route>
                <Route exact path="/usuarios/registrar/adm"><RegistrarAdministrativo/></Route>
                <Route exact path="/users/login"><LogIn/></Route>
                <Route exact path="/users/recover"><RecoverUser/></Route>
                <Route exact path="/users/:userName"><User/></Route>
                <Route exact path="/users/:userName/changue-password"><ChanguePassword/></Route>
                <Route exact path="/users/:userName/reset-password/:token"><ResetPassword/></Route>
                <Route exact path="/users/:userName/changue-data"><ChangueProfileData/></Route>
                <Route exact path="/horario"><PaginaHorario/></Route>
                <Route exact path="/reparacion"><Reparacion/></Route>
                <Route exact path="/reparaciones/:idReparacion/actualizar"><ActualizarReparacion/></Route>
                <Route exact path="/reparaciones/:idReparacion"><Reparacion/></Route>
                <Route exact path="/reparaciones/:idReparacion/atraso"><AnadirAtraso/></Route>
                <Route exact path="/reparaciones-atrasadas"><BuscarReparacionesAtrasadas/></Route>
                <Route><Home/></Route>
            </Switch>
        </Container>

    );

};

export default Body;
