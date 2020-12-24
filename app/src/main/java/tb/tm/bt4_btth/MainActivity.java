package tb.tm.bt4_btth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SanPhamAdapter adapter;
    ArrayList<SanPham> arr_sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        arr_sp = new ArrayList<SanPham>();
        arr_sp.add(new SanPham(R.drawable.sp1_1, "Sản phẩm 1", "55000"));
        arr_sp.add(new SanPham(R.drawable.sp1_2, "Sản phẩm 2", "25000"));
        arr_sp.add(new SanPham(R.drawable.sp1_3, "Sản phẩm 3", "13000"));
        arr_sp.add(new SanPham(R.drawable.sp1_4, "Sản phẩm 4", "32000"));
        arr_sp.add(new SanPham(R.drawable.sp1_5, "Sản phẩm 5", "15000"));
        adapter = new SanPhamAdapter(this, arr_sp);
        listView.setAdapter(adapter);
    }
}