package com.mytest.mao.joke_demo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private PullToRefreshListView prListview;
    private List<String> listDatas;
    private int iCurPage = 1;
    private LayoutNewsItemAdapter adapter;
    private PopupWindow popuWindow;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prListview  = (PullToRefreshListView) findViewById(R.id.prlv);
        prListview.setMode(PullToRefreshBase.Mode.BOTH);//设置可以上啦又可以下拉
        listDatas = new ArrayList<>();
        adapter = new LayoutNewsItemAdapter(this,listDatas);
        prListview.setAdapter(adapter);
        setListener();
        getNews();
        onShowContent();
    }
    protected void onShowContent(){
        prListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPopuWindow(listDatas.get(position));
            }
        });

    }

    /**
     * 显示弹出框
     * @param strContent   新闻内容
     */
    protected void showPopuWindow(String strContent){

        if (popuWindow == null){
            View view = getLayoutInflater().inflate(R.layout.layout_newscontent,null);
            popuWindow = new PopupWindow(view,
                                                WindowManager.LayoutParams.MATCH_PARENT
                                                ,300,true);

            tvContent = (TextView) view.findViewById(R.id.tvNewsContent);
            popuWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        }
       // TextView tvContent = (TextView) popuWindow.getContentView().findViewById(R.id.tvNewsContent);
        tvContent.setText(strContent);
        popuWindow.showAtLocation(prListview, Gravity.BOTTOM,0,0);

    }


    private void setListener() {
            prListview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                    new MyRefeshTask().execute();

                }

                //上啦加载下一页
                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                    getNews();

                }
            });
    }

    class MyRefeshTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
            prListview.onRefreshComplete();
        }

        @Override
        protected Void doInBackground(Void... params) {
            listDatas.add(0,"");
            return null;
        }
    }


    /**
     * 把bean中提取出新闻内容,并通知listview显示出来
     * @param newsBean
     */
    protected void showNews(NewsBean newsBean){
        int iCnt = newsBean.getResult().size();
        for (int i = 0; i < iCnt; i++) {
            String strContent = newsBean.getResult().get(i).getDescription();
            listDatas.add(strContent);

        }
        adapter.notifyDataSetChanged();
        prListview.onRefreshComplete();
    }

    /**
     * 网络获取新闻
     */
    protected void getNews(){
        String strUrl = "http://api.avatardata.cn/WorldNews/Query";
        final String strRows = "50";
        final String strPage = iCurPage+"";
        iCurPage++;


        StringRequest request = new StringRequest(Request.Method.POST
                , strUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("---",response);
                        Gson gson = new Gson();
                        NewsBean newsBean = gson.fromJson(response, NewsBean.class);
                        showNews(newsBean);

                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
               // return super.getParams();
                Map<String,String> mapParams = new HashMap<>();
                mapParams.put("key","6c0496fa3a1f48d39d1a1d93c051ba35");
                mapParams.put("rows",strRows);
                mapParams.put("page",strPage);
                return mapParams;
            }
        };
        MyApplication.requestQueue.add(request);
    }



















   /* void usePost(){
        String strUrl = "http://api.1-blog.com/biz/bizserver/news/list.do ";
        final StringRequest request = new StringRequest(strUrl,     //"https://www.baidu.com/"
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("----",response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        MyApplication.requestQueue.add(request);
    }*/
}
