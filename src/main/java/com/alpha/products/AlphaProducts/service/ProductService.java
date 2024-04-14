package com.alpha.products.AlphaProducts.service;

import com.alpha.products.AlphaProducts.model.response.GetProduct;
import java.util.List;

public interface ProductService {
  List<GetProduct> getProductsByName(String name);
  GetProduct getProductByBarcode(String barcode, Boolean generateBarcode);
}
