package plc.jidnation.gridview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridAdapter gridAdapter;
    ArrayList<ItemModel> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        items.add(new ItemModel(R.drawable.image1, "Laptop", "High-performance laptops for professionals"));
        items.add(new ItemModel(R.drawable.image2, "Smartphone", "Latest 5G smartphones with powerful features"));
        items.add(new ItemModel(R.drawable.image3, "Headphones", "Noise-canceling headphones for music lovers"));
        items.add(new ItemModel(R.drawable.image4, "Smartwatch", "Track your fitness and stay connected"));
        items.add(new ItemModel(R.drawable.image2, "Camera", "Capture memories with DSLR and mirrorless cameras"));
        items.add(new ItemModel(R.drawable.image2, "Speaker", "Portable Bluetooth speakers with premium sound"));
        items.add(new ItemModel(R.drawable.image4, "Tablet", "Lightweight tablets for work and play"));
        items.add(new ItemModel(R.drawable.image1, "Monitor", "High-resolution monitors for gaming and work"));
        items.add(new ItemModel(R.drawable.image2, "Keyboard", "Ergonomic keyboards for comfortable typing"));
        items.add(new ItemModel(R.drawable.image3, "Mouse", "Precision wireless and gaming mice"));
        items.add(new ItemModel(R.drawable.image2, "Drone", "Capture stunning aerial views with advanced drones"));
        items.add(new ItemModel(R.drawable.image3, "Gaming Console", "Next-gen gaming consoles for immersive experiences"));
        items.add(new ItemModel(R.drawable.image4, "Power Bank", "Reliable power banks for on-the-go charging"));
        items.add(new ItemModel(R.drawable.image2, "Television", "Smart TVs with 4K and HDR support"));
        items.add(new ItemModel(R.drawable.image1, "Printer", "All-in-one printers for home and office use"));
        items.add(new ItemModel(R.drawable.image4, "Router", "High-speed Wi-Fi routers for seamless connectivity"));
        items.add(new ItemModel(R.drawable.image4, "VR Headset", "Experience virtual reality like never before"));
        items.add(new ItemModel(R.drawable.image2, "External HDD", "Portable hard drives for secure data storage"));
        items.add(new ItemModel(R.drawable.image1, "Smart Home Device", "Smart home gadgets for automation"));
        items.add(new ItemModel(R.drawable.image3, "Camera Lens", "High-quality lenses for professional photography"));

        gridAdapter = new GridAdapter(items);
        GridView gridViewBox = findViewById(R.id.gridMainBox);
        gridViewBox.setAdapter(gridAdapter);
    }


    private  class GridAdapter extends BaseAdapter {
        public List<ItemModel> itemList;

        public GridAdapter(List<ItemModel> itemList) {
            this.itemList = itemList;
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater myInflater = getLayoutInflater();
            @SuppressLint({"ViewHolder", "InflateParams"}) View gridView = myInflater.inflate(R.layout.grid_item_box, null);

            ItemModel item = itemList.get(position);
            ImageView imageView =  gridView.findViewById(R.id.gridItemImage);
            TextView title = gridView.findViewById(R.id.gridItemTitle);
            TextView subTitle = gridView.findViewById(R.id.gridItemSub);

            imageView.setImageResource(item.imgId);
            title.setText(item.title);
            subTitle.setText(item.subTitle);

            return gridView;
        }
    }
}