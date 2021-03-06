package tk.zielony.carbonsamples.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

import carbon.component.AvatarTextItem;
import carbon.component.AvatarTextRow;
import carbon.component.DividerItem;
import carbon.component.DividerRow;
import carbon.recycler.RowListAdapter;
import carbon.widget.RecyclerView;
import tk.zielony.carbonsamples.R;

/**
 * Created by Marcin on 2017-02-02.
 */

public class AvatarTextListItemActivity extends AppCompatActivity {
    public static class SampleItem implements AvatarTextItem {

        @Override
        public Drawable getAvatar(Context context) {
            return context.getResources().getDrawable(R.drawable.iceland);
        }

        @Override
        public String getText() {
            return "Sample text";
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcomponent);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        RowListAdapter adapter = new RowListAdapter<>(SampleItem.class, AvatarTextRow.FACTORY);
        adapter.addFactory(DividerItem.class, DividerRow.FACTORY);
        recycler.setAdapter(adapter);
        adapter.setItems(Arrays.asList(new SampleItem(), new SampleItem(), new DividerItem(), new SampleItem(), new SampleItem()));
    }
}
