package com.example.sangho.exam_1222;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by SangHo on 2015-12-29.
 */
public class inputAll {
    private StringBuffer stNum;
    private Character stOp;
    private Double opNum1;
    private Double opNum2;
    private calculator cal;
    private TextView plainText;
    private Context c;

    inputAll(Context context) {     // 초기화
        stNum = new StringBuffer("");   //숫자 입력 문자열 변수
        stOp = null;                    //연산자 입력 문자 변수
        plainText = new TextView(context);
        opNum1 = null;                  // 피연산자 1
        opNum2 = null;                  // 피연산자 2
        cal = new calculator();         // 계산 클래스
    }

    public String inputNum(String input) {      // 숫자 입력 메서드
        stNum.append(input);
        return stNum.toString();
    }
    public String inputOp(String input) {       // 연산자 입력 메서드
        if (input.charAt(0) == 'A') {           // 전체 클리어
            stNum.setLength(0);
            stOp=null;
            opNum2=null;
            opNum1=null;
            return stNum.toString();
        }
        else if (input.charAt(0) == 'C'){       // 부분 제거
            int length= stNum.length();
            if(length <= 0) return null;
            stNum.deleteCharAt(length - 1);
            return stNum.toString();
        }
        else if (input.charAt(0) == 'R') {      //결과 값 출력
            if (opNum2 != null)
                    opNum1 = opNum2;
            opNum2 = Double.parseDouble(stNum.toString());
            opNum1 = cal.Oper(opNum1, opNum2, stOp);
            opNum2 = null;
            stNum.setLength(0);
            return opNum1.toString();
        } else {                                // 4칙 연산
            stOp = input.charAt(0);
            if(stNum.length() != 0) {
                if (opNum1 == null)
                    opNum1 = Double.parseDouble(stNum.toString());
                else opNum2 = Double.parseDouble(stNum.toString());
            }
                stNum.setLength(0);

            return stOp.toString();
        }
    }
    public Double getOpNum1()
    {
        return opNum1;
    }
    public Double getOpNum2()
    {
        return opNum2;
    }
    public Character getStOp()
    {
        return stOp;
    }
}
