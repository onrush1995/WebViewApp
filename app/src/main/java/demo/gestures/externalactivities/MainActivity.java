package demo.gestures.externalactivities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    EditText link;
    Button btn_link;
    Button btn_dial;
    Button btn_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser=(WebView) findViewById(R.id.webId);
        link=(EditText) findViewById(R.id.urlId);
        btn_link=(Button)findViewById(R.id.goBtn);
        btn_dial=(Button)findViewById(R.id.dialId);
        btn_map=(Button) findViewById(R.id.openMapId);

        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0401240142"));
                startActivity(intent);
            }
        });

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent((Intent.ACTION_VIEW));
                intent.setData(Uri.parse("https://www.google.fi/maps/place/OUAS/@64.9994848,25.509679,17z/data=!4m12!1m6!3m5!1s0x4681cd452343d31f:0xca6e07c114a9fd6e!2sOUAS!8m2!3d64.9994825!4d25.5118677!3m4!1s0x4681cd452343d31f:0xca6e07c114a9fd6e!8m2!3d64.9994825!4d25.5118677?hl=en"));
                //Uri location=Uri.parse("https://www.google.fi/maps/place/OUAS/@64.9994848,25.509679,17z/data=!4m12!1m6!3m5!1s0x4681cd452343d31f:0xca6e07c114a9fd6e!2sOUAS!8m2!3d64.9994825!4d25.5118677!3m4!1s0x4681cd452343d31f:0xca6e07c114a9fd6e!8m2!3d64.9994825!4d25.5118677?hl=en");
                startActivity(intent);
            }
        });



        browser.setWebViewClient(new myViewClient());

        btn_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=link.getText().toString();

                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);

                browser.loadUrl(url);
            }
        });

    }

    private class myViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}
