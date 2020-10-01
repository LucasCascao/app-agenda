package br.com.alura.agenda.database.converter;

import android.arch.persistence.room.TypeConverter;

import br.com.alura.agenda.model.TipoTelefone;

public class ConversorTipoTelefone {

    @TypeConverter
    public String toString(TipoTelefone tipoTelefone){
        return tipoTelefone.name();
    }

    @TypeConverter
    public TipoTelefone toTipoTelefone(String valor){
        if(valor != null){
            return TipoTelefone.valueOf(valor);
        }
        return TipoTelefone.FIXO;
    }
}
