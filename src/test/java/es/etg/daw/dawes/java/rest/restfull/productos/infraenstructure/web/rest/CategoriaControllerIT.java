package es.etg.daw.dawes.java.rest.restfull.productos.infraenstructure.web.rest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.categoria.CategoriaFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.producto.ProductoFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaResponse;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.producto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.producto.ProductoResponse;

// Indicamos que es un test de Spring
@SpringBootTest
// Configuramos el cliente MVC
@AutoConfigureMockMvc
// Configuramos los testers de JSON (recuerda que usabamos json en postman)
@AutoConfigureJsonTesters
// Limpiamos el contexto antes de cada test (queremos que todas las pruebas se
// ejecuten sin datos de otras)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class CategoriaControllerIT {
    // Constante para las rutas
    public static String ENDPOINT = "/categorias";

    // Json
    private ObjectMapper mapper = new ObjectMapper();

    // Cargamos el cliente MVC
    @Autowired
    MockMvc mockMvc;

    // Para metodos que tienen una request
    @Autowired
    private JacksonTester<CategoriaRequest> jsonCategoriaRequest;

    // Para métodos que devuelve una respuesta
    @Autowired
    private JacksonTester<CategoriaResponse> jsonCategoriaResponse;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        // Necesitamos registrar este módulo al usar LocalDate en nuestros beans
        // para que funcione bien el mapper de json
        mapper.registerModule(new JavaTimeModule());
    }

    @Test
    @Order(1) // Quiero que se ejecute la primera
    public void When_Get_AllCategorias_Expect_Lista() throws Exception {
        // Productos esperados
        int numCategorias = CategoriaFactory.getDemoData().values().size();

        // Realizo la petición
        MockHttpServletResponse response = mockMvc.perform(
                // método get de http
                get(ENDPOINT).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // Gestiono la respuesta
        List<CategoriaResponse> res = mapper.readValue(response.getContentAsString(),
                mapper.getTypeFactory().constructCollectionType(List.class, CategoriaResponse.class));

        // Evaluo la salida
        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.OK.value()), // Ha ido bien
                () -> assertTrue(res.size() == numCategorias));
    }

    
    @Test
    @Order(10)
    public void When_Post_CreateCategoria() throws Exception{
        Categoria nuevo = CategoriaFactory.create();

        CategoriaRequest req = new CategoriaRequest(nuevo);

            //Realizo la petición POST
        MockHttpServletResponse response = mockMvc.perform(
                        post(ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON)
                                // Le paso el body
                                .content(jsonCategoriaRequest.write(req).getJson())
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

            //Gestiono la respuesta
        CategoriaResponse res = mapper.readValue(response.getContentAsString(), CategoriaResponse.class);

                    //Evaluo la salida
        assertAll(
                () -> assertEquals(response.getStatus(), HttpStatus.CREATED.value()), //Ha ido bien
                () -> assertEquals(res.nombre(), nuevo.getNombre()),
                () -> assertTrue(res.id()>0)
        );
    }
    
}
