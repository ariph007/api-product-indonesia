API Data Produk Indonesia
==========================
Integrasikan data produk Indonesia dengan mudah! Hanya menggunakan kata kunci dan barcode. Hemat ruang, praktis, dan gratis! 🚀 #APIProdukIndonesia

API Produk Indonesia adalah layanan gratis yang menyediakan data produk Indonesia dalam format JSON dengan total data 50.600. 

API ini memungkinkan pengembang untuk mengakses data produk tanpa harus menyimpannya secara lokal di server aplikasi itu sendiri. Dengan begitu, ruang di database aplikasi Anda tetap terjaga.

## ENDPOINTS

#### 1. Mencari Product berdasarkan barcode

```
GET {{baseurl}}/api/v1/products-barcode?barcode={barcode}&generateBarcode={boolean}
```

Contoh Response:

```
{
    "id": "ea3a0720-68e6-4313-a7e9-3844da694f1e",
    "barcode": "089686386219",
    "name": "BUMBU RACIK TUMIS",
    "price": 3500,
    "uom": "PCS",
    "imgBarcode": null
}
```
