package com.cms.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    private EditText urlEditText;
    private EditText locationEditText;
    private EditText shareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlEditText = findViewById(R.id.url_editText);
        locationEditText = findViewById(R.id.location_editText);
        shareEditText = findViewById(R.id.share_editText);
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
        String locationContent = locationEditText.getText().toString();
        Uri geoUri = Uri.parse("geo:0,0?q=" + locationContent);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else
        {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view)
    {
        String shareContent = shareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with")
                .setText(shareContent)
                .startChooser();

    }
}
