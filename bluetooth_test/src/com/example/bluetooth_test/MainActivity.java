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
		//BluetoothAdapter�擾
		BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
		boolean btEnable = Bt.isEnabled();

		if(!Bt.equals(null)){
		    //Bluetooth�Ή��[���̏ꍇ�̏���
		    Log.d("BL","Bluetooth���T�|�[�g����Ă܂��B");
		}else{
		    //Bluetooth��Ή��[���̏ꍇ�̏���
		    Log.d("BL","Bluetooth���T�|�[�g��Ă��܂���B");
		    finish();
		}
		
	    if(btEnable == true){
	        
	    }else{
	        //OFF�������ꍇ�AON�ɂ��邱�Ƃ𑣂��_�C�A���O��\�������ʂɑJ��
	        Intent btOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	        startActivityForResult(btOn, REQUEST_ENABLE_BLUETOOTH);
	    }
    }
    
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
        //�_�C�A���O��ʂ��猋�ʂ��󂯂���̏������L�q
        if(requestCode == REQUEST_ENABLE_BLUETOOTH){
            if(ResultCode == Activity.RESULT_OK){
                //Bluetooth��ON�ɂ��ꂽ�ꍇ�̏���
                Log.d("BL","Bluetooth��ON�ɂ��Ă��炦�܂����B");
            }else{
                Log.d("BL","Bluetooth��ON�ɂ��Ă��炦�܂���ł����B");
                finish();
            }
        }
    }
}
