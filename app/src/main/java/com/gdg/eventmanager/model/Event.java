package com.gdg.eventmanager.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.Date;
import java.util.List;

@JsonObject
public class Event {

    public final class Constants {
        static final String ID = "id";
        static final String TITULO = "titulo";
        static final String DATA = "data";
        static final String PAGO = "pago";
        static final String REALIZADO = "realizado";
        static final String ACONTECENDO = "acontecendo";
        static final String NO_FUTURO = "no_futuro";
        static final String ACONTECEU_EM_DOIS_DIAS = "aconteceu_em_dois_dias";
        static final String COMECA_EM_DUAS_HORAS = "comeca_em_duas_horas";
        static final String VAGAS = "vagas";
        static final String QTD_INSCRITOS = "qtd_inscritos";
        static final String QTD_CONFIRMADOS = "qtd_confirmados";
        static final String VAGAS_DISPONIVEIS = "vagas_disponiveis";
        static final String QTD_PRE_INSCRITOS = "qtd_pre_inscritos";
        static final String QTD_NAO_CONFIRMADOS = "qtd_nao_confirmados";
        static final String QTD_CANCELADOS = "qtd_cancelados";
        static final String QTD_INSCRITOS_NOVOS = "qtd_inscritos_novos";
        static final String QTD_PRESENTES = "qtd_presentes";
        static final String QTD_FILA_ESPERA = "qtd_fila_espera";
        static final String PERMITE_INSCRICAO = "permite_inscricao";
        static final String PERMITE_CONFIRMACAO = "permite_confirmacao";
        static final String PERMITE_PRESENCA = "permite_presenca";
        static final String VALIDACAO_PESSOA = "validacao_pessoa";
        static final String FILA_ESPERA = "fila_espera";
        static final String PRECOS = "precos";
        static final String VALOR_PAGO = "valor_pago";
    }

    @JsonField(name = Constants.ID)
    long id;
    @JsonField(name = Constants.TITULO)
    String title;
    @JsonField(name = Constants.DATA)
    Date date;
    @JsonField(name = Constants.PAGO)
    boolean paid;
    @JsonField(name = Constants.REALIZADO)
    boolean realised;
    @JsonField(name = Constants.ACONTECENDO)
    boolean happening;
    @JsonField(name = Constants.NO_FUTURO)
    boolean future;
    @JsonField(name = Constants.ACONTECEU_EM_DOIS_DIAS)
    boolean happendTwoDays;
    @JsonField(name = Constants.COMECA_EM_DUAS_HORAS)
    boolean beginsTwoHours;
    @JsonField(name = Constants.VAGAS)
    int vacancy;
    @JsonField(name = Constants.QTD_INSCRITOS)
    int numRegistered;
    @JsonField(name = Constants.QTD_CONFIRMADOS)
    int numConfirmed;
    @JsonField(name = Constants.VAGAS_DISPONIVEIS)
    int vacancyAvailable;
    @JsonField(name = Constants.QTD_PRE_INSCRITOS)
    int numPreRegistered;
    @JsonField(name = Constants.QTD_NAO_CONFIRMADOS)
    int numNotConfirmed;
    @JsonField(name = Constants.QTD_CANCELADOS)
    int numCanceled;
    @JsonField(name = Constants.QTD_INSCRITOS_NOVOS)
    int numNewRegistered;
    @JsonField(name = Constants.QTD_PRESENTES)
    int numPresent;
    @JsonField(name = Constants.QTD_FILA_ESPERA)
    int numWaitQueue;
    @JsonField(name = Constants.PERMITE_INSCRICAO)
    boolean allowRegistration;
    @JsonField(name = Constants.PERMITE_CONFIRMACAO)
    boolean allowConfirmation;
    @JsonField(name = Constants.PERMITE_PRESENCA)
    boolean allowPresent;
    @JsonField(name = Constants.VALIDACAO_PESSOA)
    UserValidationType validationType;
    @JsonField(name = Constants.FILA_ESPERA)
    boolean waitQueue;
    @JsonField(name = Constants.PRECOS)
    List<Price> prices;
    @JsonField(name = Constants.VALOR_PAGO)
    float paidValue;

}
