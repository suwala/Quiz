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
