package cat.copernic.kyt3c.fitnessreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView web = (WebView)findViewById(R.id.web1);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://www.calculopesoideal.com/");
    }
}
