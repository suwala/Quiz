package sample.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Menu extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                
        setContentView(R.layout.menu);
        
        
        
       
    }
	
	public void qesS(View view){
		Intent i = new Intent(this,Question.class);
		this.startActivityForResult(i,0);
	}

}
