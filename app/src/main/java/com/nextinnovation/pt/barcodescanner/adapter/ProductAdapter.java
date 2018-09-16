package com.nextinnovation.pt.barcodescanner.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nextinnovation.pt.barcodescanner.R;
import com.nextinnovation.pt.barcodescanner.database.DatabaseHelper;
import com.nextinnovation.pt.barcodescanner.model.Product;

import java.util.ArrayList;

/**
 * Created by PT on 2/9/2017.
 */

@SuppressWarnings("unchecked")
public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Object> productArrayList;
    private static final int PRODUCT_ITEM_VIEW_TYPE = 0 ;

    public ProductAdapter(Context context, ArrayList<Object> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_barcode,parent,
                false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

       ProductViewHolder productViewHolder = (ProductViewHolder)holder;
       setProductView(productViewHolder , position);

    }

    private void setProductView(final ProductViewHolder holder, final  int position) {
//        Log.d("pos", Integer.toString(position));
        final Pair<Product, Integer> product = (Pair<Product, Integer>)productArrayList.get(position);
        holder.txtScanResult.setText(product.first.getProductBarcodeNo());

        holder.txtScanNo.setText(product.first.getProductName());

        holder.quantity.setText(String.format(holder.quantity.getTextLocale(),
                "%d", product.second));

        if(position%2==0){
            holder.layoutRightButtons.setBackgroundColor(context.getResources().getColor(R.color.card_right_blue));
        }
        if(position%3==0){
            holder.layoutRightButtons.setBackgroundColor(context.getResources().getColor(R.color.card_right_purple));
        }

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(product);
            }
        });

        holder.decreaseQ.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View view)  {
                Pair<Product, Integer> product = (Pair<Product, Integer>)productArrayList.get(position);
                if (product.second > 0) {
                    product = Pair.create(product.first,
                            product.second - 1);

                    holder.quantity.setText(String.format(holder.quantity.getTextLocale(),
                            "%d", product.second));

                    DatabaseHelper db = new DatabaseHelper(context);
                    db.removeOne(product.first);

                    productArrayList.set(position, product);
                }

            }
        });

        holder.increaseQ.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View view)  {
                Pair<Product, Integer> product = (Pair<Product, Integer>)productArrayList.get(position);

                product = Pair.create(product.first,
                        product.second + 1);

                holder.quantity.setText(String.format(holder.quantity.getTextLocale(),
                        "%d", product.second));

                DatabaseHelper db = new DatabaseHelper(context);
                db.addProduct(product.first);

                productArrayList.set(position, product);
            }
        });

    }

    private void removeItem(Pair<Product, Integer> product)    {
        productArrayList.remove(product);

        DatabaseHelper db = new DatabaseHelper(context);

        db.removeProduct(product.first);

    }

    private void openShareDialog(String result) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        String appLink = "https://play.google.com/store/apps/details?id="+context.getPackageName();
        sharingIntent.setType("text/plain");
        String shareBodyText = "Scan Result: "+ result+"."+
                "\nCheck Out The Cool & Fastest Barcode Reader App \n " +
                "Link: "+appLink +" \n" +
                " #Barcode #Android";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Barcode Reader Android App");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
        context.startActivity(Intent.createChooser(sharingIntent, "Share"));
    }

    @Override
    public int getItemViewType(int position) {
        return  PRODUCT_ITEM_VIEW_TYPE;

    }



    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layoutRightButtons ;
        private TextView txtScanResult , txtScanNo ;
        private Button btnShare ;
        private TextView quantity ;
        private Button increaseQ, decreaseQ;

        public ProductViewHolder(View itemView) {
            super(itemView);
        layoutRightButtons = itemView.findViewById(R.id.layout_right_buttons);

        txtScanNo = itemView.findViewById(R.id.txt_scan_no);
        txtScanResult = itemView.findViewById(R.id.txt_scan_result);
        btnShare = itemView.findViewById(R.id.btn_share);
        quantity = itemView.findViewById(R.id.quantity);
        increaseQ = itemView.findViewById(R.id.increaseQ);
        decreaseQ = itemView.findViewById(R.id.decreaseQ);

        }
    }


}
