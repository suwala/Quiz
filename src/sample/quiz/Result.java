package sample.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Result extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        
        
        
        //getStringExtra “n‚³‚ê‚½’Ç‰Á•¶š—ñ‚ğó‚¯æ‚é@getStringExtra("keyword") •Ô‚è’l‚ª“n‚µ‚½•¶š—ñ‚Û‚¢
        //static‚Å‚à‰ğŒˆ‚Å‚«‚é‚±‚Æ‚ª”»–¾‚»‚Á‚ÆŒ©‘—‚é
        
        //String data = i.getStringExtra("a_count");

        
        TextView tv = (TextView)findViewById(R.id.textView1);
        tv.setText("‚ ‚È‚½‚Ì³‰ğ”‚Í"+Question.a_c.toString()+"‚Å‚·I");
        
    }
	
	public void toTitle(View view){
		Intent i=new Intent(this,MainActivity.class);
		this.startActivity(i);
	}

}
