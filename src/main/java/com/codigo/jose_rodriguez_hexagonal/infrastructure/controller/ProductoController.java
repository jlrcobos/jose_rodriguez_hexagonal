package com.codigo.jose_rodriguez_hexagonal.infrastructure.controller;

import com.codigo.jose_rodriguez_hexagonal.application.service.ProductoService;
import com.codigo.jose_rodriguez_hexagonal.dominio.models.Producto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @Operation(summary = "Listar productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación correcta",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Producto.class))) }),
            @ApiResponse(responseCode = "500", description = "Error en el server",
                    content = @Content)})
    @GetMapping
    public ResponseEntity<List<Producto>> getAll(){
        List<Producto> productos= productoService.getAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @Operation(summary = "Obtener producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error en el server",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Integer id){
        Optional<Producto> producto=productoService.findById(id);
        if(producto.isPresent()) return new ResponseEntity<>(producto.get(),HttpStatus.OK);
        else return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Operation(summary = "Agregar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto agregado correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error en el server",
                    content = @Content) })
    @PostMapping
    public ResponseEntity<Producto> save(@Valid @RequestBody Producto request){
        return  new ResponseEntity<>(productoService.save(request),HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class)) }),
            @ApiResponse(responseCode = "500", description = "Error en el server",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",
                    content = @Content) })
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id,@RequestBody Producto request){
        return productoService.update(request,id)
                .map(ResponseEntity::ok)
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @Operation(summary = "Eliminar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error en el server",content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado",content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        Optional<Producto> producto=productoService.findById(id);
        if(producto.isPresent()) {
            productoService.delete(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
