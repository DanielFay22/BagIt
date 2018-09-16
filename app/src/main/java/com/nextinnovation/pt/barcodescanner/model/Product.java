package com.nextinnovation.pt.barcodescanner.model;

import com.nextinnovation.pt.barcodescanner.database.ItemInfo;

import java.io.Serializable;


/**
 *
 */

public class Product implements Serializable {
    private String productNo ;
    private String productBarcodeNo ;
    private  String scanTime;
    private String scanDate ;
    private String productName ;
    private float productCost;
    private ItemInfo itemInfo = new ItemInfo();

    public String getProductBarcodeNo() {
        return productBarcodeNo;
    }

    public void setProductBarcodeNo(String productBarcodeNo) {
        this.productBarcodeNo = productBarcodeNo;

        if (this.productBarcodeNo != null) {
            this.productCost = itemInfo.getCost(this.productBarcodeNo);
        }
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
        this.productCost = cost;
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

        if (this.productCost == 0.0)  {
            this.productCost = itemInfo.getCost(this.productBarcodeNo);
        }
    }

    public Product(){

    }







}
