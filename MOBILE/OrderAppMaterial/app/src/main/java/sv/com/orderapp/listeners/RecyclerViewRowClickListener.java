package sv.com.orderapp.listeners;

import sv.com.orderapp.model.MTransactor;

/**
 * Created by Mohan on 5/23/2016.
 */
public interface RecyclerViewRowClickListener<T> {

    public void onClickRow(T rowValue);

}
