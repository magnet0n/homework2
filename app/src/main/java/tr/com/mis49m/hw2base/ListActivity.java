package tr.com.mis49m.hw2base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity
{

    TextView tvContent;
    Button btnShare;
    Spinner spType;
    RecyclerView recyclerView;

    ArrayList<content> contentList = new ArrayList<content>();

    final String[] spinnerContents = {"All network", "Just My Friends"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tvContent = (TextView) findViewById(R.id.postlanan);
        btnShare = (Button) findViewById(R.id.share);
        spType = (Spinner) findViewById(R.id.spinner);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        contentList.add(new content("mis49m\n","Hello\tworld"));
        contentList.add(new content("Lorem\tIpsum", "Lorem\tipsum\tdolor\tsit\tamet,\tconsectetur\tadipiscing\telit,\tsed\tdo\teiusmod\t\n" +
                "tempor\tincididunt\tut\tlabore\tet\tdolore\tmagna\taliqua.\tUt\tenim\tad\tminim\tveniam,\tquis\t\n" +
                "nostrud\texercitation\tullamco\tlaboris\tnisi\tut\taliquip\tex\tea\tcommodo\tconsequat."));

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, spinnerContents);
        spType.setAdapter(adapterSpinner);
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedContent = spinnerContents[position];
                Toast.makeText(ListActivity.this, "Spinner:" + selectedContent, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        AdapterSer adapter = new AdapterSer(contentList);
        recyclerView.setAdapter(adapter);

        btnShare.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String message = tvContent.getText().toString();
                contentList.add(new content("2015502219",message));
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        return true;
    }
}
