package io.agora.tutorials1v1vcall;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by admin on 2019/4/11.
 */

public class HomeListAdapter extends BaseQuickAdapter<Item, BaseViewHolder> {


    public HomeListAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Item item) {
        helper.setText(R.id.name,  item.getName()+"----"+item.getTime());
    }

}
