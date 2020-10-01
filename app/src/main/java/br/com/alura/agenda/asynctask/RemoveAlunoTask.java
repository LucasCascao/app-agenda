package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;

import br.com.alura.agenda.database.dao.room.AlunoDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.ui.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask<Void, Void, Void> {
    private final ListaAlunosAdapter adapter;
    private final AlunoDAO dao;
    private final Aluno aluno;

    public RemoveAlunoTask(ListaAlunosAdapter adapter, AlunoDAO dao, Aluno aluno) {
        this.adapter = adapter;
        this.dao = dao;
        this.aluno = aluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remove(aluno);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        adapter.remove(aluno);
    }
}
