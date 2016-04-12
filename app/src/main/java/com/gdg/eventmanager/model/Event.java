package com.gdg.eventmanager.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Event {

    public final class Constants {
        private static final String ID = "id";
        private static final String TITULO = "titulo";
        private static final String DATA = "data";
        private static final String PAGO = "pago";
        private static final String REALIZADO = "realizado";
        private static final String ACONTECENDO = "acontecendo";
        private static final String NO_FUTURO = "no_futuro";
        private static final String ACONTECEU_EM_DOIS_DIAS = "aconteceu_em_dois_dias";
        private static final String COMECA_EM_DUAS_HORAS = "comeca_em_duas_horas";
        private static final String VAGAS = "vagas";
        private static final String QTD_INSCRITOS = "qtd_inscritos";
        private static final String QTD_CONFIRMADOS = "qtd_confirmados";
        private static final String VAGAS_DISPONIVEIS = "vagas_disponiveis";
        private static final String QTD_PRE_INSCRITOS = "qtd_pre_inscritos";
        private static final String QTD_NAO_CONFIRMADOS = "qtd_nao_confirmados";
        private static final String QTD_CANCELADOS = "qtd_cancelados";
        private static final String QTD_INSCRITOS_NOVOS = "qtd_inscritos_novos";
        private static final String QTD_PRESENTES = "qtd_presentes";
        private static final String QTD_FILA_ESPERA = "qtd_fila_espera";
        private static final String PERMITE_INSCRICAO = "permite_inscricao";
        private static final String PERMITE_CONFIRMACAO = "permite_confirmacao";
        private static final String PERMITE_PRESENCA = "permite_presenca";
        private static final String VALIDACAO_PESSOA = "validacao_pessoa";
        private static final String FILA_ESPERA = "fila_espera";
        private static final String PRECOS = "precos";
        private static final String VALOR_PAGO = "valor_pago";
    }

    @SerializedName(Constants.ID)
    private long id;
    @SerializedName(Constants.TITULO)
    private String title;
    @SerializedName(Constants.DATA)
    private Date date;
    @SerializedName(Constants.PAGO)
    private boolean paid;
    @SerializedName(Constants.REALIZADO)
    private boolean realised;
    @SerializedName(Constants.ACONTECENDO)
    private boolean happening;
    @SerializedName(Constants.NO_FUTURO)
    private boolean future;
    @SerializedName(Constants.ACONTECEU_EM_DOIS_DIAS)
    private boolean happendTwoDays;
    @SerializedName(Constants.COMECA_EM_DUAS_HORAS)
    private boolean beginsTwoHours;
    @SerializedName(Constants.VAGAS)
    private int vacancy;
    @SerializedName(Constants.QTD_INSCRITOS)
    private int numRegistered;
    @SerializedName(Constants.QTD_CONFIRMADOS)
    private int numConfirmed;
    @SerializedName(Constants.VAGAS_DISPONIVEIS)
    private int vacancyAvailable;
    @SerializedName(Constants.QTD_PRE_INSCRITOS)
    private int numPreRegistered;
    @SerializedName(Constants.QTD_NAO_CONFIRMADOS)
    private int numNotConfirmed;
    @SerializedName(Constants.QTD_CANCELADOS)
    private int numCanceled;
    @SerializedName(Constants.QTD_INSCRITOS_NOVOS)
    private int numNewRegistered;
    @SerializedName(Constants.QTD_PRESENTES)
    private int numPresent;
    @SerializedName(Constants.QTD_FILA_ESPERA)
    private int numWaitQueue;
    @SerializedName(Constants.PERMITE_INSCRICAO)
    private boolean allowRegistration;
    @SerializedName(Constants.PERMITE_CONFIRMACAO)
    private boolean allowConfirmation;
    @SerializedName(Constants.PERMITE_PRESENCA)
    private boolean allowPresent;
    @SerializedName(Constants.VALIDACAO_PESSOA)
    private UserValidationType validationType;
    @SerializedName(Constants.FILA_ESPERA)
    private boolean waitQueue;
    @SerializedName(Constants.PRECOS)
    private List<Price> prices;
    @SerializedName(Constants.VALOR_PAGO)
    private float paidValue;

}
