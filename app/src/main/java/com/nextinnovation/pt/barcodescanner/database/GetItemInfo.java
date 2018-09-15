package com.nextinnovation.pt.barcodescanner.database;

import android.util.ArrayMap;

import java.util.NoSuchElementException;

public class GetItemInfo {
    private ArrayMap<String, String> items;

    public void onCreate()  {
        items.put("04963406", "12oz Coke");

    }

    public String getItem(String barcodeNo) {
        if (this.items.containsKey(barcodeNo))  {
            return this.items.get(barcodeNo);
        }
        else    {
            return barcodeNo;
        }
    }
}
