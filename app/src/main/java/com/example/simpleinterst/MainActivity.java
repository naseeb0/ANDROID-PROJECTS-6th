package com.example.simpleinterst;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] names = {"Naseeb", "Kalpana", "Rahul", "Emma", "David", "Sophia", "Daniel", "Olivia"};
    private int[] ages = {25, 30, 28, 22, 35, 27, 29, 31};
    private String[] genders = {"Male", "Female", "Male", "Female", "Male", "Female", "Male", "Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        
        TableRow headerRow = new TableRow(this);
        headerRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        
        String[] headers = {"Name", "Age", "Gender"};
        for (String header : headers) {
            TextView headerTextView = createTextView(header);
            headerRow.addView(headerTextView);
        }

        
        tableLayout.addView(headerRow);

        
        for (int i = 0; i < names.length; i++) {
            TableRow dataRow = new TableRow(this);
            dataRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

            
            TextView nameTextView = createTextView(names[i]);
            dataRow.addView(nameTextView);

            
            TextView ageTextView = createTextView(String.valueOf(ages[i]));
            dataRow.addView(ageTextView);

            
            TextView genderTextView = createTextView(genders[i]);
            dataRow.addView(genderTextView);

            
            tableLayout.addView(dataRow);
        }
    }

    
    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
