package com.boulevar.Soft.Boulevar.Controller.IntegrationTest;

import com.boulevar.Soft.Boulevar.Dao.API.EmpleadoDaoAPI;
import com.boulevar.Soft.Boulevar.models.Empleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmpleadoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmpleadoDaoAPI empleadoDaoAPI;

    @Test
    void testGetAllEmpleados() throws Exception {
        mockMvc.perform(get("/api/empleados/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetEmpleadoById() throws Exception {
        Empleado empleado = new Empleado(26, "Juan", "Perez", "555123456", "12345678", 50000, "juan.perez@example.com", LocalDate.of(1990, 1, 1), null);
        empleado = empleadoDaoAPI.save(empleado);

        mockMvc.perform(get("/api/empleados/show/" + empleado.getIdEmpleado())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombres").value("Juan"));
    }

    @Test
    void testSaveEmpleado() throws Exception {
        mockMvc.perform(post("/api/empleados/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombres\":\"Juan\",\"apellidos\":\"Perez\",\"celular\":\"555123456\",\"cedulaIdentidad\":\"12345678\",\"sueldo\":50000,\"correo\":\"juan.perez@example.com\",\"fechaNacimiento\":\"1990-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombres").value("Juan"));
    }

    @Test
    void testDeleteEmpleado() throws Exception {
        Empleado empleado = new Empleado(30, "Juan", "Perez", "555123456", "12345678", 50000, "juan.perez@example.com", LocalDate.of(1990, 1, 1), null);
        empleado = empleadoDaoAPI.save(empleado);

        mockMvc.perform(delete("/api/empleados/delete/" + empleado.getIdEmpleado())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Empleado eliminado con éxito"));
    }

}
