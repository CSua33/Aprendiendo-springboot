package com.example.practica;

import com.example.practica.models.Libro;
import com.example.practica.models.Producto;
import com.example.practica.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //define rutas
public class Rutas {
    private OrderService orderService = new OrderService();
    private Logger logger = LoggerFactory.getLogger(PracticaApplication.class);
    @GetMapping("/get")//dentro del parentesis se define el nombre de la ruta
    String miPrimerGet (){
        return "Mi primer Get";
    }
    @GetMapping("/libro/{id}/editorial/{editorial}")//Path parameter
    String leerLibro (@PathVariable int id, @PathVariable String editorial){
        return "Leyendo el libro id:" + id + ", Editorial:" + editorial;
    }
    @GetMapping("/libro2/{id}")//Query Params
    //ejemplo de url http://localhost:8080/libro2/1?editorial=Pearson&genero=Ficcion
    String leerLibro2 (@PathVariable int id, @RequestParam String editorial, @RequestParam String genero){
        return "Leyendo el libro id:" + id + ", Editorial:" + editorial + ", Genero:" + genero;
    }
    @PostMapping("/libro")//en un Post la informacion mandada suele estar en el body
    /* JSON ingresado en postman
    {
    "Gato": "Felix",
    "Perro": "Chinto"
     */
    String guardarLibro(@RequestBody Map<String, Object> libro){//iterar en todo el json no es eficiente
        libro.keySet().forEach(llave -> {
            logger.info("llave {} valor {}", llave, libro.get(llave)); //las llaves aqui se usan para indicar la variable
        });
        return "Libro guardado";
    }
    @PostMapping("/libro3")//Recibe json
   /* JSON ingresado en postman
   {
        "nombre": "Harry Potter",
            "editorial": "Pearson"
    }*/
    String guardarLibro(@RequestBody Libro libro){//iterar en todo el json no es eficiente
        logger.info("Nombre: {} editorial: {}", libro.nombre, libro.editorial); //las llaves aqui se usan para indicar la variable
        return "Libro guardado";
    }
    @GetMapping("/status")//en application.properties podemos hacer que el status siempre se muestre
    @ResponseStatus(value= HttpStatus.MOVED_PERMANENTLY, reason = "Cambiamos de pagina")
    String verStatus(){
        return "Libro guardado";
    }

    @PostMapping("/order")//Recibe json
   /* JSON ingresado en postman
    [
        {"nombre": "Pantalla LCD","precio": 100},
        {"nombre": "Radio","precio": 50}
    ]*/
    String createOrder(@RequestBody List<Producto> products){
        orderService.saveOrder(products);
        return "Productos guardados";
    }

}
