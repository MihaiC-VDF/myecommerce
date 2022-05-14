package com.vodafone.myecommerce.controler;

import com.sun.istack.NotNull;
import com.vodafone.myecommerce.dto.ProductsDTO;
import com.vodafone.myecommerce.model.Products;
import com.vodafone.myecommerce.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Validated
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    public String save(@Valid @RequestBody Products receivedProduct) {
        productsService.save(receivedProduct);
        return (receivedProduct.getProductName()+" has been saved successfully");
//        return new HttpServletResponse(200, receivedProduct.getProductName()+" has been saved successfully");
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productsService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Products receivedProduct) {

    return productsService.update(id, receivedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productsService.getById(id);
    }

//    @GetMapping
//    public Page<Products> query(@Valid ProductsQueryVO vO) {
//        return productsService.query(vO);
//    }
}
