package com.example.bluetooth_test;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.renderscript.Sampler.Value;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DeviceListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.devicelist);
    	// Get the local Bluetooth adapter
    	/*
    	BluetoothAdapter mBtAdapter = BluetoothAdapter.getDefaultAdapter();
    	 
    	// Get a set of currently paired devices
    	Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();
    	 
    	// If there are paired devices, add each one to the ArrayAdapter
    	if (pairedDevices.size() > 0) {
    	    findViewById(R.id.title_paired_devices).setVisibility(View.VISIBLE);
    	    for (BluetoothDevice device : pairedDevices) {
    	        mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
    	    }
    	} else {
    	    String noDevices = getResources().getText(R.string.none_paired).toString();
    	    mPairedDevicesArrayAdapter.add(noDevices);
    	}
    	*/
    }
}
