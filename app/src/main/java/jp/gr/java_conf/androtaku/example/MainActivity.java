package jp.gr.java_conf.androtaku.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import jp.gr.java_conf.androtaku.countrylist.Country;
import jp.gr.java_conf.androtaku.countrylist.CountryList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        List<Country> countries = CountryList.getCountries(this);
        for(Country country : countries){
            adapter.add("NAME: " + country.getName() + " CODE: " + country.getCode());
        }
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
