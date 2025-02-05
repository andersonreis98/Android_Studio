package com.example.agendaminha;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendaminha.adapters.AdapterHorarios;
import com.example.agendaminha.model.Horario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView textViewDiaMesAno;
    private RecyclerView recyclerView;

    List<Horario> listaHorarioss = new ArrayList<>();

    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        textViewDiaMesAno = findViewById(R.id.textViewDias);
        recyclerView = findViewById(R.id.recyclerHorarios);

        Date min = new Date();
        calendarView.setMinDate(min.getTime());
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {

            final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);
            String sDate = sdf.format(calendar.getTime());
            textViewDiaMesAno.setText("Horarios disponiveis no dia \"" + sDate + "\" ");
            Toast.makeText(getApplicationContext(), "Selecionado dia " + sDate, Toast.LENGTH_SHORT).show();
            //        Listagem de Horarioss
            criarHorarioss(calendar);
        });
    }

    public void criarHorarioss(Calendar calendar) {

        //        Configura recyclerview

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        DatabaseReference pesquisa = referencia.child("horarios");

        pesquisa.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaHorarioss.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Horario h = postSnapshot.getValue(Horario.class);
                    h.setIdHora(postSnapshot.getKey());

                    final SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
                    final SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
                    final SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
                    String sDateAno = sdfAno.format(calendar.getTime());
                    String sDateMes = sdfMes.format(calendar.getTime());
                    String sDateDia = sdfDia.format(calendar.getTime());
                    DatabaseReference criado = referencia.child("agendamentos");
                    DatabaseReference ocupado = criado.child(sDateAno).child(sDateMes).child(sDateDia).child(h.getIdHora());
                    ocupado.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot2) {
                            if (snapshot2.exists()) {
                                h.setDisponibilidade(false);
                                //Configura adapter
                                AdapterHorarios adapter = new AdapterHorarios(listaHorarioss, recyclerView, textViewDiaMesAno, calendar);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                    listaHorarioss.add(h);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}