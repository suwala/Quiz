package sample.quiz;

import android.util.Log;


//重複しない数字をランダムに返すコンストラクタ
public class Randam_i {
	public Integer[] box=new Integer[10];
	public Randam_i(int max,int cnt){
		int i = 0;
        while(true){
        	if(i>0){
        		box[i] = (int) (Math.random()*max);
        		
        		for(int x=0;x<i;){
        			if(box[i] == box[x])
        				box[i] = (int) (Math.random()*max);
        			else;
        				x++;        			
        		}
        		i++;   
        		
        	
        	//ぶれーく
        		if(i>=cnt){
        			break;
        		}        		
        	}else{
        		box[i] = (int) (Math.random()*max);
        		i++;
        	}
        	
        }
	}
	
	public Randam_i(int max,int[] box){
		int i = 0;
		int cnt = box.length;
        while(true){
        	if(i>0){
        		box[i] = (int) (Math.random()*max);
        		
        		for(int x=0;x<i;){
        			if(box[i] == box[x])
        				box[i] = (int) (Math.random()*max);
        			else;
        				x++;        			
        		}
        		i++;   
        		
        	
        	//ぶれーく
        		if(i>=cnt){
        			break;
        		}        		
        	}else{
        		box[i] = (int) (Math.random()*max);
        		i++;
        	}
        	
        }
	}

}
