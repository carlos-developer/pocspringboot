package com.pocspringboot.demo;

import com.pocspringboot.demo.model.Libro;
import com.pocspringboot.demo.model.Producto;
import com.pocspringboot.demo.myBeans.MiBean;
import com.pocspringboot.demo.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Routes {

    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    private OrderService orderService;
    private MiBean miBean;

    public Routes(OrderService orderService, MiBean miBean) {
        this.orderService = orderService;
        this.miBean = miBean;
    }

    @GetMapping("hola")
    String miPrimerRuta() {
        return "Hola MUndo";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro id :" + id + ", editorial: " + editorial;
    }

    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params) {
        return "Leyendo el libro id :" + id + ", params: " + params;
    }

    @PostMapping("/libro")
    String guardarLibro(@RequestBody Map<String, Object> libro) {
        libro.keySet().forEach(llave -> {
            logger.debug("LLave {} valor {}", llave, libro.get(llave));
        });

        return "Libro guardado";
    }

    @PostMapping("/libro2")
    String guardarLibro2(@RequestBody Libro libro) {
        logger.debug("LLave {} valor {}", libro.getNombre(), libro.getEditorial());

        return "Libro guardado";
    }

    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Se movio a otra ruta")
    String saludar() {

        return "Te envio saludo";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
        if(lugar.equals("granja")){
            return ResponseEntity.status(HttpStatus.OK).body("Animales de Granja");
        }
        if(lugar.equals("selva")) {
            return ResponseEntity.status(HttpStatus.OK).body("Animales de selva");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lugar no valido");

    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("La clave del usuario es password 123");
    }

    @PostMapping("/order")
    public String crearOrden(@RequestBody List<Producto> products) {
        orderService.saveOrder(products);
        return "Productos guradados";
    }

    @GetMapping("/mibean")
    public String saludos() {
        return miBean.saludar();
    }
}
