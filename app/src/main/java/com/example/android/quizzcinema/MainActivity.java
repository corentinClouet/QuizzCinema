package com.example.android.quizzcinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    ProgressBar pgBar;

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
        wallpaper_imgView = (ImageView)findViewById(R.id.cinema_imageView);
        pgBar = (ProgressBar)findViewById(R.id.pgBar_progressBar);
    }

    public void initQuiz(){
        verifEtatQuiz();
        pgBar.setProgress(num+1);
        answer1_rb.setChecked(true);
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

        tbQuestion[2] = new Question("Quel est le nom du personnage de Kate Winslet dans Titanic ?", R.drawable.titanic);
        tbQuestion[2].getTbRep()[0] = new Reponse("Ema", false);
        tbQuestion[2].getTbRep()[1] = new Reponse("Rose", true);
        tbQuestion[2].getTbRep()[2] = new Reponse("Lily", false);
        tbQuestion[2].getTbRep()[3] = new Reponse("Léa", false);

        tbQuestion[3] = new Question("Dans quel film apparait le personnage Clarice Starling ?", R.drawable.clarice_starling);
        tbQuestion[3].getTbRep()[0] = new Reponse("Le silence des agneaux", true);
        tbQuestion[3].getTbRep()[1] = new Reponse("Revenge", false);
        tbQuestion[3].getTbRep()[2] = new Reponse("The last seduction", false);
        tbQuestion[3].getTbRep()[3] = new Reponse("Un homme d'exception", false);

        tbQuestion[4] = new Question("Dans la version anglaise du film animé \"Toy Story\", quel acteur joue la voix de Woody ?", R.drawable.woody);
        tbQuestion[4].getTbRep()[0] = new Reponse("Tom Hanks", true);
        tbQuestion[4].getTbRep()[1] = new Reponse("Tom Cruise", false);
        tbQuestion[4].getTbRep()[2] = new Reponse("John Travolta", false);
        tbQuestion[4].getTbRep()[3] = new Reponse("Mel Gibson", false);

        tbQuestion[5] = new Question("Dans quel film Robin Williams joue le rôle d'une gouvernante Irlandaise ?", R.drawable.robin_williams);
        tbQuestion[5].getTbRep()[0] = new Reponse("Flubber", false);
        tbQuestion[5].getTbRep()[1] = new Reponse("Patch Adams", false);
        tbQuestion[5].getTbRep()[2] = new Reponse("Hook", false);
        tbQuestion[5].getTbRep()[3] = new Reponse("Madame Doubtfire", true);

        tbQuestion[6] = new Question("Quel est le vrai nom de Batman ?", R.drawable.batman);
        tbQuestion[6].getTbRep()[0] = new Reponse("Bruce Forsythe", false);
        tbQuestion[6].getTbRep()[1] = new Reponse("Bruce Lee", false);
        tbQuestion[6].getTbRep()[2] = new Reponse("Bruce Dwayne", false);
        tbQuestion[6].getTbRep()[3] = new Reponse("Bruce Wayne", true);

        tbQuestion[7] = new Question("Quel acteur joue le rôle de Jack Sparrow ?", R.drawable.jack_sparrow);
        tbQuestion[7].getTbRep()[0] = new Reponse("Brendan Fraser", false);
        tbQuestion[7].getTbRep()[1] = new Reponse("Johnny Depp", true);
        tbQuestion[7].getTbRep()[2] = new Reponse("Vince Vaughn", false);
        tbQuestion[7].getTbRep()[3] = new Reponse("Orlando Bloom", false);

        tbQuestion[8] = new Question("Quel est le nom du personnage de Carrie Fisher dans Star Wars ?", R.drawable.carrie_fisher);
        tbQuestion[8].getTbRep()[0] = new Reponse("Padmé Amidala", false);
        tbQuestion[8].getTbRep()[1] = new Reponse("Princesse Leia", true);
        tbQuestion[8].getTbRep()[2] = new Reponse("Rey", false);
        tbQuestion[8].getTbRep()[3] = new Reponse("Sabé", false);

        tbQuestion[9] = new Question("Quel acteur n'a jamais joué le rôle de Spider-Man ?", R.drawable.spider_man);
        tbQuestion[9].getTbRep()[0] = new Reponse("Tobey Maguire", false);
        tbQuestion[9].getTbRep()[1] = new Reponse("Andrew Garfield", false);
        tbQuestion[9].getTbRep()[2] = new Reponse("Tom Hiddlestone", true);
        tbQuestion[9].getTbRep()[3] = new Reponse("Tom Holland", false);
    }
    
    public void verifEtatQuiz(){
        if (num<tbQuestion.length-1){
            num++;
        }
        else{
            Toast.makeText(this, "Votre score est de " + score + "/10 ! Rejouez une partie !", Toast.LENGTH_LONG).show();
            num = 0;
            score = 0;
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
