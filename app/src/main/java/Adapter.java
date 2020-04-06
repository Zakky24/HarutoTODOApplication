import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jp.ac.seiko.yamazaki.myapplicationtodo.R;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DataModel> insertDataList;

    public Adapter (List<DataModel> list) {
        this.insertDataList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_row, viewGroup, false);
        RecyclerView.ViewHolder viewHolder =  RecyclerView.ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        noteViewHolder.mImageView.setImageBitmap(insertDataList.get(i).getBitmap());
        noteViewHolder.mTextView.setText(insertDataList.get(i).getString());
    }

    @Override
    public int getItemCount () {
        return insertDataList.size();
    }
}
