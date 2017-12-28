package com.example.android.quizzcinema;

/**
 * Created by Corentin on 17/12/2017.
 */

public class Question {
    private String question;
    private Reponse tbRep[];
    private int imgSource;

    public Question(){
        question = "";
        tbRep = new Reponse[4];
        imgSource = 0;
    }

    public Question(String pQuestion, int pImgSource){
        question = pQuestion;
        tbRep = new Reponse[4];
        imgSource = pImgSource;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Reponse[] getTbRep() {
        return tbRep;
    }

    public void setTbRep(Reponse[] tbRep) {
        this.tbRep = tbRep;
    }

    public int getImgSource() {
        return imgSource;
    }

    public void setImgSource(int imgSource) {
        this.imgSource = imgSource;
    }
}
