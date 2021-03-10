package com.devmeist3r.fitnesstracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  //    private View btnImc;
  private RecyclerView rvMain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rvMain = findViewById(R.id.rv_main);

    List<MainItem> mainItems = new ArrayList<>();
    mainItems.add(new MainItem(1, R.drawable.ic_baseline_wb_sunny_24, R.string.imc, Color.BLUE));
    mainItems.add(new MainItem(2, R.drawable.ic_baseline_wb_sunny_24, R.string.tmb, Color.YELLOW));

    // 1 -> definir o comportamento de exibiçao da recyclerView
    // mosaic
    // grid
    // linear (horizontal | vertical)
    rvMain.setLayoutManager(new LinearLayoutManager(this));
    MainAdapter adapter = new MainAdapter(mainItems);
    rvMain.setAdapter(adapter);


  }

  /**
   * é o meu adapter que pede um parametro que vai apontar parar uma celula
   * tableView
   **/
  private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<MainItem> mainItems;

    public MainAdapter(List<MainItem> mainItems) {
      this.mainItems = mainItems;
    }

    // Espera uma celula especifica
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
      MainItem mainItemCurrent = mainItems.get(position);
      holder.bind(mainItemCurrent);
    }

    // quantidade de items
    @Override
    public int getItemCount() {
      return mainItems.size();
    }
  }

  /**
   * é essa class que consegue ter acesso as referencias de componentes criados
   * Entenda como sendo a VIEW DA CELULA que esta dentro do RecyclerView
   * cellView
   **/
  private class MainViewHolder extends RecyclerView.ViewHolder {

    public MainViewHolder(@NonNull View itemView) {
      super(itemView);

    }

    public void bind(MainItem item) {
      TextView txtName = itemView.findViewById(R.id.item_txt_name);
      ImageView imgIcon = itemView.findViewById(R.id.item_img_icon);
      LinearLayout container = (LinearLayout) itemView;

      txtName.setText(item.getTextStringId());
      imgIcon.setImageResource(item.getDrawableId());
      container.setBackgroundColor(item.getColor());
    }
  }
}
