package sv.com.orderapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.listeners.OrderItemChangeListener;
import sv.com.orderapp.listeners.RecyclerViewRowClickListener;
import sv.com.orderapp.model.TOrderDetail;
import sv.com.orderapp.util.ImageUtil;

/**
 * Created by Mohan on 5/23/2016.
 */
public class OrderListRecyclerAdapter extends RecyclerView.Adapter<OrderListRecyclerAdapter.ViewHolder> {
    private int mBackground;
    private final TypedValue mTypedValue = new TypedValue();

    private List<TOrderDetail> orderDetailList;
    private RecyclerViewRowClickListener<TOrderDetail> recyclerViewRowClickListener;

    private OrderItemChangeListener orderItemChangeListener;

    public OrderListRecyclerAdapter(Context context, List<TOrderDetail> items, RecyclerViewRowClickListener<TOrderDetail> recyclerViewRowClickListener, OrderItemChangeListener orderItemChangeListener) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;


        this.orderDetailList = items;
        this.recyclerViewRowClickListener = recyclerViewRowClickListener;
        this.orderItemChangeListener = orderItemChangeListener;
    }

    @Override
    public OrderListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_order_product, parent, false);

        view.setBackgroundResource(mBackground);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.primaryText.setText(orderDetailList.get(position).getItem().getName());
        holder.secondaryText.setText(orderDetailList.get(position).getItem().getCode());
        holder.tertiaryText.setText("Rs. " + orderDetailList.get(position).getItem().getRetailPrice());
        ImageUtil.getClientAvatar(holder.avatar, orderDetailList.get(position).getItem().getIndexNo());
        holder.discountPercent.setText(String.valueOf(orderDetailList.get(position).getDiscountPercent()));
        holder.quantity.setText(String.valueOf(orderDetailList.get(position).getQuantity()));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewRowClickListener != null) {
                    recyclerViewRowClickListener.onClickRow(orderDetailList.get(position));
                }
            }
        });


//
//        holder.quantity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("ON CLICK", "dsjklfhkl");
//            }
//        });


//        holder.quantity.addTextChangedListener(textWatcher);
//        holder.discountPercent.addTextChangedListener(textWatcher);
    }

    @Override
    public int getItemCount() {
        return orderDetailList.size();
    }


    //view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;

        public final ImageView avatar;
        public final TextView primaryText;
        public final TextView secondaryText;
        public final TextView tertiaryText;
        public final EditText discountPercent;
        public final EditText quantity;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
            avatar = (ImageView) view.findViewById(R.id.avatar);
            primaryText = (TextView) view.findViewById(R.id.primary_text);
            secondaryText = (TextView) view.findViewById(R.id.secondary_text);
            tertiaryText = (TextView) view.findViewById(R.id.tertiary_text);

            discountPercent = (EditText) view.findViewById(R.id.discount_percent);
            quantity = (EditText) view.findViewById(R.id.quantity);


            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    try {
                        orderDetailList.get(getAdapterPosition()).setDiscountPercent(Double.valueOf(discountPercent.getText().toString()));
                        orderDetailList.get(getAdapterPosition()).setQuantity(Double.valueOf(quantity.getText().toString()));

                        //value changed
                        orderItemChangeListener.orderItemChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            quantity.addTextChangedListener(textWatcher);
            discountPercent.addTextChangedListener(textWatcher);

//            View.OnKeyListener onKeyListener = new View.OnKeyListener() {
//                @Override
//                public boolean onKey(View v, int keyCode, KeyEvent event) {
//                    try {
//                        Double.valueOf(discountPercent.getText().toString());
//                        Double.valueOf(quantity.getText().toString());
//
//                        //value changed
//                        orderItemChangeListener.orderItemChanged();
//
//                        Log.d("TEXT CHANGED", "TTJKBGKJHKLH");
//                        return true;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        return false;
//                    }
//                }
//            };

//            quantity.setOnKeyListener(onKeyListener);
//            discountPercent.setOnKeyListener(onKeyListener);
        }
    }
}
