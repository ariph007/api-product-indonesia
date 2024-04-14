package com.alpha.products.AlphaProducts.controller;

import com.alpha.products.AlphaProducts.model.response.GetProduct;
import com.alpha.products.AlphaProducts.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1"})
@RequiredArgsConstructor
public class ProductController {
  private final ProductService service;

  @GetMapping(value = "/products-barcode", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<GetProduct> getProductByBarcode(@RequestParam(required = true) String barcode,
      @RequestParam(required = false) Boolean generateBarcode) {
    return ResponseEntity.ok(service.getProductByBarcode(barcode, generateBarcode));
  }

  @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<GetProduct>> getProductByName(@RequestParam(required = true) String name) {
    return ResponseEntity.ok(service.getProductsByName(name));
  }

}
