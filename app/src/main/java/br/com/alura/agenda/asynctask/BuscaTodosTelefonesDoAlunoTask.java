package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;

import java.util.List;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Telefone;

public class BuscaTodosTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {

    private final TelefoneDAO dao;
    private final int alunoId;
    private final TelefonesDoAlunoEncontradosListener telefonesDoAlunoEncontradosListener;

    public BuscaTodosTelefonesDoAlunoTask(TelefoneDAO dao, int alunoId, TelefonesDoAlunoEncontradosListener telefonesDoAlunoEncontradosListener) {
        this.dao = dao;
        this.alunoId = alunoId;
        this.telefonesDoAlunoEncontradosListener = telefonesDoAlunoEncontradosListener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {
        return dao.buscaTodosTelefonesDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        telefonesDoAlunoEncontradosListener.telefonesDoAlunoEncontrados(telefones);
    }

    public interface TelefonesDoAlunoEncontradosListener {
        void telefonesDoAlunoEncontrados(List<Telefone> telefones);
    }
}
