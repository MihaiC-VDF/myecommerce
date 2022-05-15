package com.vodafone.myecommerce.controler;

//import com.sun.istack.NotNull;

import com.vodafone.myecommerce.model.ProductsEntity;
import com.vodafone.myecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

//import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/products")
public class ProductsController {


    private final ProductsService workingProductsService;

    @Autowired
    public ProductsController(ProductsService workingProductsService) {
        this.workingProductsService = workingProductsService;
    }

    @PostMapping
    public String save(@Valid @RequestBody ProductsEntity receivedProduct) {
        workingProductsService.save(receivedProduct);
        return (receivedProduct.getProductName()+" has been saved successfully");
//        return new HttpServletResponse(200, receivedProduct.getProductName()+" has been saved successfully");
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Integer id) {
        workingProductsService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsEntity> update(@Valid @NotNull @PathVariable("id") Integer id,
                                                 @Valid @RequestBody ProductsEntity receivedProduct) {

    return workingProductsService.update(id, receivedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsEntity> getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return workingProductsService.getById(id);
    }

//    @GetMapping
//    public Page<ProductsEntity> query(@Valid ProductsQueryVO vO) {
//        return productsService.query(vO);
//    }
}
