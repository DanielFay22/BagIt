package com.nextinnovation.pt.barcodescanner.database;

import android.util.ArrayMap;


public class ItemInfo {
    private ArrayMap<String, String> items = new ArrayMap<>();

    public ItemInfo()  {
        items.put("04963406", "12oz Coke");

    }

    public String getItem(String barcodeNo) {
//        if (this.items.containsKey(barcodeNo))  {
        return this.items.get(barcodeNo);
//        }
//        else    {
//            return barcodeNo;
//        }
    }
}
