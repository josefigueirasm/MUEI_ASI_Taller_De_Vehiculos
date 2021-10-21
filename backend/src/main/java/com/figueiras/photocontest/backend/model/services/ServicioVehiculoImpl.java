package com.figueiras.photocontest.backend.model.services;

import com.figueiras.photocontest.backend.model.daos.FlotaDao;
import com.figueiras.photocontest.backend.model.daos.MarcaDao;
import com.figueiras.photocontest.backend.model.daos.ModeloDao;
import com.figueiras.photocontest.backend.model.daos.VehiculoDao;
import com.figueiras.photocontest.backend.model.entities.Flota;
import com.figueiras.photocontest.backend.model.entities.Modelo;
import com.figueiras.photocontest.backend.model.entities.Vehiculo;
import com.figueiras.photocontest.backend.model.exceptions.CampoDuplicadoException;
import com.figueiras.photocontest.backend.model.exceptions.InstanceNotFoundException;
import com.figueiras.photocontest.backend.rest.dtos.VehiculoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioVehiculoImpl implements ServicioVehiculo{

    @Autowired
    private VehiculoDao vehiculoDao;

    @Autowired
    private ModeloDao modeloDao;

    @Autowired
    private MarcaDao marcaDao;

    @Autowired
    private FlotaDao flotaDao;

    @Override
    public void registrarVehiculo(VehiculoDto vehiculoDto) throws CampoDuplicadoException, InstanceNotFoundException {

        Optional<Vehiculo> vehOptionalByMatricula = vehiculoDao.findByMatricula(vehiculoDto.getMatricula());
        Optional<Vehiculo> vehOptionalByNumBastidor = vehiculoDao.findByNumBastidor(vehiculoDto.getMatricula());
        // Se valida que la matrícula sea única
        if(vehOptionalByMatricula.isPresent()){
            throw new CampoDuplicadoException("entidades.vehiculo.matricula", vehiculoDto.getMatricula());
        }
        // Se valida que el numBastidor sea único
        if(vehOptionalByNumBastidor.isPresent()){
            throw new CampoDuplicadoException("entidades.vehiculo.numBastidor", vehiculoDto.getNumBastidor());
        }

        Optional<Modelo> vehModelo = Optional.empty();
        if (vehiculoDto.getModelo() != null) {
            vehModelo = modeloDao.findById(vehiculoDto.getModelo());
            if (vehModelo.isEmpty()) {
                throw new InstanceNotFoundException("entidades.modelo.idModelo", vehiculoDto.getModelo());
            }
        }

        Optional<Flota> vehFlota = Optional.empty();
        if (vehiculoDto.getFlota() != null) {
            vehFlota = flotaDao.findById(vehiculoDto.getFlota());
            if (vehFlota.isEmpty()) {
                throw new InstanceNotFoundException("entidades.flota.idFlota", vehiculoDto.getFlota());
            }
        }

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula(vehiculoDto.getMatricula());
        vehiculo.setNumBastidor(vehiculoDto.getNumBastidor());
        vehModelo.ifPresent(vehiculo::setModelo);
        vehFlota.ifPresent(vehiculo::setFlota);
        vehiculoDao.save(vehiculo);
    }



}
