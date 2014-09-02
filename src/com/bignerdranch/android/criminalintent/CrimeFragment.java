package com.bignerdranch.android.criminalintent;

import java.util.Date;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
	
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	private DateFormat mDateFormat = new DateFormat();;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mCrime = new Crime();
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		
		mTitleField = (EditText)v.findViewById(R.id.crime_title);
		
		mTitleField.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(
					CharSequence c, int start, int before, int count) {
					mCrime.setTitle(c.toString());
					}
			
			public void beforeTextChanged(
					CharSequence c, int start, int count, int after) {
					// This space intentionally left blank
					}
			public void afterTextChanged(Editable c) {
				// This one too
				}
		});
		
		mDateButton = (Button)v.findViewById(R.id.crime_date);
		
		Date crimeDate = mCrime.getDate();

		CharSequence pattern = "EEEE, MMM dd, yyyy";   
   		CharSequence dateFormat = android.text.format.DateFormat.format(pattern, crimeDate);
   				
		mDateButton.setText(dateFormat);
		mDateButton.setEnabled(false);
		
		mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
				// Set the crime's solved property
				mCrime.setSolved(isChecked);
				
			}
		});
		
		return v;
	}

}
