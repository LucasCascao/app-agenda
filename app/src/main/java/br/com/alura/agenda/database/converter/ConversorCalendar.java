package br.com.alura.agenda.database.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;

/**
 * Classe responsavel por converter objetos da classe Calendar em long para serem porsistidos pelo Room no banco de dados
 * Pois, o SQLite não permite a inserção diretamente de datas no banco de dados.
 */

public class ConversorCalendar {

    @TypeConverter
    public Long toLong(Calendar calendar){
        if(calendar != null){
            calendar.getTimeInMillis();
        }
        return null;
    }

    @TypeConverter
    public Calendar toCalendar(Long timeInMillis){
        Calendar momentoAtual = Calendar.getInstance();
        if(timeInMillis != null){
            momentoAtual.setTimeInMillis(timeInMillis);
        }
        return momentoAtual;
    }
}
