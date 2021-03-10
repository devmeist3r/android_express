package com.devmeist3r.fitnesstracker;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImcActivity extends AppCompatActivity {

  private EditText editHeight;
  private EditText editWeight;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_imc);

    editHeight = findViewById(R.id.edit_imc_height);
    editWeight = findViewById(R.id.edit_imc_weight);

    Button btnSend = findViewById(R.id.btn_imc_send);

    btnSend.setOnClickListener(v -> {
      Log.d("TESTE", "Ola mundo");
      if (!validate()) {
        Toast.makeText(ImcActivity.this, R.string.fields_message, Toast.LENGTH_SHORT).show();
      }

      String sHeight = editHeight.getText().toString();
      String sWeight = editWeight.getText().toString();

      Log.d("TESTE", "height: " + sHeight);
      Log.d("TESTE", "Weight: " + sWeight);

      int height = Integer.parseInt(sHeight);
      int weight = Integer.parseInt(sWeight);

      double result = calculateImc(height, weight);

      Log.d("TESTE", "resultado: " + result);

      int imcResponseId = imcResponse(result);

      AlertDialog dialog = new AlertDialog.Builder(ImcActivity.this)
          .setTitle(getString(R.string.imc_response, result))
          .setMessage(imcResponseId)
          .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
            //
          })
          .create();

      dialog.show();

      InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(editWeight.getWindowToken(), 0);
      imm.hideSoftInputFromWindow(editHeight.getWindowToken(), 0);
    });
  }

  /**
   * @method validar campos
   **/
  private boolean validate() {
    return (!editHeight.getText().toString().startsWith("0")
        && !editWeight.getText().toString().startsWith("0")
        && !editHeight.getText().toString().isEmpty()
        && !editWeight.getText().toString().isEmpty()
    );
  }

  /**
   * @method calcula IMC
   */
  private double calculateImc(int height, int weight) {
    return weight / (((double) height / 100) * ((double) height / 100));
  }

  /**
   * @method devolve status sobre o imc
   */
  @StringRes
  private int imcResponse(double imc) {
    if (imc < 15)
      return R.string.imc_severely_low_weight;
    if (imc < 16)
      return R.string.imc_very_low_weight;
    if (imc < 18.5)
      return R.string.imc_low_weight;
    if (imc < 25)
      return R.string.normal;
    if (imc < 30)
      return R.string.imc_high_weight;
    if (imc < 35)
      return R.string.imc_so_high_weight;
    if (imc < 40)
      return R.string.imc_severely_high_weight;
    else
      return R.string.imc_extreme_weight;

  }

  /**
   * @method esconder teclado clicando fora do campo
   **/
  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    if (getCurrentFocus() != null) {
      InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }
    return super.dispatchTouchEvent(ev);
  }
}