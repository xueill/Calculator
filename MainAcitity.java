package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.*;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    private StringBuilder show_equation = new StringBuilder();//显示运算式
    private ArrayList calculate_equation;//计算式
    private int signal = 0;//是否在后面继续输入
    private TextView tex;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnplus, btnsub, btnmul, btndot, btndiv, btnreset, btneq, btnback;
    /* double num1=0,num2=0;//操作数
     double result=0; //计算结果
     int op=0; //判断操作数*/
    //Stack<Double> s1 = new Stack<Double>();数字栈
    // Stack<String> s2 = new Stack<String>();符号栈

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_equation = new StringBuilder();
        calculate_equation = new ArrayList<>();
        tex = (TextView) findViewById(R.id.textView);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn9 = (Button) findViewById(R.id.btn_9);
        btnplus = (Button) findViewById(R.id.btn_plus);
        btnsub = (Button) findViewById(R.id.btn_sub);
        btnmul = (Button) findViewById(R.id.btn_mul);
        btndiv = (Button) findViewById(R.id.btn_div);
        btndot = (Button) findViewById(R.id.btn_dot);
        btnreset = (Button) findViewById(R.id.btn_reset);
        btneq = (Button) findViewById(R.id.btn_equ);
        btnback = (Button) findViewById(R.id.btn_back);


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btndot.setOnClickListener(this);
        btnreset.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btneq.setOnClickListener(this);
        btnback.setOnClickListener(this);
       /*   btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String str=tex.getText().toString();
                str+="0";
                tex.setText(str);

            }
        });

      /*  btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="1";
                tex.setText(str);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="2";
                tex.setText(str);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="3";
                tex.setText(str);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="4";
                tex.setText(str);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="5";
                tex.setText(str);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="6";
                tex.setText(str);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="7";
                tex.setText(str);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="8";
                tex.setText(str);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+="9";
                tex.setText(str);
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                str+=".";
                tex.setText(str);
            }
        });
       btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str="";
             tex.setText(str);
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(str.indexOf(" ")==str.length()-3)
               {
                   str=str.substring(0,str.length()-2);
               }
               if(str.length()>0)
               {
                   str=str.substring(0,str.length()-1);
               }
               tex.setText(str);
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(str.length()==0)
                {
                    return;
                }
                if(str.contains(" "))
                {

                }

                String str=tex.getText().toString();
                if(str.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(str);
                tex.setText(null);
                op=1;
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                if(str.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(str);
                tex.setText(null);
                op=2;
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                if(str.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(str);
                tex.setText(null);
                op=3;
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                if(str.equals(null))
                {
                    return;
                }
                num1=Double.valueOf(str);
                tex.setText(null);
                op=4;
            }
        });
        btneq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=tex.getText().toString();
                num2=Double.valueOf(str);
                tex.setText(null);
                switch(op)
                {
                    case 1:
                        result=num1+num2;
                        tex.setText(String.valueOf(result));
                        break;
                    case 2:
                        result=num1-num2;
                        tex.setText(String.valueOf(result));
                        break;
                    case 3:
                        result=num1*num2;
                        tex.setText(String.valueOf(result));
                        break;
                    case 4:
                        if(num2==0)
                        {
                            tex.setText("除数不能为0！");
                        }else{
                        result=num1/num2;
                        tex.setText(String.valueOf(result));}
                        break;
                   default:result=0;break;
                }
            }
        });*/
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                    if (signal == 0) {
                        show_equation.append(((Button) v).getText());
                        tex.setText(show_equation);
                    } else {
                        show_equation.delete(0, show_equation.length());
                        show_equation.append(((Button) v).getText());
                        tex.setText(show_equation);
                        signal = 0;
                    }
                break;
            case R.id.btn_plus:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if (!(show_equation.toString().equals(""))) {
                    signal = 0;
                    char tmp = show_equation.charAt(show_equation.length() - 1);
                    if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                        show_equation.deleteCharAt(show_equation.length() - 1);
                        show_equation.append(((Button)v).getText());
                    } else
                        show_equation.append(((Button)v).getText());
                    tex.setText(show_equation);
                }
                break;
            case R.id.btn_back:
                if (!(show_equation.toString().equals(""))) {
                    if (signal == 0) {
                        show_equation.deleteCharAt(show_equation.length() - 1);
                        tex.setText(show_equation);
                    } else {
                        show_equation.delete(0, show_equation.length());
                        tex.setText("");
                        signal = 0;
                    }
                }
                break;
            case R.id.btn_reset:
                show_equation.delete(0, show_equation.length());
                calculate_equation.clear();
                signal = 0;
                tex.setText("");
            case R.id.btn_equ:
                if (!(show_equation.toString().equals(""))) {
                    signal = 1;
                    char tmp = show_equation.charAt(show_equation.length() - 1);
                    if (show_equation.charAt(0) == '-')
                        show_equation.insert(0, "0");
                    if (tmp == '+' || tmp == '-')
                        show_equation.append("0");
                    if (tmp == '*' || tmp == '/')
                        show_equation.append("1");
                    StringBuilder temp = new StringBuilder();
                    for (int i = 0; i < show_equation.length(); i++) {
                        if (show_equation.charAt(i) >= '0' && show_equation.charAt(i) <= '9' || show_equation.charAt(i) == '.') {
                            temp.append(String.valueOf(show_equation.charAt(i)));
                        } else if (show_equation.charAt(i) == 'N') {
                            calculate_equation.add("NaN");
                            //跳过2个字符
                            i = i + 2;
                        } else if(show_equation.charAt(i)=='∞'){
                            calculate_equation.add("∞");
                        }
                        else {
                            if (temp.length() != 0) {
                                calculate_equation.add(temp.toString());
                                temp.delete(0, temp.length());
                            }
                            calculate_equation.add(String.valueOf(show_equation.charAt(i)));
                        }
                    }
                    if (temp.length() != 0) {
                        calculate_equation.add(temp.toString());
                    }
                    calculate_equation.add("#");
                    String str1 = getResult(calculate_equation);
                    tex.setText(str1);
                    show_equation.delete(0, show_equation.length());
                    calculate_equation.clear();
                    show_equation.append(str1);
                }

                break;
            case R.id.btn_dot:
                if (signal == 0) {
                    String a = show_equation.toString();
                    if (a.equals("")) {
                        show_equation.append(".");
                        tex.setText(show_equation);
                    } else {
                        int i;
                        char t = '0';
                        for (i = a.length(); i > 0; i--) {
                            t = a.charAt(i - 1);
                            if (t == '.' || t == '+' || t == '-' || t == '*' || t == '/')
                                break;
                        }
                        if (i == 0) {
                            show_equation.append(".");
                            tex.setText(show_equation);
                        } else if (t == '+' || t == '-' || t == '*' || t == '/') {
                            show_equation.append(".");
                            tex.setText(show_equation);
                        }
                    }
                } else {
                    show_equation.delete(0, show_equation.length());
                    show_equation.append(".");
                    tex.setText(".");
                    signal = 0;
                }
        }
    }

    private boolean operatorPriorityCompare(char operator1, char operator2) {
        int op1 = 0;
        int op2 = 0;
        switch (operator1) {
            case '+': {
                op1 = 0;
                break;
            }
            case '-': {
                op1 = 0;
                break;
            }
            case '*': {
                op1 = 1;
            break;
            }
            case '/': {
                op1 = 1;
                break;
            }

        }
        switch (operator2) {
            case '+': {
                op2 = 0;
                break;
            }
            case '-': {
                op2 = 0;
                break;
            }
            case '*': {
                op2 = 1;
                break;
            }
            case '/': {
                op2 = 1;
                break;
            }
        }
        if (op1 <= op2) {
            return false;
        } else
            return true;
    }

    public static Double Add(Double d1, Double d2) {
        if (d1 == Double.NEGATIVE_INFINITY || d1 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY) {
            return d1 + d2;
        }
        if (String.valueOf(d1).equals("NaN") || String.valueOf(d1).equals("NaN")) {
            return d1 + d2;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }

    //相减
    public static Double Sub(Double d1, Double d2) {
        if (d1 == Double.NEGATIVE_INFINITY || d1 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY) {
            return d1 - d2;
        }
        if (String.valueOf(d1).equals("NaN") || String.valueOf(d1).equals("NaN")) {
            return d1 - d2;
        }
        if (String.valueOf(d1).equals("NaN") || String.valueOf(d1).equals("NaN")) {
            return d1 * d2;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();
    }

    //相乘
    public static Double Mul(Double d1, Double d2) {
        if (d1 == Double.NEGATIVE_INFINITY || d1 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY) {
            return d1 * d2;
        }
        if (String.valueOf(d1).equals("NaN") || String.valueOf(d1).equals("NaN")) {
            return d1 * d2;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).setScale(8).doubleValue();
    }

    //相除
    public static Double Div(Double d1, Double d2) {
        if (d1 == Double.NEGATIVE_INFINITY || d1 == Double.POSITIVE_INFINITY || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY) {
            return d1 / d2;
        }
        if (String.valueOf(d1).equals("NaN") || String.valueOf(d1).equals("NaN")) {
            return d1 / d2;
        }
        if (d1 == 0.0 && d2 == 0.0) {
            return Double.NaN;
        }
        if (d2 == 0.0) {
            return d1 / d2;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.divide(b2, 8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public String getResult(ArrayList equation) {

        Double temp2;
        Double temp3;
        Double result;
        List operator=new ArrayList();
        List<Double> operand=new ArrayList();
        for(int i=0;i<equation.size();i++)
        {
            String temp4=(String) equation.get(i);
            if(temp4.equals("+")||temp4.equals("-")||temp4.equals("*")||temp4.equals("/"))
            {
                if(operator.size()>0)
                {
                    String temp5=operator.get(operator.size()-1).toString();
                    while(!(operatorPriorityCompare(temp4.charAt(0),temp5.charAt(0)))&&operator.size()>0)
                    {
                        operator.remove(operator.size()-1);
                        temp3=operand.get(operand.size()-1);
                        operand.remove(operand.size()-1);
                        temp2=operand.get(operand.size()-1);
                        operand.remove(operand.size()-1);
                        switch (temp5.charAt(0)){
                            case '+':{result=Add(temp2,temp3);operand.add(result);break;}
                            case '-':{result=Sub(temp2,temp3);operand.add(result);break;}
                            case '*':{result=Mul(temp2,temp3);operand.add(result);break;}
                            case '/':{result=Div(temp2,temp3);operand.add(result);break;}
                        }
                        if(operator.size()>0)
                        {
                            temp5=operator.get(operator.size()-1).toString();
                        }
                        else
                            break;
                    }
                    operator.add(temp4);
                }
                else
                    operator.add(temp4);
            }
            else if(temp4.equals("#"))
            {
                while(operator.size()>0)
                {
                    String temp6=(String)operator.get(operator.size()-1);
                    operator.remove(operator.size()-1);
                    temp3=operand.get(operand.size()-1);
                    operand.remove(operand.size()-1);
                    temp2=operand.get(operand.size()-1);
                    operand.remove(operand.size()-1);
                    switch (temp6.charAt(0)){
                        case '+':{result=Add(temp2,temp3);operand.add(result);break;}
                        case '-':{result=Sub(temp2,temp3);operand.add(result);break;}
                        case '*':{result=Mul(temp2,temp3);operand.add(result);break;}
                        case '/':{result=Div(temp2,temp3);operand.add(result);break;}
                    }
                }
            }
            else
            {
                if(temp4.equals("NaN")){
                    operand.add(Double.NaN);
                }else if(temp4.equals("∞")){
                    operand.add(Double.POSITIVE_INFINITY);
                }else{
                    operand.add(Double.parseDouble(temp4));
                }
            }
        }
        if(operand.get(0)==Double.NEGATIVE_INFINITY) return "-∞";
        if(operand.get(0)==Double.POSITIVE_INFINITY) return "∞";
        return operand.get(0).toString();

        /*  String exp =tex.getText().toString();
        int len=exp.length();
        if(exp==null||exp.equals(""))
        {
            return;
        }
        if(!exp.contains(" ")) {
            return;
        }
        if (clear_flag){
            clear_flag = false ;
            return;
        }
        clear_flag = true ;
      double result = 0 ;
        String s1 = exp.substring(0,exp.indexOf(" ")); //运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2) ;
        String s2 = exp.substring(exp.indexOf(" ")+3) ;
        if (!s1.equals(" ")&&!s2.equals(" ")){
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result = d1 + d2 ;

            }else  if (op.equals("-")){
                result = d1 - d2 ;

            }else  if (op.equals("*")){
                result = d1 * d2 ;

            }else  if (op.equals("/")){
                if(d2 == 0){
                   // result =0;
                    tex.setText("除数不能为零！");
                }else {
                    result = d1/d2 ;
                }
            }
            if (s1.contains(".")&&s2.contains(".")) { //处理小数点
                int r = (int) result;
                tex.setText(r+"");
            }else {
                tex.setText(result+"");
            }
        }else if (!s1.equals("")&&s2.equals("")){
            tex.setText(exp);
        }else if (s1.equals("")&&!s2.equals("")){
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result = 0 + d2 ;
            }else  if (op.equals("-")){
                result = 0 - d2 ;
            }else  if (op.equals("*")){
                result = 0 ;
            }else  if (op.equals("/")){
                result = 0 ;
            }
            if (s2.contains(".")) {
                int r = (int) result;
                tex.setText(r+"");
            }else {
                tex.setText(result+"");
            }
        }else {
            tex.setText("");
        }*/

    }

}
