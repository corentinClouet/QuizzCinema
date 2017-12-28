package com.example.android.quizzcinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Question tbQuestion[] = new Question[10];
    private int num = -1;
    private int score = 0;

    TextView question_txtView;
    RadioButton answer1_rb;
    RadioButton answer2_rb;
    RadioButton answer3_rb;
    RadioButton answer4_rb;
    ImageView wallpaper_imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initTabQuestion();
        initQuiz();
    }

    public void initControls(){
        question_txtView = (TextView)findViewById(R.id.question_textView);
        answer1_rb = (RadioButton)findViewById(R.id.answer1_radioButton);
        answer2_rb = (RadioButton)findViewById(R.id.answer2_radioButton);
        answer3_rb = (RadioButton)findViewById(R.id.answer3_radioButton);
        answer4_rb = (RadioButton)findViewById(R.id.answer4_radioButton);
        wallpaper_imgView = (ImageView)findViewById(R.id.cinema_imageView);
    }

    public void initQuiz(){
        verifEtatQuiz();
        wallpaper_imgView.setImageResource(tbQuestion[num].getImgSource());
        question_txtView.setText(tbQuestion[num].getQuestion());
        answer1_rb.setText(tbQuestion[num].getTbRep()[0].getReponse());
        answer2_rb.setText(tbQuestion[num].getTbRep()[1].getReponse());
        answer3_rb.setText(tbQuestion[num].getTbRep()[2].getReponse());
        answer4_rb.setText(tbQuestion[num].getTbRep()[3].getReponse());
    }

    public void initTabQuestion(){
        tbQuestion[0] = new Question("Quel acteur incarne le rôle du héro Captain America ?", R.drawable.captain_america);
        tbQuestion[0].getTbRep()[0] = new Reponse("Chris Evans", true);
        tbQuestion[0].getTbRep()[1] = new Reponse("Chris Hemsworth", false);
        tbQuestion[0].getTbRep()[2] = new Reponse("Chris Pratt", false);
        tbQuestion[0].getTbRep()[3] = new Reponse("Chris Brown", false);

        tbQuestion[1] = new Question("Quel acteur incarne le rôle du héro Wolverine ?", R.drawable.wolverine);
        tbQuestion[1].getTbRep()[0] = new Reponse("Colin Farell", false);
        tbQuestion[1].getTbRep()[1] = new Reponse("Nicolas Cage", false);
        tbQuestion[1].getTbRep()[2] = new Reponse("Hugh Jackman", true);
        tbQuestion[1].getTbRep()[3] = new Reponse("Robert Downey Jr.", false);
    }
    
    public void verifEtatQuiz(){
        if (num<tbQuestion.length-1){
            num++;
        }
        else{
            num = 0;
            score = 0;
            Toast.makeText(this, "Votre score est de " + score + "/10 ! Rejouez une partie !", Toast.LENGTH_LONG).show();
        }
    }

    public void verifReponse(View v){
        int idReponse = -1;
        if (answer1_rb.isChecked()){idReponse = 0;}
        if (answer2_rb.isChecked()){idReponse = 1;}
        if (answer3_rb.isChecked()){idReponse = 2;}
        if (answer4_rb.isChecked()){idReponse = 3;}
        if (tbQuestion[num].getTbRep()[idReponse].getEstLaBonneReponse()){score++;}
        initQuiz();
    }
}
