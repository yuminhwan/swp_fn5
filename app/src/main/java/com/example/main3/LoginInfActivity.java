package com.example.main3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Calendar;

//로그인 정보 보여주는 액티비티
public class LoginInfActivity extends AppCompatActivity {

    private TextView tv_id, tv_pass,tv_birth, tv_location, tv_sex, tv_name;
    private Context mContext;
    private Button button;
    private Button button1;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_inf);
        mContext = this;



        tv_id = (TextView) findViewById(R.id.tv_id);
       // tv_pass = (TextView) findViewById(R.id.tv_pass);
        tv_birth = (TextView) findViewById(R.id.tv_birth);
        tv_location = (TextView) findViewById(R.id.tv_location);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_name = (TextView)findViewById(R.id.tv_name);

        RbPreference pref = new RbPreference(mContext);
        String User_name = pref.getValue("User_name","");
        String User_id = pref.getValue("User_id", "");
        String User_pass = pref.getValue("User_pass", "");
        String User_birth = pref.getValue("User_birth", "");
        String User_sex = pref.getValue("User_sex", "");
        String User_location = pref.getValue("User_location", "");


        tv_id.setText(User_id);
        //tv_pass.setText(User_pass);
        tv_birth.setText(User_birth);
        tv_location.setText(User_location);
        tv_sex.setText(User_sex);
        tv_name.setText(User_name);

        Button button3 = findViewById(R.id.btn_logout);
        button3.findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RbPreference pref = new RbPreference(mContext);
                pref.delete();
                Toast.makeText(getApplicationContext(),"정상적으로 로그아웃 되었습니다.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginInfActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

       Button button =  findViewById(R.id.btn_sick1);
       button.findViewById(R.id.btn_sick1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RbPreference pref = new RbPreference(mContext);
                String Sick_user = pref.getValue("User_id", "");
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(LoginInfActivity.this, SickshActivity.class);
                                startActivity(intent);

                            } else {//사용할 수 없는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginInfActivity.this);
                                dialog = builder.setMessage("저장되어 있는 문진표가 없어 \n문진표를 작성해야합니다.")
                                        .setNegativeButton("작성", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(LoginInfActivity.this, SickActivity.class);
                                                startActivity(intent);
                                            }
                                        })
                                        .setPositiveButton("취소", null)
                                        .create();
                                dialog.show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };//Response.Listener 완료
                //Volley 라이브러리를 이용해서 실제 서버와 통신을 구현하는 부분
                SickshRequest sickshRequest = new SickshRequest(Sick_user, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginInfActivity.this);
                queue.add(sickshRequest);
            }
        });

        Button button1 =  findViewById(R.id.btn_mask2);
        button1.findViewById(R.id.btn_mask2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginInfActivity.this);
                RbPreference pref = new RbPreference(mContext);
                String User_birth = pref.getValue("User_birth", "");
                int check = Integer.parseInt(User_birth.substring(3,4));
                int week = 0;
                switch(check){
                    case 1 :
                    case 6 :
                        week = 2;
                        break;
                    case 2 :
                    case 7 :
                        week = 3;
                        break;
                    case 3 :
                    case 8 :
                        week = 4;;
                        break;
                    case 4 :
                    case 9 :
                        week = 5;;
                        break;
                    case 5 :
                    case 0 :
                        week = 6;;
                        break;
                    default:
                        break;
                }

                Calendar cal = Calendar.getInstance();
                int tweek = cal.get(Calendar.DAY_OF_WEEK);
                if (week == tweek){
                    dialog = builder.setMessage("오늘은 구매가능한 날입니다.\n"+
                            "\n※정보※\n출생연도 끝자리 1,6 : 월요일 구매 가능\n" +
                            "출생연도 끝자리 2,7 : 화요일 구매 가능\n" +
                            "출생연도 끝자리 3,8 : 수요일 구매 가능\n" +
                            "출생연도 끝자리 4,9 : 목요일 구매 가능\n" +
                            "출생연도 끝자리 5,0 : 금요일 구매 가능\n")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                }
                else if(tweek == 7 || tweek == 1){
                    dialog = builder.setMessage("주중에 구매하지 않았다면\n구매 가능한 날입니다.\n"+
                            "\n※정보※\n출생연도 끝자리 1,6 : 월요일 구매 가능\n" +
                            "출생연도 끝자리 2,7 : 화요일 구매 가능\n" +
                            "출생연도 끝자리 3,8 : 수요일 구매 가능\n" +
                            "출생연도 끝자리 4,9 : 목요일 구매 가능\n" +
                            "출생연도 끝자리 5,0 : 금요일 구매 가능\n")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                }
                else{
                    dialog = builder.setMessage("오늘은 구매불가능한 날입니다.\n"+
                            "\n※정보※\n출생연도 끝자리 1,6 : 월요일 구매 가능\n" +
                            "출생연도 끝자리 2,7 : 화요일 구매 가능\n" +
                            "출생연도 끝자리 3,8 : 수요일 구매 가능\n" +
                            "출생연도 끝자리 4,9 : 목요일 구매 가능\n" +
                            "출생연도 끝자리 5,0 : 금요일 구매 가능\n")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                }
                //return true;
            }
        });

    }
}

