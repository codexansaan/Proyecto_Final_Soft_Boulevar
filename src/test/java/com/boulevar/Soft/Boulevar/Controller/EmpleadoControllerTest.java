package com.boulevar.Soft.Boulevar.Controller;

import com.boulevar.Soft.Boulevar.Service.API.EmpleadoServiceAPI;
import com.boulevar.Soft.Boulevar.models.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class EmpleadoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmpleadoServiceAPI empleadoServiceAPI;

    @InjectMocks
    private EmpleadoController empleadoController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(empleadoController).build();
    }

    @Test
    void testGetAllEmpleados() throws Exception {
        Empleado empleado1 = new Empleado(1, "Juan", "Perez", "555123456", "12345678", 50000, "juan.perez@example.com", LocalDate.of(1990, 1, 1), null);
        Empleado empleado2 = new Empleado(2, "Ana", "Lopez", "555987654", "87654321", 60000, "ana.lopez@example.com", LocalDate.of(1992, 2, 2), null);

        when(empleadoServiceAPI.getAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        mockMvc.perform(get("/api/empleados/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombres").value("Juan"))
                .andExpect(jsonPath("$[1].nombres").value("Ana"));
    }

    @Test
    void testGetEmpleadoById() throws Exception {
        Empleado empleado = new Empleado(1, "Juan", "Perez", "555123456", "12345678", 50000, "juan.perez@example.com", LocalDate.of(1990, 1, 1), null);

        when(empleadoServiceAPI.get(1)).thenReturn(empleado);

        mockMvc.perform(get("/api/empleados/show/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombres").value("Juan"));
    }

    @Test
    void testSaveEmpleado() throws Exception {
        Empleado empleado = new Empleado(1, "Juan", "Perez", "555123456", "12345678", 50000, "juan.perez@example.com", LocalDate.of(1990, 1, 1), null);

        when(empleadoServiceAPI.save(any(Empleado.class))).thenReturn(empleado);

        mockMvc.perform(post("/api/empleados/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombres\":\"Juan\",\"apellidos\":\"Perez\",\"celular\":\"555123456\",\"cedulaIdentidad\":\"12345678\",\"sueldo\":50000,\"correo\":\"juan.perez@example.com\",\"fechaNacimiento\":\"1990-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombres").value("Juan"));
    }

    @Test
    void testDeleteEmpleado() throws Exception {
        doNothing().when(empleadoServiceAPI).deleted(1);

        mockMvc.perform(delete("/api/empleados/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Empleado eliminado con éxito"));
    }


}
