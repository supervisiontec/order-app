package sv.com.orderapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.listeners.RecyclerViewRowClickListener;
import sv.com.orderapp.model.MItem;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.util.FormatUtil;
import sv.com.orderapp.util.ImageUtil;

/**
 * Created by Mohan on 5/22/2016.
 */
public class MainProductsRecyclerAdapter extends RecyclerView.Adapter<MainProductsRecyclerAdapter.ViewHolder> {
    private final TypedValue mTypedValue = new TypedValue();

    private RecyclerViewRowClickListener<MItem> recyclerViewRowClickListener;

    private int mBackground;
    private List<MItem> items;


    public MainProductsRecyclerAdapter(Context context, List<MItem> items, RecyclerViewRowClickListener<MItem> recyclerViewRowClickListener) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;

        this.recyclerViewRowClickListener = recyclerViewRowClickListener;

        this.items = items;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product, parent, false);

        view.setBackgroundResource(mBackground);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final MItem item = items.get(position);

        holder.primaryText.setText(item.getName());
        holder.secondaryText.setText("Rs. " + FormatUtil.formatDouble(item.getRetailPrice()));
        ImageUtil.getClientAvatar(holder.avatar, item.getIndexNo());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewRowClickListener != null) {
                    recyclerViewRowClickListener.onClickRow(items.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    //view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;

        public final ImageView avatar;
        public final TextView primaryText;
        public final TextView secondaryText;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
            avatar = (ImageView) view.findViewById(R.id.avatar);
            primaryText = (TextView) view.findViewById(R.id.primary_text);
            secondaryText = (TextView) view.findViewById(R.id.secondary_text);
        }
    }
}
