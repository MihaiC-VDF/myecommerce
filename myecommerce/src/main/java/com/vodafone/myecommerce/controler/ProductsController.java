package com.vodafone.myecommerce.controler;

import com.sun.istack.NotNull;
import com.vodafone.myecommerce.model.ProductsEntity;
import com.vodafone.myecommerce.service.ProductsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.servlet.http.HttpServletResponse;

@Validated
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping
    public String save(@Valid @RequestBody ProductsEntity receivedProduct) {
        productsService.save(receivedProduct);
        return (receivedProduct.getProductName()+" has been saved successfully");
//        return new HttpServletResponse(200, receivedProduct.getProductName()+" has been saved successfully");
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productsService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsEntity> update(@Valid @NotNull @PathVariable("id") Integer id,
                                                 @Valid @RequestBody ProductsEntity receivedProduct) {

    return productsService.update(id, receivedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsEntity> getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productsService.getById(id);
    }

//    @GetMapping
//    public Page<ProductsEntity> query(@Valid ProductsQueryVO vO) {
//        return productsService.query(vO);
//    }
}
