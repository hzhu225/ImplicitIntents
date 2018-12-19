package com.cms.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText urlEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEditText = findViewById(R.id.url_editText);
    }

    public void openWebsite(View view)
    {
        String urlContent = urlEditText.getText().toString();
        Uri uri = Uri.parse(urlContent);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if(intent.resolveActivity(getPackageManager())!= null)
        {
           startActivity(intent);
        }
        else
        {
            Log.d("ImplicitIntents", "Can't handle this!");
        }

    }

    public void openLocation(View view)
    {
    }

    public void shareText(View view)
    {
    }
}
