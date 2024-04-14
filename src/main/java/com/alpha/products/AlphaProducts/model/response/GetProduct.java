package com.alpha.products.AlphaProducts.model.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProduct {
  private String id;
  private String barcode;
  private String name;
  private BigDecimal price;
  private String uom;
  private String imgBarcode;
}
