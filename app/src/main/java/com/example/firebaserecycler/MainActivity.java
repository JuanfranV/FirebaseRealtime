package com.example.firebaserecycler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebaserecycler.adapter.NotaAdapter;
import com.example.firebaserecycler.models.NotaModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;
import java.util.*;


public class MainActivity extends AppCompatActivity {


    private RecyclerView recycler;
    private NotaAdapter adapter;
    private List<NotaModel> lista;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            recycler = findViewById(R.id.recyclerNotas);
            recycler.setLayoutManager(new LinearLayoutManager(this));
            lista = new ArrayList<>();
            adapter = new NotaAdapter(lista);
            recycler.setAdapter(adapter);

            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            ref = FirebaseDatabase.getInstance().getReference("notas").child(uid);

            findViewById(R.id.btnNuevaNota).setOnClickListener(v ->
                    startActivity(new Intent(this, NuevaNotaActivity.class))
            );

            cargarNotas();

        });

    }

    private void cargarNotas() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lista.clear();
                for (DataSnapshot data : snapshot.getChildren()) {
                    NotaModel n = data.getValue(NotaModel.class);
                    lista.add(n);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}