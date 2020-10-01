package br.com.alura.agenda.asynctask;

import java.util.List;

import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.database.dao.room.AlunoDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

import static br.com.alura.agenda.model.TipoTelefone.FIXO;

public class EditaAlunoTask extends BaseAlunoComTelefoneTask {

    private final Aluno aluno;
    private final AlunoDAO alunoDAO;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final TelefoneDAO telefoneDAO;
    private final List<Telefone> telefonesDoAluno;


    public EditaAlunoTask(Aluno aluno, AlunoDAO alunoDAO, Telefone telefoneFixo, Telefone telefoneCelular, TelefoneDAO telefoneDAO, List<Telefone> telefonesDoAluno, FinalizadaListener finalizadaListener) {
        super(finalizadaListener);
        this.aluno = aluno;
        this.alunoDAO = alunoDAO;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefoneDAO = telefoneDAO;
        this.telefonesDoAluno = telefonesDoAluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        alunoDAO.edita(aluno);
        vinculaAlunoComTelefone(aluno.getId(), telefoneFixo, telefoneCelular);
        atualizaIdsDosTelefones(telefoneFixo, telefoneCelular);
        telefoneDAO.atualiza(telefoneFixo, telefoneCelular);
        return null;
    }

    private void atualizaIdsDosTelefones(Telefone telefoneFixo, Telefone telefoneCelular) {
        for (Telefone telefone : telefonesDoAluno) {
            if(telefone.getTipo().equals(FIXO)){
                telefoneFixo.setId(telefone.getId());
            } else {
                telefoneCelular.setId(telefone.getId());
            }
        }
    }
}
