package es.solusoft.formacionandroidejemplos;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Codigo de ejemplo de implementacion y comportamiento de una webview
 * @author findemor
 *
 */
public class WebActivity extends Activity {

	private WebView mWebView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		
		mWebView = (WebView) findViewById(R.id.webview);
        
		mWebView.setInitialScale(1);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setLoadWithOverviewMode(true);
		mWebView.getSettings().setUseWideViewPort(true);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(false);
		
		mWebView.setScrollbarFadingEnabled(true);
		mWebView.clearCache(true);

		mWebView.loadUrl("http://www.topoos.com");
		
		// Hacemos que los alert JavaScript se muestren como Alerts 
		// nativos de Android
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public boolean onJsAlert(WebView view, String url,
					String message, android.webkit.JsResult result) {
				// Required functionality here
				return super.onJsAlert(view, url, message, result);
			}
		});
        
        mWebView.setWebViewClient(new CustomViewClient());
	}
	

	private class CustomViewClient extends WebViewClient {
		@Override
		public void onPageStarted(
				WebView view, String url, Bitmap favicon) 
		{
				super.onPageStarted(view, url, favicon);
		}
	}


}
