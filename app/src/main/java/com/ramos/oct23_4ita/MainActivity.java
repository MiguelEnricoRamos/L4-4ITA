package com.ramos.oct23_4ita;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] api, ver, level, date, description;
    ListView list;
    int[] cLogo = {R.drawable.none, R.drawable.none2, R.drawable.donut, R.drawable.froyo, R.drawable.gingerbread,
            R.drawable.woneycomb, R.drawable.icecream, R.drawable.jellybean, R.drawable.kitkat,
            R.drawable.lollipop, R.drawable.marshmallow, R.drawable.nougat, R.drawable.oreo, R.drawable.none,
            R.drawable.none};

    ArrayList<Version> VersionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = getResources().getStringArray(R.array.apis);
        ver = getResources().getStringArray(R.array.versions);
        level = getResources().getStringArray(R.array.level);
        date = getResources().getStringArray(R.array.relDate);
        description = getResources().getStringArray(R.array.description);
        list = findViewById(R.id.lvVersions);
        for(int i = 0; i < api.length; i++){
            VersionList.add(new Version(cLogo[i], api[i], ver[i], level[i], date[i], description[i]));
        }
        list = findViewById(R.id.lvVersions);
        VersionAdapter adapter = new VersionAdapter(this, R.layout.item ,VersionList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // Toast.makeText(this, names[i], Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(VersionList.get(i).getApis());
        dialog.setIcon(VersionList.get(i).getLogo());
        dialog.setMessage(VersionList.get(i).getDescription());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                dialog.dismiss();
            }
        });
        dialog.create().show();

    }
}