package com.prasad.homeworkthree;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner imageSpinner = (Spinner)findViewById(R.id.imageSpinner);
		final ImageView imageView = (ImageView)findViewById(R.id.imageSpinnerView);
		final CheckBox toggleImgChkBox = (CheckBox)findViewById(R.id.toggleImageCheckBox);
		imageSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0://load fruit
					imageView.setImageDrawable(getResources().getDrawable(R.drawable.fruits));
					break;
				case 1:
					imageView.setImageDrawable(getResources().getDrawable(R.drawable.rose));
					break;	
				case 2:
					imageView.setImageDrawable(getResources().getDrawable(R.drawable.peacock));
					break;	   
				default:
					imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
					break;
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
				
			}
		});
		
	//Toggle image by checkbox
		toggleImgChkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked)
				{
					imageView.setVisibility(View.VISIBLE);
				}else{
					imageView.setVisibility(View.INVISIBLE);
				}
			}
		});
		
		
	//image opacity seek bar
		SeekBar imgOpacitySeekBar = (SeekBar)findViewById(R.id.imgOpacitySeekBar);
		imgOpacitySeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				imageView.setAlpha(((float) seekBar.getProgress()/255));
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				
			}
		});
		setupAutoCompleteTextView();
		final TextView ratingBarSubmittedTextView = (TextView)findViewById(R.id.ratingSubmittedTextView);
		
			ratingBarSubmittedTextView.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {
					AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteRatingTextView);
					textView.setVisibility(View.VISIBLE);
					return true;
				}
			});
		
	}
	
	public void ratingButtonClicked(View v)
	{
		RatingBar ratingBar = (RatingBar)findViewById(R.id.imgRatingBar);
		TextView ratingBarSubmittedTextView = (TextView)findViewById(R.id.ratingSubmittedTextView);
		ratingBarSubmittedTextView.setText(getResources().getString(R.string.ratingSubmittedTextView).concat(" ".concat(String.valueOf(ratingBar.getRating())).concat(" ").concat(getResources().getString(R.string.ratingSubmittedTextViewAppend))));
		ratingBarSubmittedTextView.setVisibility(View.VISIBLE);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setupAutoCompleteTextView() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, new String[] {
						"Wicked Awesome!","A'ight","Weak Sauce" });
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteRatingTextView);
		textView.setAdapter(adapter);
	}
}
