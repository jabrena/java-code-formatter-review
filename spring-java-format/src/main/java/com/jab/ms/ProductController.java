package com.jab.ms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
public class ProductController {

    record Product() {
    }

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list(Model model) {
        Iterable<Product> productList = List.of(new Product());
        return productList;
    }

    @ApiOperation(value = "Search a product with an ID", response = Product.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Product showProduct(@PathVariable Integer id, Model model) {
        Product product = new Product();
        return product;
    }

    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        // Save method
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        // Save method
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a product")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id) {
        // Delete method
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

}
