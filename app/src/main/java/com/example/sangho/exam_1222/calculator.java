package com.example.sangho.exam_1222;

/**
 * Created by SangHo on 2015-12-30.
 */
public class calculator {
    calculator() {

    }

    public Double Oper(Double opNum1,Double opNum2,Character oper) {
        if (opNum1 == null || opNum2 == null || oper == null) {     // 변수 값들이 비어 있을경우 에러 출력
            System.out.println("nuLl error");
            return null;
        }

        switch (oper) {

            case '+':
                return opNum1 + opNum2;
            case '-':
                return opNum1 - opNum2;

            case '*':
                return opNum1 * opNum2;

            case '/':
                return opNum1 / opNum2;

        }
        return null;
    }
}
