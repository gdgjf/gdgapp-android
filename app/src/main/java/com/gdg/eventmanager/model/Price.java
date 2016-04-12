package com.gdg.eventmanager.model;

import com.google.gson.annotations.SerializedName;

public class Price {

    public final class Constants {
        private static final String ID = "id";
        private static final String TITULO = "titulo";
        private static final String VALOR = "valor";
        private static final String QTD_CONFIRMADOS = "_qtd_confirmados";
        private static final String VALOR_PAGO = "valor_pago";
    }

    @SerializedName(Constants.ID)
    private long id;
    @SerializedName(Constants.TITULO)
    private String title;
    @SerializedName(Constants.VALOR)
    private float value;
    @SerializedName(Constants.QTD_CONFIRMADOS)
    private int numConfirmed;
    @SerializedName(Constants.VALOR_PAGO)
    private float paidValue;

}
