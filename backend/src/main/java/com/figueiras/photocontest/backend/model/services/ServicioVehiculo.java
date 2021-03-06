package com.figueiras.photocontest.backend.model.services;

import com.figueiras.photocontest.backend.model.exceptions.CampoDuplicadoException;
import com.figueiras.photocontest.backend.model.exceptions.InstanceNotFoundException;
import com.figueiras.photocontest.backend.rest.dtos.Matr√≠culasDispPorPerDto;
import com.figueiras.photocontest.backend.rest.dtos.VehiculoDto;

import java.util.List;

public interface ServicioVehiculo {

    void registrarVehiculo(VehiculoDto vehiculoDto) throws CampoDuplicadoException, InstanceNotFoundException;
    List<String> getTodasMatriculas();
    List<Matr√≠culasDispPorPerDto> getMatriculasByPer();
}
