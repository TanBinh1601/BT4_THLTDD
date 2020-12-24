package tb.tm.bt4_btth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {

    Context context;
    private List<SanPham> sanPhamList;

    public SanPhamAdapter(Context context, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Image;
        TextView Title, Price, Price2;
        public ViewHolder(View itemview){
            super(itemview);
        }
    }

    @Override
    public int getCount() {
        return sanPhamList.size();
    }

    @Override
    public Object getItem(int i) {
        return sanPhamList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder = new ViewHolder(view);
            holder.Image = view.findViewById(R.id.item_img);
            holder.Title = view.findViewById(R.id.item_title);
            holder.Price = view.findViewById(R.id.item_price);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        try{
            int image = sanPhamList.get(i).getImage();
            holder.Image.setImageResource(image);
            holder.Title.setText(sanPhamList.get(i).getTitle());
            holder.Price.setText(sanPhamList.get(i).getPrice());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View BottomSheetView = null;
                    final ViewHolder holder1;
                    int Image1 = sanPhamList.get(i).getImage();
                    String Title = sanPhamList.get(i).getTitle();
                    String Price = sanPhamList.get(i).getPrice();

                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialog);
                    if (BottomSheetView == null){
                        BottomSheetView = LayoutInflater.from(context).inflate(R.layout.dailog_bottom, null);
                        holder1 = new ViewHolder(BottomSheetView);
                        holder1.Image = BottomSheetView.findViewById(R.id.dialog_img);
                        holder1.Title = BottomSheetView.findViewById(R.id.dialog_title);
                        holder1.Price = BottomSheetView.findViewById(R.id.dialog_price);
                        holder1.Price2 = BottomSheetView.findViewById(R.id.dialog_tongtien);

                        BottomSheetView.setTag(holder1);
                    }
                    else {
                        holder1 = (ViewHolder) BottomSheetView.getTag();
                    }
                    try{
                        holder1.Image.setImageResource(Image1);
                        holder1.Title.setText(Title);
                        holder1.Price.setText(Price);
                        holder1.Price2.setText(Price);
                    }
                    catch (Exception ex){
                    }
                    bottomSheetDialog.setContentView(BottomSheetView);
                    bottomSheetDialog.show();

                    final View finalBottomSheetView = BottomSheetView;
                    BottomSheetView.findViewById(R.id.remove_sl).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            TextView QuatyText = finalBottomSheetView.findViewById(R.id.dialog_solg);
                            int Quaty = Integer.parseInt((String) QuatyText.getText());
                            if (Quaty>1){
                                int newQuaty = Quaty - 1;
                                QuatyText.setText(String.valueOf(newQuaty));

                                TextView giaText = finalBottomSheetView.findViewById(R.id.dialog_tongtien);
                                int gia = Integer.parseInt(Price);
                                int newGia  = gia * newQuaty;
                                giaText.setText(String.valueOf(newGia));
                            }
                        }
                    });
                    BottomSheetView.findViewById(R.id.add_sl).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            TextView QuatyText = finalBottomSheetView.findViewById(R.id.dialog_solg);
                            int Quaty = Integer.parseInt((String) QuatyText.getText());
                                int newQuaty = Quaty + 1;
                                QuatyText.setText(String.valueOf(newQuaty));

                                TextView giaText = finalBottomSheetView.findViewById(R.id.dialog_tongtien);
                                int gia = Integer.parseInt(Price);
                                int newGia  = gia * newQuaty;
                                giaText.setText(String.valueOf(newGia));
                        }
                    });
                    BottomSheetView.findViewById(R.id.dialog_close).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            bottomSheetDialog.hide();
                        }
                    });
                }
            });
        }
        catch (Exception ex){
        }
        return view;
    }
}
