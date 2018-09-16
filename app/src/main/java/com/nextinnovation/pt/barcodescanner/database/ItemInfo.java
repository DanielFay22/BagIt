package com.nextinnovation.pt.barcodescanner.database;

import android.util.Pair;

import java.util.HashMap;
import java.util.Map;


public class ItemInfo {

    private Map<String, Pair<String, Double>> items = new HashMap<>();

    public ItemInfo()  {

        items.put("04963406", Pair.create("COKE (12oz)", 1.0));
        items.put("044000020170", Pair.create("Mini Oreos", 1.5));
        items.put("022592007014", Pair.create("Bottle Water (16.9oz)", 1.0));
        items.put("052000122480", Pair.create("Orange Gatorade (12oz)", 1.8));
        items.put("9781785782343", Pair.create("BIG DATA - Brian Clegg", 12.8));
        items.put("9780525536222", Pair.create("Measure What Matters", 15.0));
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
        return this.items.get(barcodeNo).second.floatValue();
    }
}



