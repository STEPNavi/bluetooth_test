package com.example.bluetooth_test;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

	private final int REQUEST_ENABLE_BLUETOOTH = 10;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bluetooth();
        Intent i = new Intent(getApplicationContext(),DeviceListActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    private void bluetooth(){
		//BluetoothAdapter取得
		BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
		boolean btEnable = Bt.isEnabled();

		if(!Bt.equals(null)){
		    //Bluetooth対応端末の場合の処理
		    Log.d("BL","Bluetoothがサポートされてます。");
		}else{
		    //Bluetooth非対応端末の場合の処理
		    Log.d("BL","Bluetoothがサポートれていません。");
		    finish();
		}
		
	    if(btEnable == true){
	        
	    }else{
	        //OFFだった場合、ONにすることを促すダイアログを表示する画面に遷移
	        Intent btOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	        startActivityForResult(btOn, REQUEST_ENABLE_BLUETOOTH);
	    }
    }
    
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
        //ダイアログ画面から結果を受けた後の処理を記述
        if(requestCode == REQUEST_ENABLE_BLUETOOTH){
            if(ResultCode == Activity.RESULT_OK){
                //BluetoothがONにされた場合の処理
                Log.d("BL","BluetoothをONにしてもらえました。");
            }else{
                Log.d("BL","BluetoothがONにしてもらえませんでした。");
                finish();
            }
        }
    }
}
