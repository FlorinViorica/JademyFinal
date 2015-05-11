package ro.jademy.app06listgrid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public static final int[] DRAWABLES = {
            R.drawable.american_horror_story,
            R.drawable.angel,
            R.drawable.arrow,
            R.drawable.battlestar_galactica,
            R.drawable.being_human,
            R.drawable.buffy_the_vampire_slayer};

    public static final String[] NAMES = {
            "american_horror_story",
            "angel",
            "arrow",
            "battlestar_galactica",
            "being_human",
            "buffy_the_vampire_slayer"};

    GridView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (GridView) findViewById(R.id.gridView);

        MyListAdapter adapter = new MyListAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, NAMES[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    class MyListAdapter extends BaseAdapter {

        // context to create inflator - set in constructor
        Context context;

        public MyListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return DRAWABLES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 1. Create inflater
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 2. Get rowView from inflater
            View rowView = inflater.inflate(R.layout.element, parent, false);

            // 3. get elements
            ImageView image = (ImageView) rowView.findViewById(R.id.imageView);
            TextView text = (TextView) rowView.findViewById(R.id.textView);

            // 4. set information
            image.setImageResource(DRAWABLES[position]);
            text.setText(NAMES[position]);

            return rowView;
        }
    }
}
