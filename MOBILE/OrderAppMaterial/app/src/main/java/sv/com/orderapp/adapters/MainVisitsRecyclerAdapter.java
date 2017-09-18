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
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.util.FormatUtil;
import sv.com.orderapp.util.ImageUtil;

/**
 * Created by Mohan on 5/22/2016.
 */
public class MainVisitsRecyclerAdapter extends RecyclerView.Adapter<MainVisitsRecyclerAdapter.ViewHolder> {
    private RecyclerViewRowClickListener<MTransactor> recyclerViewRowClickListener;

    private final TypedValue mTypedValue = new TypedValue();

    private int mBackground;
    private List<MTransactor> transactors;


    public MainVisitsRecyclerAdapter(Context context, List<MTransactor> items, RecyclerViewRowClickListener<MTransactor> recyclerViewRowClickListener) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;

        this.transactors = items;
        this.recyclerViewRowClickListener = recyclerViewRowClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_visit, parent, false);

        view.setBackgroundResource(mBackground);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MTransactor transactor = transactors.get(position);

        holder.primaryText.setText(transactor.getName());
        holder.secondaryText.setText(transactor.getAddressLine3());
        ImageUtil.getClientAvatar(holder.avatar, transactor.getIndexNo());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewRowClickListener != null) {
                    recyclerViewRowClickListener.onClickRow(transactors.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactors.size();
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
