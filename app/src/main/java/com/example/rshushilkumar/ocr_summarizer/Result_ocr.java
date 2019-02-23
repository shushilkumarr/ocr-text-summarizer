package com.example.rshushilkumar.ocr_summarizer;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Result_ocr extends AppCompatActivity {

    String text;
    TextView tview,title;
    Button sumButton;
    String sum_text;
    EditText nol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_ocr);
        Intent i=getIntent();
        text=i.getStringExtra("result");
        tview=findViewById(R.id.capture);
        tview.setText(text);
        title=findViewById(R.id.title);
        nol=findViewById(R.id.nol);
        sumButton=findViewById(R.id.sum_btn);
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Summarizer summarizer=new Summarizer();
                sum_text=summarizer.Summarize(text,Integer.parseInt( nol.getText().toString()));
                tview.setText(sum_text);
                title.setText("Summary:");
            }
        });
    }
}
