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

    boolean q = true;	//��ʏ�Ԃ̃t���O
    Integer q_count,q_c=0;    //����萔�̃J�E���g�@DB�̃��\�b�h�ŉ����ł���H q_c = ���݂����ڂ��̕ێ�
    
    
    Integer q_syutudai = 3; //�o�萔
    
    Integer[] q_ran = new Integer[q_syutudai];//�����_���ɐ������擾���z��Ɋi�[
    
    static Integer a_c = 0; //���𐔂̃J�E���g
    String[] mondai = new String[q_syutudai]; 
    
    DBHelper dbh = new DBHelper(this);
    
    SQLiteDatabase db = dbh.getReadableDatabase();
    Cursor c = db.query("�G�w", new String[] {"question","choices1","choices2","choices3","choices4","ans"}, null,null,null,null,null);
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
        

/*        ���[�J�����Ǝg�����肪�����̂Ńt�B�[���h�ֈړ�
			oncreate��DB�J���˕����z��Ŗ�萔�����󂯎���������������������ɗD�����H
			
        DBHelper dbh = new DBHelper(this);
        
        SQLiteDatabase db = dbh.getReadableDatabase();
        Cursor c = db.query("�G�w", new String[] {"question","ans1","ans2","ans3","ans4"}, null,null,null,null,null );
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

	
	//���擾�߂����� �����_���擾�^�����ɂ�茻�ݖ��g�p
	 public void question(){
	
		 if(q_c < q_syutudai){	
        
			 //����萔��������Ɩ��炩�ɖ��ʂȓ����Ȃ��߉������K�v
			 
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
        	
        	//putExtra �C���e���g�ɒǉ��ŕ�����H��n����@putextra("keyword",String)
        	/*static�ǉ��ɂ�����������
        	i.putExtra("a_count", q_count.toString());
        	*/
        	
        	
        	//�ꉞ����
        	c.close();
        	db.close();
        	
        	//startActivity��ForResult�̈Ⴂ�́H
        	this.startActivity(i);
        }
		
	}
	
	//���������_���Ɏ擾 �����s���G���[�A��
	 public void question2(){
		 
		 if(q_c < q_syutudai){	
			 
			 
			 //�n�}���@c.move�̓I�t�Z�b�g���ݒn����̈ړ��̂���toFirst�ōŏ��̒n�_�֖߂��K�v��������
			 
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
		
		
		//q��true�̎��͖��Afalse�̎��͉񓚂��\������Ă�@�Ƃ������Ƃɂ��悤
		//���\���̎��͉񓚂̏����@�񓚕\���̎��͖��̕\����2����
		
		
		if(q){
			
			Button btn = (Button)view;
			Log.d("ddd",btn.getText().toString()+":"+c.getString(5));
			
			//������btn��text���擾��db�̓����Əƍ��@���ۂŕ���
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
				
				btn.setText("�����I");
				
				a_c++;
				q=false;
			}else{
			//�I����������
				btn = (Button) findViewById(R.id.button1);
				btn.setText("");
				btn = (Button) findViewById(R.id.button2);
				btn.setText("");
				btn = (Button) findViewById(R.id.button3);
				btn.setText("");
				btn = (Button) findViewById(R.id.button4);
				btn.setText("");
				
				
				btn = (Button)view;
		
				btn.setText("�c�O�I");

				q=false;}
		
			//isEof = c.moveToNext();
		}else{
			q_c++;
			this.question2();
			q=true;
		}
		
		//this.sleep(2000);
		
	}
	
	  //�w��~���b���s���~�߂郁�\�b�h ������Ȃ�����
	  public synchronized void sleep(long msec)
	    {	
	    	try
	    	{
	    	wait(msec);
	    	}catch(InterruptedException e){}
	    }
}
