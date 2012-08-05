package sample.quiz;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {


	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.d("ran:配列数:配列1-3","1前");
        Randam_i randam = new Randam_i(3,3);
        Log.d("ran:配列数:配列1-3",randam.box[0].toString()+randam.box[1].toString()+randam.box[2].toString());
                		
    }
    
    public void randam(View v){
    	Randam_i randam = new Randam_i(2,2);
    	//Log.d("ran:配列数:配列1-3",randam.box[0].toString()+randam.box[1].toString()+randam.box[2].toString()+randam.box[3].toString()+randam.box[4].toString());
    
    	Log.d("ran:配列数:配列1-3",randam.box[0].toString()+randam.box[1].toString());
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		// TODO 自動生成されたメソッド・スタブ
//		
//				
//		//ジャンル選択(menu)未実装
//		//Intent i = new Intent(this,sample.quiz.Menu.class);
//		
//		Log.d("aaa","aaa");
//		Intent i = new Intent(this,Question.class);
//		this.startActivityForResult(i, 0);
//
//		return super.onTouchEvent(event);
//		
//		
//	}
	
	public void gnrS(View view) {
		// TODO 自動生成されたメソッド・スタブ
		
				
		//ジャンル選択(menu)未実装
		Intent i = new Intent(this,sample.quiz.Menu.class);
		
		//Intent i = new Intent(this,Question.class);
		Log.d("count",Question.a_c.toString());
		
		this.startActivityForResult(i, 0);

		
		
		
	}

    

    
}
