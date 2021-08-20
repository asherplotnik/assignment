package com.example.demo.services;

import com.example.demo.Repositories.ProductRepo;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.ApiException;
import com.example.demo.exceptions.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product getProduct(int id) throws ApiException {
            Optional<Product> productOpt = productRepo.findById(id);
            if (productOpt.isEmpty()) {
                throw new ApiException(new ErrorDetails(HttpStatus.NOT_FOUND, "id not found", "my app"));
            }
            return productOpt.get();
    }

    public Product addProduct(Product product) throws ApiException {
        try {
            product.setId(0);
            return productRepo.save(product);
        } catch (Exception e){
            throw new ApiException(new ErrorDetails(HttpStatus.BAD_REQUEST,"failed to add product","my app"));
        }
    }
}
