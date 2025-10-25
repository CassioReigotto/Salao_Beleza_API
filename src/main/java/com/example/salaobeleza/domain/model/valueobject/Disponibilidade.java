package com.example.salaobeleza.domain.model.valueobject;


import java.time.DayOfWeek;
import java.time.LocalTime;

public class Disponibilidade {

    private final DayOfWeek diaSemana;
    private final LocalTime horarioInicio;
    private final LocalTime horarioFim;

    public Disponibilidade(DayOfWeek diaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
        if (diaSemana == null)
            throw new IllegalArgumentException("O dia da semana é obrigatório.");
        if (horarioInicio == null || horarioFim == null)
            throw new IllegalArgumentException("Horário de início e fim são obrigatórios.");
        if (horarioFim.isBefore(horarioInicio))
            throw new IllegalArgumentException("O horário de fim não pode ser antes do início.");

        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }


}

