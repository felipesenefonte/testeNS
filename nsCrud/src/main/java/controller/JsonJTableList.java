package controller;

import model.Endereco;

import java.util.List;

/**
 * List auxiliar para o jtable.
 */
public class JsonJTableList {

    private String Result;

    private List<Endereco> Records;

    private int TotalRecordCount;

    private String Message;

    public JsonJTableList(){}

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public List<Endereco> getRecords() {
        return Records;
    }

    public void setRecords(List<Endereco> Records) {
        this.Records = Records;
    }

    public int getTotalRecordCount() {
        return TotalRecordCount;
    }

    public void setTotalRecordCount(int TotalRecordCount) {
        this.TotalRecordCount = TotalRecordCount;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

}