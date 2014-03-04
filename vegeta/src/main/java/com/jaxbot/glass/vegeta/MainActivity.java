package com.jaxbot.glass.vegeta;

import android.app.Activity;
import android.view.View;
import android.os.BatteryManager;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.res.Resources;
import android.speech.tts.TextToSpeech;

import com.google.android.glass.app.Card;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
	private TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // Do nothing.
				tts.speak("It's over 9000!", TextToSpeech.QUEUE_FLUSH, null);
            }
        });
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		// Display it.
		Card card = new Card(this);
		card.setText("It's over 9000!");
		View cardView = card.toView();
		setContentView(cardView);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
    public void onDestroy() {
		tts.shutdown();
        
        super.onDestroy();
	}
}

