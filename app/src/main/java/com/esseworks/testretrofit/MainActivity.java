package com.esseworks.testretrofit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private TestService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://secret-lake-7090.herokuapp.com/")
                .build();

        service = restAdapter.create(TestService.class);

        TextView tv = (TextView) findViewById(R.id.tv_test);
        final TestRequest request = new TestRequest();
        request.setParam("p1", "hello")
                .setParam("p2", "world");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.updateWelcome(request, new Callback<TestResponse>() {
                    @Override
                    public void success(TestResponse testResponse, Response response) {
                        HashMap<String, String> map = testResponse.getParams();
                        Log.d("app_logs", map.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
