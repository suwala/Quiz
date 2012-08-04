package sample.quiz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	static final Integer version = 1;
	static final CursorFactory factory = null;
	
	public DBHelper(Context context) {
		super(context, null, factory, version);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自動生成されたメソッド・スタブ
		
		Log.v("DB","開始");

		db.execSQL("create table 雑学("+
				" question text not null,"+
				" choices1 text not null,"+
				" choices2 text not null,"+
				" choices3 text not null,"+
				" choices4 text not null,"+
				" ans text not null"+
				");"
			);
		

		
		//db.execSQL("insert into 雑学(question,ans1,ans2,ans3,ans4) values ('正解は？','越後製菓', '越後製菓','越後製菓','越後製菓');");
		
		
//		db.execSQL("create table genre1("+
//				" question text not null"+");"
//			);
//		
//		db.execSQL("insert into genre1(question) values ('問題NOは');");
		Log.v("DB","成功");
		
		//クイズ登録
		db.execSQL("insert into 雑学(question,choices1,choices2,choices3,choices4,ans) values ('正解は？','越後製菓', '越後製菓','越後製菓','越後製菓','越後製菓');");
		
		//毎回insert~を入れるのが面倒なので引数を返すメソッドを作る
		
		//execsql(ジャンル,問題,答えを4つ渡す)　入力がまだメンドクサイ
		db.execSQL(execsql("雑学","日本で一番面積が小さい都道府県は？","香川県","沖縄県","群馬県","サイタマー!","香川県"));
		db.execSQL(execsql("雑学","X線を発見した人物は？","スケルトン","キュリー","レントゲン","ダイナマイト","レントゲン"));
		db.execSQL(execsql("雑学","甲子園球場がある都道府県は？","大阪府","京都府","島根県","兵庫県","兵庫県"));
		db.execSQL(execsql("雑学","アルファベットの由来となったものはアルファと何？","ビータ","ベータ","ベッド","ビーズ","ベータ"));
		db.execSQL(execsql("雑学","I Love Youを「月が綺麗ですね」と訳した人物は？","福沢諭吉","坂本竜馬","芥川龍之介","夏目漱石","夏目漱石"));
		db.execSQL(execsql("雑学","光速の異名を持ち重力を自在に操る高貴なる女性騎士と言えば？","エアリス","ライトニング","セリス","ジェクト","ライトニング"));
		
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	//execSQL？の引数を返すメソッド
	public String execsql(String g,String q,String a1,String a2,String a3,String a4,String a5){
		
		String re;
		//雑学+question+ans1~4が必要
		//db.execSQL("insert into 雑学(question,ans1,ans2,ans3,ans4) values ('正解は？','越後製菓', '越後製菓','越後製菓','越後製菓');");
		
		
		
		return "insert into "+g+"(question,choices1,choices2,choices3,choices4,ans) values ('"+q+"','"+a1+"', '"+a2+"','"+a3+"','"+a4+"','"+a5+"');";
		
	}
	

}
