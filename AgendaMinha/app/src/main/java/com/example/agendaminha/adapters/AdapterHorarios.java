package com.example.agendaminha.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendaminha.R;
import com.example.agendaminha.model.Agendamento;
import com.example.agendaminha.model.Horario;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class AdapterHorarios extends RecyclerView.Adapter<AdapterHorarios.MyViewHolder> {

    private List<Horario> listaHorarios;
    private Context context;
    private RecyclerView recyclerView;
    private TextView textViewTitulo;
    private Calendar calendar;

    private final DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista_horarios, parent, false);

        return new MyViewHolder(itemLista);
    }

    public AdapterHorarios(List<Horario> lista, RecyclerView recyclerView, TextView textView, Calendar calendar) {
        this.listaHorarios = lista;
        this.recyclerView = recyclerView;
        this.textViewTitulo = textView;
        this.calendar = calendar;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Horario horarios = listaHorarios.get(position);
        holder.hora.setText(horarios.getHora() + ":" + horarios.getMinuto() + " horas");

        if (horarios.isDisponibilidade()) {
            holder.disponibilidade.setText("Disponibilidade: Disponivel");
            holder.button.setEnabled(true);
            holder.button.setText("Agendar Consulta");
            holder.button.setOnClickListener(v -> {
                holder.abrirToast("Deseja confirmar o agendamento para as " + horarios.getHora() + ":" + horarios.getMinuto() + " horas",position);
            });
        }
        if (!horarios.isDisponibilidade()) {
            holder.disponibilidade.setText("Disponibilidade: Indisponivel");
            holder.button.setEnabled(false);
            holder.button.setText("Horário Indisponivel");
            holder.button.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return listaHorarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView disponibilidade, hora;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hora = itemView.findViewById(R.id.textViewHora);
            disponibilidade = itemView.findViewById(R.id.textViewDisponibilidade);
            button = itemView.findViewById(R.id.buttonAgendaConsulta);
            context = itemView.getContext();
        }

        public void abrirToast(String mensagem,int position) {
//        Instancia alert dialog
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);

//        Configurar titulo e mensagem
            dialog.setTitle("Agendamento");
            dialog.setMessage(mensagem);

//        Configurar cancelamento
            dialog.setCancelable(false);

//                Configurar icone
            dialog.setIcon(R.drawable.logo1);


//        Configurar ações para sim e nao
            dialog.setPositiveButton("Sim", (dialogInterface, i) -> {
                Horario h = listaHorarios.get(position);
                h.setDisponibilidade(false);
                Agendamento agendamento = new Agendamento(h,"555", String.valueOf(UUID.randomUUID()));

                final SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
                final SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
                final SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
                String sDateAno = sdfAno.format(calendar.getTime());
                String sDateMes = sdfMes.format(calendar.getTime());
                String sDateDia = sdfDia.format(calendar.getTime());
                DatabaseReference criado = referencia.child("agendamentos");
                criado.child(sDateAno).child(sDateMes).child(sDateDia).child(h.getIdHora()).setValue(agendamento);


                Toast.makeText(context, "Agendamento efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                recyclerView.setVisibility(View.INVISIBLE);
                textViewTitulo.setText("Para agendar uma consulta selecione uma data");
            });

            dialog.setNegativeButton("Não", (dialogInterface, i) -> {

            });

            dialog.create();
            dialog.show();

        }
    }
}
