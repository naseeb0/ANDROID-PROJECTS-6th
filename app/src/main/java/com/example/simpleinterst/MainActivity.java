package com.example.simpleinterst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAuthor, editTextISBN, editTextPublicationYear, editTextNumberOfPages, editTextDescription;
    private Spinner spinnerGenre;
    private Button buttonAddBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Find views by their IDs
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextISBN = findViewById(R.id.editTextISBN);
        spinnerGenre = findViewById(R.id.spinnerGenre);
        editTextPublicationYear = findViewById(R.id.editTextPublicationYear);
        editTextNumberOfPages = findViewById(R.id.editTextNumberOfPages);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonAddBook = findViewById(R.id.buttonAddBook);

        // Handle Publication Year EditText click to show DatePicker
        editTextPublicationYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        // Handle button click to add the book
        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBookToLibrary();
            }
        });
    }

    // Show DatePicker dialog when clicking on Publication Year EditText
    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedYear = String.valueOf(year);
                        editTextPublicationYear.setText(selectedYear);
                    }
                }, year, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    // Add book to the library (You can implement your database or storage logic here)
    private void addBookToLibrary() {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String isbn = editTextISBN.getText().toString();
        String genre = spinnerGenre.getSelectedItem().toString();
        String publicationYear = editTextPublicationYear.getText().toString();
        int numberOfPages = Integer.parseInt(editTextNumberOfPages.getText().toString());
        String description = editTextDescription.getText().toString();

        // Implement your logic here to add the book to the library's database or storage
        // For simplicity, we'll just show a Toast message indicating the book is added
        String message = "Book Added: " + title;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
