package com.example.firebaserecycler;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firebaserecycler.models.NotaModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevaNotaActivity extends AppCompatActivity {

    private EditText inputTitulo;
    private EditText inputContenido;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueva_nota);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        inputTitulo = findViewById(R.id.inputTitulo);
        inputContenido = findViewById(R.id.inputContenido);

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref = FirebaseDatabase.getInstance().getReference("notas").child(uid);

        findViewById(R.id.btnGuardar).setOnClickListener(view -> guardarNota());
    }

    private void guardarNota() {
        String id = ref.push().getKey();
        String titulo = inputTitulo.getText().toString().trim();
        String contenido = inputContenido.getText().toString().trim();

        if (titulo.isEmpty()) {
            Toast.makeText(this, "Agrega un título", Toast.LENGTH_SHORT).show();
            return;
        }


        NotaModel nota = new NotaModel(id, titulo, contenido, System.currentTimeMillis());
        ref.child(id).setValue(nota).addOnSuccessListener(aVoid -> {
            Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
            finish();

        });
    }
}