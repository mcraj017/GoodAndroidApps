package com.example.learnmalay;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends Activity {

	EditText editTextUserName,editTextPassword,editTextConfirmPassword;
	Button btnCreateAccount;
	LoginDataBaseAdapter loginDataBaseAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singup);
		
		// get Instance  of Database Adapter
				loginDataBaseAdapter=new LoginDataBaseAdapter(this);
				loginDataBaseAdapter=loginDataBaseAdapter.open();
				
				// Get Refferences of Views
				editTextUserName=(EditText)findViewById(R.id.editTextUserName);
				editTextPassword=(EditText)findViewById(R.id.editTextPassword);
				editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
				
				btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
				btnCreateAccount.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					String userName=editTextUserName.getText().toString();
					String password=editTextPassword.getText().toString();
					String confirmPassword=editTextConfirmPassword.getText().toString();
					
					
					
					// check if any of the fields are vaccant
					if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
					{
							Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
							return;
					}
					if(checkAvailabilty(userName))
					{
						Toast.makeText(getApplicationContext(), "THis UserName is already taken please enter another username", Toast.LENGTH_LONG).show();
						return;
					}
					// check if both password matches
					if(!password.equals(confirmPassword))
					{
						Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
						return;
					}
					else
					{
					    // Save the Data in Database
					    loginDataBaseAdapter.insertEntry(userName, password);
					    Toast.makeText(getApplicationContext(), "AKAUN ANDA TELAH BERJAYA DIDAFTAR, SILA KE LOG MASUK UNTUK MENGAKSES APLIKASI INI", Toast.LENGTH_LONG).show();
					    finish();
					}
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sing_up, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private boolean checkAvailabilty(String userName){
		String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);
		if(!storedPassword.equals("NOT EXIST"))
			return true;
		return false;
	}
}
