package com.example.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		final Button btn_ok = (Button) findViewById(R.id.splash_btn_ok);

		btn_ok.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				StartActivity.this.startActivity(new Intent(StartActivity.this,
						MainMenuActivity.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_start, menu);
		return true;
	}
}
