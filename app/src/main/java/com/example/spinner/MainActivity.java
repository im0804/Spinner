package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener{

    TextView tvLN, tvPN, tvBD, tvP;
    Spinner sp;
    ListView lv;
    int newpos;
    String [] classes = {"choose class", "1","2","3","4"};
    String [][] pvName = {
            {"yarin","shay","idan","orel","eden","maya","dorel","dan","daniel","or"},
            {"noam","yahav","omer","shir","roey","agam","ofek","ori","i.m","dead"},
            {"kobi","oren","alon","annabele","chuck", "albert","ido","eyal","albertito","asaf"},
            {"rony","eti","angry","maayan","reut","olive","dal","u.r","albertitof","sabastian"}
    };
    String [][] ltName = {
            {"david", "shtime","bonk","shva","mayzos","gedg","zor","slep","gan","baals"},
            {"negro","shatrker","somerhalder","dolan","mangina","mussolini","nagav","hadrina","tired","pool"},
            {"maman","maharab","shuts","girly","doll","levi","zino","cohen","levito","daly"},
            {"mahfoody","matlit","birds","gedi","simsh","oil","kaloriot","crazy","frenky","theGreat"}
    };
    String [][] birthDay = {
            {"12.11.2009","29.7.2009","19.7.2010","10.8.2009","09.4.2009","01.4.2009","08.9.2010","06.6.2010","03.1.2009","12.2.2010"},
            {"14.1.2006","31.12.2005","10.5.2006","11.12.2006","17.12.2005","13.9,2006","19.2.2006","23.11.2006","30.6.2006","07.09.2006"},
            {"7.7.1999","1.7.1999","23.10.1999","1.10.1999","03.3.1999","30.3.1999","24.4.1999","10.3.1999","27.1.1999","12.12.1999"},
            {"12.1.2012","24.3.2012","3.2.1012","17.11.2012","12.9.2012","15.8.2012","13.5.2012","20.12.2011","19.10.2011","19.3.2012"}
    };
    String [][] phoneNum = {
            {"0534755654","0537685956","0597664869","0519385759","0519384730","0529485736","0595757204","0518475326","0542845760","0567786699"},
            {"0556490069","0502384665","0523049886","0523900958","5012837645","0503847266","0534058876","0505343495","0512876780","0563528047"},
            {"0567839870","0513836554","0518376553","0519398888","0528365477","0516344423","0536488009","0567345526","0519928376","0594987722"},
            {"0562544333","0512443332","0510098477","0500598866","0592766333","0514978765","0524136779","0504775661","0504434979","0525254678"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLN = (TextView) findViewById(R.id.tvLN);
        tvPN = (TextView) findViewById(R.id.tvPN);
        tvBD = (TextView) findViewById(R.id.tvBD);
        tvP = (TextView) findViewById(R.id.tvP);
        sp = (Spinner) findViewById(R.id.sp);
        lv = (ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        sp.setOnItemSelectedListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String >(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,classes);
        sp.setAdapter(adp);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position != 0){
            newpos = position-1;
            ArrayAdapter<String> adp2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,pvName[newpos]);
            lv.setAdapter(adp2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "please choose a class", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvPN.setText("private name: "+pvName[newpos][position]);
        tvLN.setText("last name: "+ltName[newpos][position]);
        tvBD.setText("birth day: "+birthDay[newpos][position]);
        tvP.setText("phone: "+phoneNum[newpos][position]);
    }
}