package com.nextinnovation.pt.barcodescanner.model;

import java.io.Serializable;


/**
 * Created by PT on 2/9/2017.
 */

public class Product implements Serializable {
    private String productNo ;
    private String productBarcodeNo ;
    private  String scanTime;
    private String scanDate ;
    private String productName ;
    private float productCost;

    public String getProductBarcodeNo() {
        return productBarcodeNo;
    }

    public void setProductBarcodeNo(String productBarcodeNo) {
        this.productBarcodeNo = productBarcodeNo;
    }

    public void setProductName(String productName)  {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getScanDate() {
        return scanDate;
    }

    public void setScanDate(String scanDate) {
        this.scanDate = scanDate;
    }

    public void setProductCost(float cost)  {
        productCost = cost;
    }

    public float getProductCost()   {
        return productCost;
    }

    public Product(String productBarcodeNo, String scanTime, String scanDate,
                   String itemName, float cost) {
        this.productBarcodeNo = productBarcodeNo;
        this.scanTime = scanTime;
        this.scanDate = scanDate;
        this.productName = itemName;
        this.productCost = cost;
    }

    public Product(){

    }







}
