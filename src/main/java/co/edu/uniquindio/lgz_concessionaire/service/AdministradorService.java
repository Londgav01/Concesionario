package co.edu.uniquindio.lgz_concessionaire.service;

import co.edu.uniquindio.lgz_concessionaire.models.Administrador;
import co.edu.uniquindio.lgz_concessionaire.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    private AdministradorRepository administradorRepository;

    public void agregarAdmin(Administrador administrador){
        administradorRepository.save(administrador);
    }
}
