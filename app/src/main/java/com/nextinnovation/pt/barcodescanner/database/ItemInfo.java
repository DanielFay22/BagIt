package com.nextinnovation.pt.barcodescanner.database;

import android.util.ArrayMap;
import android.util.Pair;

import java.util.HashMap;
import java.util.Map;


public class ItemInfo {

    private Map<String, Pair<String, Float>> items = new HashMap<>();

    public ItemInfo()  {

        items.put("04963406", Pair.create("12oz Coke", 1.0f));
        items.put("044000020170", Pair.create("Mini Oreos", 1.5f));

    }

    public String getName(String barcodeNo) {
        if (this.items.containsKey(barcodeNo))  {
            return this.items.get(barcodeNo).first;
        }
        else    {
            return barcodeNo;
        }
    }

    public float getCost(String barcodeNo)  {
        return this.items.get(barcodeNo).second;
    }
}



