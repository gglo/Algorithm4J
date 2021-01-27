package com.longfor.demo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断字段是否为数字
 * <p>
 * 有限状态自动机
 * 1 字符类型
 * 1.1 空格 ' '
 * 1.2 数字 [0-9]
 * 1.3 字符e 或者 E
 * 1.4 符号位 +、-
 * 1.5 小数点 .
 * 1.6 非法字符
 * <p>
 * 2 有限状态集合
 * 2.1 开始位置的空格
 * 2.2 幂符号前的正负号
 * 2.3 小数点前的数字
 * 2.4 小数点后的数字
 * 2.6 幂符号
 * 2.7 幂符号后的正负号
 * 2.8 幂符号后的数字
 * 2.9 结尾的空格
 * <p>
 * 3 初始化状态
 * 1、2、4
 * 结束状态
 * 4、8、9
 * 接受状态
 *
 * <p>
 * 4 转移规则
 *
 * @author wanggang
 */
public class IsNumber {

    /**
     * 有限的字符类型
     */
    enum CharType {
        /**
         * 数字
         */
        CHAR_NUMBER,

        /**
         * e
         */
        CHAR_EXP,

        /**
         * 小数点
         */
        CHAR_POINT,

        /**
         * 符号位
         */
        CHAR_SIGN,

        /**
         * 空格
         */
        CHAR_SPACE,

        /**
         * 非法字符
         */
        CHAR_ILLEGAL,
    }

    /**
     * 获取字符类型
     *
     * @param ch 带判断字符
     * @return 字符类型
     */
    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return CharType.CHAR_NUMBER;
        } else if (ch == 'e' || ch == 'E') {
            return CharType.CHAR_EXP;
        } else if (ch == '.') {
            return CharType.CHAR_POINT;
        } else if (ch == '+' || ch == '-') {
            return CharType.CHAR_SIGN;
        } else if (ch == ' ') {
            return CharType.CHAR_SPACE;
        } else {
            return CharType.CHAR_ILLEGAL;
        }
    }

    /**
     * 有限状态集合
     */
    enum State {

        /**
         * 初始化状态
         */
        STATE_INITIAL,

        /**
         * 幂符号前的正负号
         */
        STATE_INT_SIGN,

        /**
         * 小读点前数字 [0-9]
         */
        STATE_INTEGER_BEFORE_POINT,

        /**
         * 小读点后数字 [0-9]
         */
        STATE_INTEGER_AFTER_POINT,

        /**
         * 幂符号E
         */
        STATE_EXP,

        /**
         * 幂符号E右侧符号位
         */
        STATE_EXP_SIGN,

        /**
         * 幂符号E右侧数字位
         */
        STATE_EXP_NUMBER,

        /**
         * 尾部空格
         */
        STATE_END,
    }

    private final Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();

    /**
     * 初始化
     * <p>
     * 定义转移规则
     */
    private void start() {

        // 初始化状态
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER_BEFORE_POINT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
//            put(CharType.CHAR_POINT, State.STATE_INTEGER_AFTER_POINT);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);

        // 符号标识位
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER_BEFORE_POINT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        // 小读点前数字 [0-9]
        Map<CharType, State> integerBeforePointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER_BEFORE_POINT);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_INTEGER_AFTER_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER_BEFORE_POINT, integerBeforePointMap);

        // 小读点后数字 [0-9]
        Map<CharType, State> integerAfterPointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER_AFTER_POINT);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER_AFTER_POINT, integerAfterPointMap);

        // 幂符号E
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        // 幂符号E右侧符号位
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        // 幂符号E右侧数字位
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        // 尾部空格
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);
    }

    /**
     * 是否为数字
     *
     * @param s 字符串
     * @return true 数字， false 非数字
     */
    public boolean isNumber(String s) {

        this.start();
        // 初始化状态
        State state = State.STATE_INITIAL;
        for (int i = 0; i < s.length(); i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return false;
            } else {
                state = transfer.get(state).get(type);
            }
        }
        return state == State.STATE_INTEGER_BEFORE_POINT || state == State.STATE_INTEGER_AFTER_POINT || state == State.STATE_END || state == State.STATE_EXP_NUMBER;
    }


}
