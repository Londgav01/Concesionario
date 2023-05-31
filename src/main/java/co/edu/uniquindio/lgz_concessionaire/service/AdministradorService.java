package co.edu.uniquindio.lgz_concessionaire.service;

import co.edu.uniquindio.lgz_concessionaire.models.Administrador;
import co.edu.uniquindio.lgz_concessionaire.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    public void crearAdministrador() {
        Administrador administrador = (Administrador) new Administrador.AdministradorBuilder()
                .withNombre("Robinson")
                .withId("12345")
                .withDireccion("cra 12")
                .build();
        administradorRepository.save(administrador);
    }
}
