package com.example.womensafetyapp;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;

public class GPSTracker extends Service implements LocationListener {

	private final Context context;
	boolean gps_enabled = false;
	boolean network_enabled = false;
	boolean canGetLocation = false;
	double latitude, longitude;
	Location location;

	private static final long MIN_DISTANCE = 10;
	private static final long MIN_TIME = 1000 * 60 * 1;
	protected LocationManager locationManager;

	public GPSTracker(Context context) {
		this.context = context;
		getLocation();
	}

	private Location getLocation() {
		try {
			// TODO Auto-generated method stub
			locationManager = (LocationManager) context
					.getSystemService(LOCATION_SERVICE);
			gps_enabled = locationManager
					.isProviderEnabled(LocationManager.GPS_PROVIDER);

			network_enabled = locationManager
					.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (!gps_enabled && !network_enabled) {

			} else {
				this.canGetLocation = true;
				if (network_enabled) {
					locationManager.requestLocationUpdates(
							LocationManager.NETWORK_PROVIDER, MIN_TIME,
							MIN_DISTANCE, this);

					if (locationManager != null) {
						location = locationManager
								.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) {
							latitude = location.getLatitude();
							longitude = location.getLongitude();
						}
					}
				}

				if (gps_enabled) {
					if (location == null) {
						locationManager.requestLocationUpdates(
								LocationManager.GPS_PROVIDER, MIN_TIME,
								MIN_DISTANCE, this);

						if (locationManager != null) {
							location = locationManager
									.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								latitude = location.getLatitude();
								longitude = location.getLongitude();
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return location;
	}

	public void stopUsingGPS() {
		if (locationManager != null) {
			locationManager.removeUpdates(GPSTracker.this);
		}
	}

	public double getLatitude() {
		if (location != null) {
			latitude = location.getLatitude();
		}
		return latitude;
	}

	public double getLongitude() {
		if (location != null) {
			longitude = location.getLongitude();
		}
		return longitude;
	}

	public boolean canGetLocation() {
		return canGetLocation;
	}

	public void showSettingsAlert() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

		alertDialog.setTitle("GPS Settings");
		alertDialog
				.setMessage("GPS is not enabled, Do you want to go settings menu?");
		alertDialog.setPositiveButton("Settings",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(
								Settings.ACTION_LOCATION_SOURCE_SETTINGS);

						context.startActivity(intent);

					}
				});
		
		alertDialog.setNegativeButton("cancel",
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				

				dialog.cancel();

			}
		});
		alertDialog.show();
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
