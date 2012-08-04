package sample.quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question extends Activity{

    boolean q = true;	//画面状態のフラグ
    Integer q_count,q_c=0;    //総問題数のカウント　DBのメソッドで解決できる？ q_c = 現在が難問目かの保持
    
    
    Integer q_syutudai = 3; //出題数
    
    Integer[] q_ran = new Integer[q_syutudai];//ランダムに数字を取得し配列に格納
    
    static Integer a_c = 0; //正解数のカウント
    String[] mondai = new String[q_syutudai]; 
    
    DBHelper dbh = new DBHelper(this);
    
    SQLiteDatabase db = dbh.getReadableDatabase();
    Cursor c = db.query("雑学", new String[] {"question","choices1","choices2","choices3","choices4","ans"}, null,null,null,null,null);
    boolean isEof = c.moveToFirst();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        
        
        for(q_count=0;isEof;q_count++){
        	isEof = c.moveToNext();
        }
        isEof = c.moveToFirst();
        
        
        
        
        int i = 0;
        while(true){
        	if(i>=q_ran.length)
        		break;
        	q_ran[i] = (int) (Math.random()*q_count);
        	i++;
        }
        
        Log.d("q_ran",q_ran[0].toString()+":"+q_ran[1].toString()+":"+q_ran[2].toString());
        this.question2();
        

/*        ローカルだと使い勝手が悪いのでフィールドへ移動
			oncreateでDB開く⇒文字配列で問題数だけ受け取った方が効率がメモリに優しい？
			
        DBHelper dbh = new DBHelper(this);
        
        SQLiteDatabase db = dbh.getReadableDatabase();
        Cursor c = db.query("雑学", new String[] {"question","ans1","ans2","ans3","ans4"}, null,null,null,null,null );
        //Cursor c = db.query("genre1", new String[] {"question"}, null,null,null,null,null );
        
        boolean isEof = c.moveToFirst();
        isEof = c.moveToFirst();
        
        while(isEof){
        	Log.v("DB",c.getString(0)+c.getString(1)+c.getString(2)+c.getString(3)+c.getString(4));
        	
        	
        	TextView tv = (TextView)findViewById(R.id.quetion);
        	//tv.setText(String.format("%s",c.getString(0)));
        	tv.setText(c.getString(0));
        	tv = (TextView)findViewById(R.id.button1);
        	tv.setText(c.getString(1));
        	tv = (TextView)findViewById(R.id.button2);
        	tv.setText(c.getString(2));
        	tv = (TextView)findViewById(R.id.button3);
        	tv.setText(c.getString(3));
        	tv = (TextView)findViewById(R.id.button4);
        	tv.setText(c.getString(4));
        	isEof = c.moveToNext();
        	q_count++;
        }
        
        c.close();
        db.close();*/
    }

	
	//問題取得めそっど ランダム取得型実装により現在未使用
	 public void question(){
	
		 if(q_c < q_syutudai){	
        
			 //総問題数が増えると明らかに無駄な動きなため改造が必要
			 
			 Log.v("DB",c.getString(0)+c.getString(1)+c.getString(2)+c.getString(3)+c.getString(4)+c.getString(5));
			 TextView tv = (TextView)findViewById(R.id.quetion);
			 tv.setText(c.getString(0));
			 tv = (TextView)findViewById(R.id.button1);
			 tv.setText(c.getString(1));
			 tv = (TextView)findViewById(R.id.button2);
			 tv.setText(c.getString(2));
			 tv = (TextView)findViewById(R.id.button3);
			 tv.setText(c.getString(3));
			 tv = (TextView)findViewById(R.id.button4);
			 tv.setText(c.getString(4));
			 
			 
			 
			 
        }else{
        	Intent i = new Intent(this,Result.class);
        	
        	//putExtra インテントに追加で文字列？を渡せる　putextra("keyword",String)
        	/*static追加により実装見送る
        	i.putExtra("a_count", q_count.toString());
        	*/
        	
        	
        	//一応閉じる
        	c.close();
        	db.close();
        	
        	//startActivityとForResultの違いは？
        	this.startActivity(i);
        }
		
	}
	
	//問題をランダムに取得 原因不明エラーアリ
	 public void question2(){
		 
		 if(q_c < q_syutudai){	
			 
			 
			 //ハマリ　c.moveはオフセット現在地からの移動のためtoFirstで最初の地点へ戻す必要があった
			 
			 c.moveToFirst();
			 c.move(q_ran[q_c]);
			 Log.d("c.move",c.toString());
			 TextView tv = (TextView)findViewById(R.id.quetion);
			 tv.setText(c.getString(0));
			 tv = (TextView)findViewById(R.id.button1);
			 tv.setText(c.getString(1));
			 tv = (TextView)findViewById(R.id.button2);
			 tv.setText(c.getString(2));
			 tv = (TextView)findViewById(R.id.button3);
			 tv.setText(c.getString(3));
			 tv = (TextView)findViewById(R.id.button4);
			 tv.setText(c.getString(4));
		 }else{
			 Intent i = new Intent(this,Result.class);
			  
			 c.close();
			 db.close();
			 this.startActivity(i);
		 }
			 
		
		
	 }
	 
	public void answer(View view){
		
		
		//qがtrueの時は問題、falseの時は回答が表示されてる　ということにしよう
		//問題表示の時は回答の消去　回答表示の時は問題の表示の2分岐
		
		
		if(q){
			
			Button btn = (Button)view;
			Log.d("ddd",btn.getText().toString()+":"+c.getString(5));
			
			//押したbtnのtextを取得しdbの答えと照合　合否で分岐
			if(btn.getText().toString().equals(c.getString(5))){
				
				btn = (Button) findViewById(R.id.button1);
				btn.setText("");
				btn = (Button) findViewById(R.id.button2);
				btn.setText("");
				btn = (Button) findViewById(R.id.button3);
				btn.setText("");
				btn = (Button) findViewById(R.id.button4);
				btn.setText("");
				
				btn = (Button)view;
				
				btn.setText("正解！");
				
				a_c++;
				q=false;
			}else{
			//選択肢を消去
				btn = (Button) findViewById(R.id.button1);
				btn.setText("");
				btn = (Button) findViewById(R.id.button2);
				btn.setText("");
				btn = (Button) findViewById(R.id.button3);
				btn.setText("");
				btn = (Button) findViewById(R.id.button4);
				btn.setText("");
				
				
				btn = (Button)view;
		
				btn.setText("残念！");

				q=false;}
		
			//isEof = c.moveToNext();
		}else{
			q_c++;
			this.question2();
			q=true;
		}
		
		//this.sleep(2000);
		
	}
	
	  //指定ミリ秒実行を止めるメソッド ※いらなかった
	  public synchronized void sleep(long msec)
	    {	
	    	try
	    	{
	    	wait(msec);
	    	}catch(InterruptedException e){}
	    }
}
