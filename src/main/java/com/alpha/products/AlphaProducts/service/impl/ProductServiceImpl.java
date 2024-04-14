package com.alpha.products.AlphaProducts.service.impl;

import com.alpha.products.AlphaProducts.entity.Product;
import com.alpha.products.AlphaProducts.model.response.GetProduct;
import com.alpha.products.AlphaProducts.repository.ProductRepository;
import com.alpha.products.AlphaProducts.service.ProductService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import javax.imageio.ImageIO;
import lombok.RequiredArgsConstructor;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repository;

  @Override
  public List<GetProduct> getProductsByName(String name) {
    List<GetProduct> responses = new ArrayList<>();
    repository.findAllByNameIsContainingIgnoreCase(name).forEach(product -> {
      responses.add(productMapping(product, false));
    });
    return responses;
  }

  @Override
  public GetProduct getProductByBarcode(String barcode, Boolean generateBarcode) {
    Optional<Product> result = repository.findByBarcode(barcode);
    return result.map(product -> productMapping(product, generateBarcode)).orElse(null);
  }

  private GetProduct productMapping(Product product, Boolean generateBarcode) {
    GetProduct response = new GetProduct();
    response.setId(product.getId());
    response.setName(product.getName());
    response.setUom(product.getUom());
    response.setPrice(product.getPrice());
    response.setBarcode(product.getBarcode());

    if (generateBarcode) {

      try {
        EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas =
            new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, product.getBarcode());

        BufferedImage img = canvas.getBufferedImage();
        String base64 = encodeToString(img, "png");
        response.setImgBarcode(base64);
      } catch (Exception e) {
        System.out.println(e);
      }
    }

    return response;
  }

  public String encodeToString(BufferedImage image, String type) {
    String imageString = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    try {
      ImageIO.write(image, type, bos);
      byte[] imageBytes = bos.toByteArray();

      Base64.Encoder encoder = Base64.getEncoder();
      imageString = encoder.encodeToString(imageBytes);

      bos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return imageString;
  }

}
