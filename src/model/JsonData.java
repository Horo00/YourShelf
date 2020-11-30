package model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javabeans.Book;

public class JsonData extends HttpServlet implements EnvSet{

	public List<Book> getData(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//取得文字列の文字エンコード指定
				request.setCharacterEncoding("UTF-8");

				//JSPページを呼び出すためのRequestDispatcher
				RequestDispatcher rd = null;

				//gooleへ接続するため
				URL url = null;
		        HttpURLConnection con = null;

		        //検索結果データ格納用
		        List<Book> list;

				//FORMで押したボタン名の判別
				String button = request.getParameter("button_name");

				//ボタン名をにより処理を判断 "検索"の場合
				if(button.equals("検索")){
					//isbnと書名の取得
					String isbn = request.getParameter("isbn");
					String title = request.getParameter("title");

					//接続URL
					String requestUrl = null;

					//ISBNが入力されていたらISBNで検索、入力されていなかったら書名等で検索
					if(isbn.equals("")){
						//書名等で検索
						requestUrl = GOOGLE_BOOKS_API_TITLE + title;

						//disp.jspへ渡すデータを格納
			        	request.setAttribute("key", "タイトル(" + title + ")");
					}else{
						//ISBNで検索
						requestUrl = GOOGLE_BOOKS_API_ISBN + isbn;

						//disp.jspへ渡すデータを格納
			        	request.setAttribute("key", "ISBN(" + isbn +")");
					}

					//Google Books APIへの接続
					try{
						//URLConnectionの作成
						url = new URL(requestUrl);
						con = (HttpURLConnection)url.openConnection();
						con.setRequestMethod("GET");// GETリクエスト
						con.setReadTimeout(10000);	// 10秒
						con.setConnectTimeout(10000);// 10秒
					} catch (Exception e) {
						//例外発生時、error.jspへフォワードする
						request.setAttribute("error", e.toString());
						return null;
					}


					//レスポンスコードの確認
			        int responseCode = con.getResponseCode();

			        if(responseCode != HttpURLConnection.HTTP_OK){
			        	//接続を切断する
			        	con.disconnect();

			        	//レスポンスコードが200以外の場合は、error.jspへフォワードする
			        	request.setAttribute("error", "Google Books API　へのリクエストが失敗しました。レスポンスコード：" + responseCode);
			        	return null;
			        }

			        //検索結果データ(レスポンス)の取得
			        //ストリーム作成用
			        BufferedReader responseReader = null;
			        InputStreamReader isr = null;

			        //レスポンス全データ取得用
			        StringBuilder builder = new StringBuilder();

			        //レスポンスを取得するためのストリームの作成
			        isr =  new InputStreamReader(con.getInputStream());
			        responseReader = new BufferedReader(isr);

			        //レスポンスデータを1行取得する
			        String line = responseReader.readLine();

			        //nullになるまでデータを１行取り出し、builderへ追加する
			        while (line != null){
			        	builder.append(line);
			        	line = responseReader.readLine();
			        }

			        //取得したデータを文字列へ変換する
			        String responseString = builder.toString();

			        //接続を切断する
			        con.disconnect();

			        //JSONオブジェクト作成用
			        JSONObject jsonObject = null;

			        try {
			        	//取得した文字列からJSONオブジェクトを作成
			        	jsonObject = new JSONObject(responseString);

			        	//検索データ数 totalItemsを検索結果数としています
			        	//実際に検索して得られるデータは最大10個のようです
			        	int count = jsonObject.getInt("totalItems");

			        	//requestへcountを格納
			        	request.setAttribute("count", count);

			        	//検索結果0の場合、no_result.jspへフォワードする
			        	if(count == 0){
			        		rd = request.getRequestDispatcher("/no_result.jsp");
			        		rd.forward(request, response);
			        		return null;
			        	}

			        	//JSON配列itemsの取得
			        	JSONArray jsonArray = jsonObject.getJSONArray("items");

			        	//検索結果データの格納
			        	list = new ArrayList<Book>();

			        	//実際に得られるデータ数
			        	count = jsonArray.length();

			        	//取り出すデータ①本のタイトル/②作者/③出版社/④画像ＵＲＬ
			        	for (int i = 0; i < count; i++) {
			        		//各検索結果
			        		JSONObject item = jsonArray.getJSONObject(i);

			        		//volumeInfoに関するデータの取得
			        		JSONObject volumeInfo = item.getJSONObject("volumeInfo");


			        		//①titleの取得
			        		String booktitle = volumeInfo.getString("title");

			        		//②authorsの取得
			        		JSONArray authors = null;
			        		String firstAuthor = null;
			        		try{
			        			authors = volumeInfo.getJSONArray("authors");
			        			firstAuthor = authors.getString(0);
			        		}catch(JSONException e){
			        			firstAuthor = "未登録";
			        		}

			        		//③publisherの取得
			        		String publisher = null;
			        		try{
				        		publisher = volumeInfo.getString("publisher");

			        		}catch(JSONException e){
			        			publisher = "未登録";
			        		}

			        		//④画像URLの取得
			        		JSONObject imageLinks = null;
			        		String imageUrl = null;
			        		try{
			        			imageLinks = volumeInfo.getJSONObject("imageLinks");
			        			imageUrl = imageLinks.getString("thumbnail");

			        		}catch(JSONException e){
			        			imageUrl = "未登録";
			        		}

			        		//検索結果データの追加
			        		//要修正
			        		list.add(new Book(booktitle, firstAuthor, publisher, imageUrl));
			        	}

			        	//検索結果データのソート
			        	Collections.sort(list, new SortList());

			        	//disp.jspへ渡すデータを格納
			        	return list;

			        }catch(Exception e){
			        	//例外発生時、error.jspへフォワードする
			        	request.setAttribute("error", e.toString());
			        	return null;
			        }

			        //isbn_result.jspへフォワードする
				}
				//それ以外のボタン名からの場合
				else{
					//doGet()を呼び出す
//					doGet(request, response);
				}
				return null;
	}
}